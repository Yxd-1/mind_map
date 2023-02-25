package com.mind_map.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mind_map.common.R;
import com.mind_map.common.UserLoginToken;
import com.mind_map.dto.NodeTree;
import com.mind_map.entity.Node;
import com.mind_map.service.NodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    /**
     * 根据主题id获取节点
     *
     * @param id
     * @return
     */
    @UserLoginToken
    @GetMapping
    public R<List<NodeTree>> list(@RequestParam("id") Integer id) {
        log.info("nodes list method");
        // 得到所有节点
        LambdaQueryWrapper<Node> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Node::getRid, id);
//        queryWrapper.eq(Node::getDeleted, 0);
        List<Node> nodes = nodeService.list(queryWrapper);

        // 转为交互层对象列表
        List<NodeTree> nodelist = nodes.stream().map(v -> new NodeTree(v)).collect(Collectors.toList());
        // 得到树形结构
        Integer parentId = 0;
        List<NodeTree> nodeTrees = streamToTree(nodelist, parentId);

        return R.success(nodeTrees);
    }

    private List<NodeTree> streamToTree(List<NodeTree> nodelist, Integer parentId) {
        //将列表结构转为树形结构
        List<NodeTree> list = nodelist.stream()
                // 过滤父节点
                .filter(parent -> parent.getPid().equals(parentId))
                // 把父节点children递归赋值成为子节点
                .map(child -> {
                    child.setChildren(streamToTree(nodelist, child.getId()));
                    return child;
                }).collect(Collectors.toList());
        return list;
    }


    /**
     * 保存，将修改后的思维导图批量保存
     *
     * @param nodelist
     * @return
     */
    @UserLoginToken
    @PostMapping
    public R<String> save(@RequestBody NodeTree nodelist) {
        // 没有根时的情况
        if (null == nodelist) {
            return R.error("保存失败");
        }
        // 将树形结构转为列表结构
        List<Node> list = new ArrayList<>();
        Stack<NodeTree> stack = new Stack<>();
        stack.push(nodelist);
        while (!stack.isEmpty()) {
            NodeTree node = stack.pop();
            list.add(new Node(node));

            List<NodeTree> children = node.getChildren();
            if (null == children) continue;
            Collections.reverse(children);
            for (NodeTree child : children) {
                stack.push(child);
            }
        }
        // 得到原本的所有节点
        LambdaQueryWrapper<Node> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Node::getRid, nodelist.getRid());
        List<Node> list1 = nodeService.list(queryWrapper);

        // 取交集
        List<Integer> idList1 = list1.stream()
                .map(obj -> obj.getId())
                .collect(Collectors.toList());
        List<Integer> idList2 = list.stream()
                .map(obj -> obj.getId())
                .collect(Collectors.toList());
        List<Integer> intersection = idList1.stream()
                .filter(idList2::contains)
                .collect(Collectors.toList());
        idList1.removeAll(intersection);

        // 移除多余的
        nodeService.removeByIds(idList1);

        // 若id存在，则update，若id不存在，则insert
        for (Node node : list) {
            if (null == nodeService.getById(node.getId())) {
                nodeService.save(node);
            } else {
                nodeService.updateById(node);
            }
        }

        return R.success("保存成功");
    }
}
