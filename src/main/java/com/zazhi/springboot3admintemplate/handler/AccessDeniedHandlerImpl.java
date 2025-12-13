package com.zazhi.springboot3admintemplate.handler;

import com.alibaba.fastjson2.JSON;
import com.zazhi.springboot3admintemplate.pojo.result.Result;
import com.zazhi.springboot3admintemplate.utils.WebUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) {
        String jsonString = JSON.toJSONString(Result.error("权限不足"));
        WebUtil.renderString(httpServletResponse, jsonString);
    }
}