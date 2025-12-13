package com.zazhi.springboot3admintemplate.handler;

import com.alibaba.fastjson2.JSON;
import com.zazhi.springboot3admintemplate.pojo.Result;
import com.zazhi.springboot3admintemplate.utils.WebUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) {
        String jsonString = JSON.toJSONString(Result.error("认证失败"));
        WebUtil.renderString(response, jsonString);
    }
}