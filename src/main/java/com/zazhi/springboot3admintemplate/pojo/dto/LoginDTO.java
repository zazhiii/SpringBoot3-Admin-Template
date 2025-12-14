package com.zazhi.springboot3admintemplate.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 *
 * @author lixh
 * @since 2025/9/9 14:09
 */
@Data
public class LoginDTO {
    @Schema(description = "用户名", example = "admin", required = true)
    String username;
    @Schema(description = "密码", example = "admin123", required = true)
    String password;
}
