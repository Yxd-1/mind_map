package com.mind_map.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mind_map.entity.Node;
import com.mind_map.mapper.NodeMapper;
import com.mind_map.service.NodeService;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {
}
