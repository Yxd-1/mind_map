package com.mind_map.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 用户登录信息
 */

@Data
@ToString
public class TokenInfo {

    private Long adminId;
    private String token;
}
