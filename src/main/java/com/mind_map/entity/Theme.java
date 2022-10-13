package com.mind_map.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long uuid;

    private Integer id;

    private String name;

    private Integer parent;

    private Integer children;

}
