package com.mind_map.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mind_map.common.R;
import com.mind_map.common.UserLoginToken;
import com.mind_map.dto.NodeTree;
import com.mind_map.entity.Node;
import com.mind_map.service.NodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    /**
     * 根据主题id获取节点
     * @param request
     * @return
     */
    @UserLoginToken
    @GetMapping
    public R<List<NodeTree>> list(HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        // 得到所有节点
        LambdaQueryWrapper<Node> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Node::getRid, id);
        List<Node> nodes = nodeService.list(queryWrapper);

        // 转为交互层对象列表
        List<NodeTree> nodelist = nodes.stream().map(v -> new NodeTree(v)).collect(Collectors.toList());
        // 得到树形结构
        Integer parentId = 0;
        List<NodeTree> nodeTrees = streamToTree(nodelist, parentId);

        return R.success(nodeTrees);
    }

    private List<NodeTree> streamToTree(List<NodeTree> nodelist, Integer parentId){
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
}
