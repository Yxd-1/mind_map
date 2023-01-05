package com.mind_map.dto;

import com.mind_map.entity.Node;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class NodeTree implements Serializable {

    private static final long serialVersionUID = 1L;

    private Node node;

    private List<NodeTree> children;

}
