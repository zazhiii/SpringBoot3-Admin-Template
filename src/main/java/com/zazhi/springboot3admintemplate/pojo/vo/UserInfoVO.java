package com.zazhi.springboot3admintemplate.pojo.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author zazhi
 * @date 2025/12/14
 * @description:
 */
@Data
@Builder
public class UserInfoVO {
    private Integer id;
    private String username;
    private String email;
    private String avatar;
    private List<String> permissions;
}
