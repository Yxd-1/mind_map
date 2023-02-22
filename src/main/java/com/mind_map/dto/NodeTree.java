package com.mind_map.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mind_map.entity.Node;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class NodeTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    // 主题id
    private Integer rid;

    // 如果为0即为根节点
    private Integer pid;

    // 几级主题
    private Integer level;

    private Integer color;

    private String note;

    private Integer deleted;

    private List<NodeTree> children;

    public NodeTree(Node node) {
        this.id = node.getId();
        this.name = node.getName();
        this.rid = node.getRid();
        this.pid = node.getPid();
        this.level = node.getLevel();
        this.color = node.getColor();
        this.note = node.getNote();
        this.deleted = node.getDeleted();
    }

}
