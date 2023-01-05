package com.mind_map.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Node implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer rid;

    private Integer pid;

    private Integer level;

    private Integer color;

    private String note;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
