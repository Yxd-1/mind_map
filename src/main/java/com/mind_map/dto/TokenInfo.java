package com.mind_map.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 用户登录信息
 */

@Data
@ToString
public class TokenInfo {

    private Integer adminId;
    private String token;
}
