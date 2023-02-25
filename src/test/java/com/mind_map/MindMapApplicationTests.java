package com.mind_map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mind_map.common.R;
import com.mind_map.dto.NodeTree;
import com.mind_map.entity.Node;
import com.mind_map.entity.Theme;
import com.mind_map.entity.User;
import com.mind_map.service.NodeService;
import com.mind_map.service.ThemeService;
import com.mind_map.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class MindMapApplicationTests {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserService userService;

    @Autowired
    private NodeService nodeService;

    @Test
    void contextLoads() {
        Theme theme = new Theme();
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Theme::getId, 2);
        themeService.remove(queryWrapper);
    }

    @Test
    void saveTheme() {
        Theme theme = new Theme();
        theme.setUid(2);
        for (int i = 10; i < 20; i++) {
            theme.setTheme("test" + i);
            themeService.save(theme);
        }
    }

    @Test
    void updateTheme() {
        Theme theme = new Theme();
        theme.setId(3);
        theme.setUid(2);
        theme.setTheme("testUpdate");
        themeService.updateById(theme);
    }

    @Test
    void deleteTheme() {
        themeService.removeById(11);
    }

    @Test
    void saveNode() {
        Node node = new Node();

        node.setId(4);
        node.setTopic("testnode222");
        node.setRid(1);
        node.setPid(3);
        node.setLevel(3);
        node.setDeleted(0);
        nodeService.updateById(node);

    }

    @Test
    void listTheme() {
        LambdaQueryWrapper<Theme> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Theme::getDeleted, 0);
        queryWrapper.eq(Theme::getUid, 1);
        queryWrapper.orderByDesc(Theme::getUpdateTime);
        List<Theme> themes = themeService.list(queryWrapper);
        System.out.println(themes);
    }

    @Test
    void listNode() {
        // 得到所有节点
        LambdaQueryWrapper<Node> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Node::getRid, 1);
        List<Node> nodes = nodeService.list(queryWrapper);

        // 转为交互层对象列表
        List<NodeTree> nodelist = nodes.stream().map(v -> new NodeTree(v)).collect(Collectors.toList());
        // 得到树形结构
        Integer parentId = 0;
        List<NodeTree> nodeTrees = streamToTree(nodelist, parentId);

        List<Node> list = new ArrayList<>();
        Stack<NodeTree> stack = new Stack<>();
        stack.push(nodeTrees.get(0));
        while (!stack.isEmpty()) {
            NodeTree node = stack.pop();
            list.add(new Node(node));

            List<NodeTree> children = node.getChildren();
            for (NodeTree child : children) {
                stack.push(child);
            }
        }
        System.out.println(list);
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

    @Test
    private void updateNode() {
        NodeTree nodelist = new NodeTree();
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
    }


    //注入redis客户端
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void test() throws InterruptedException {
        //添加key为name，value为lisi的数据，该数据6秒后过期
        /**
         *	参数1：key值
         *	参数2：value值
         *	参数3：过期时间
         *	参数4：时间单位
         */
        redisTemplate.opsForValue().set("name", "lisi", 20, TimeUnit.SECONDS);
        //从数据库中获取对应key的value
        String value = redisTemplate.opsForValue().get("name");
        System.out.println(value);

        Thread.sleep(6_000);
        value = redisTemplate.opsForValue().get("name");
        System.out.println(value);
    }


}
