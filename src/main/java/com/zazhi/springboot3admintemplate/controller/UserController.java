package com.zazhi.springboot3admintemplate.controller;

import com.zazhi.springboot3admintemplate.pojo.dto.LoginDTO;
import com.zazhi.springboot3admintemplate.pojo.vo.UserInfoVO;
import com.zazhi.springboot3admintemplate.service.LoginService;
import com.zazhi.springboot3admintemplate.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author zazhi
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "用户")
public class UserController {
    private final LoginService loginService;

    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @GetMapping("/user/info")
    @Operation(summary = "获取用户信息")
    public UserInfoVO getUserInfo() {
        return userService.getUserInfo();
    }

    @GetMapping("/logout")
    @Operation(summary = "用户登出")
    public void logout() {
        loginService.logout();
    }
}