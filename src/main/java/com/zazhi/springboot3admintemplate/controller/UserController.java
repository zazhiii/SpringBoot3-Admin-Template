package com.zazhi.springboot3admintemplate.controller;

import com.zazhi.springboot3admintemplate.pojo.dto.LoginDTO;
import com.zazhi.springboot3admintemplate.pojo.vo.UserInfoVO;
import com.zazhi.springboot3admintemplate.service.LoginService;
import com.zazhi.springboot3admintemplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author zazhi
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final LoginService loginService;

    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @GetMapping("/user/info")
    public UserInfoVO getUserInfo() {
        return userService.getUserInfo();
    }

    @GetMapping("/logout")
    public void logout() {
        loginService.logout();
    }
}