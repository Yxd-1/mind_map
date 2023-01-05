package com.mind_map.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户登录信息
 */

@Data
@ToString
public class TokenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer adminId;

    private String token;
}
