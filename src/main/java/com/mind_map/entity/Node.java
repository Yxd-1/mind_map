package com.mind_map.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.mind_map.dto.NodeTree;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Node implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    private String topic;

    // 主题id
    private Integer rid;

    // 如果为0即为根节点
    private Integer pid;

    private String direction;

    // 几级主题
    private Integer level;

    private Integer color;

    private String note;

    private Boolean expanded;

    // 正常为0，删除为1
    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public Node(){

    }
    public Node(NodeTree nodeTree) {
        this.id = nodeTree.getId();
        this.topic = nodeTree.getTopic();
        this.rid = nodeTree.getRid();
        this.pid = nodeTree.getPid();
        this.direction = nodeTree.getDirection();
        this.level = nodeTree.getLevel();
        this.color = nodeTree.getColor();
        this.note = nodeTree.getNote();
        this.expanded = nodeTree.getExpanded();
        this.deleted = nodeTree.getDeleted();
    }
}
