package com.zazhi.springboot3admintemplate.service.impl;


import com.zazhi.springboot3admintemplate.constant.RedisKey;
import com.zazhi.springboot3admintemplate.pojo.dto.LoginDTO;
import com.zazhi.springboot3admintemplate.pojo.LoginUserDetails;
import com.zazhi.springboot3admintemplate.service.LoginService;
import com.zazhi.springboot3admintemplate.utils.JwtUtil;
import com.zazhi.springboot3admintemplate.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lixh
 * @since 2025/9/9 14:10
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;

    private final RedisUtil redisUtil;

    @Override
    public String login(LoginDTO loginDTO) {
        // 认证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        // 认证失败
        if(authentication == null){
            throw new RuntimeException("用户名或密码错误");
        }
        // 认证成功，使用userid生成jwt，返回给前端
        LoginUserDetails loginUserDetails = (LoginUserDetails) authentication.getPrincipal();

        // 生成jwt
        Map<String, Object> map = new HashMap<>(2);
        map.put("userId", loginUserDetails.getUser().getId());
        String jwtToken = JwtUtil.genToken(map);

        // 把完整的用户信息存入redis，userId作为key
        String key = RedisKey.format(RedisKey.LOGIN, loginUserDetails);
        redisUtil.setObject(key, loginUserDetails);

        return jwtToken;
    }

    @Override
    public void logout() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoginUserDetails loginUserDetails = (LoginUserDetails) auth.getPrincipal();
        Integer userId = loginUserDetails.getUser().getId();
        redisUtil.delete(RedisKey.format(RedisKey.LOGIN, userId));
    }
}
