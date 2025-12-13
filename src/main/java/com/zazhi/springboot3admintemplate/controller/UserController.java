package com.zazhi.springboot3admintemplate.controller;

import com.zazhi.springboot3admintemplate.pojo.LoginDTO;
import com.zazhi.springboot3admintemplate.service.LoginService;
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

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    @GetMapping("/logout")
    public void logout() {
        loginService.logout();
    }
}