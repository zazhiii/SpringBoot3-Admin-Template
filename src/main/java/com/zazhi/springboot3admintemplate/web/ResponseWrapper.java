package com.zazhi.springboot3admintemplate.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zazhi.springboot3admintemplate.pojo.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ResponseWrapper implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getParameterType().equals(Result.class);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // 排除 Knife4j / Swagger
        String path = request.getURI().getPath();
        if (path.startsWith("/v3/api-docs")
                || path.startsWith("/swagger")
                || path.startsWith("/doc.html")
                || path.startsWith("/webjars")) {
            return body;
        }

        // String 特判
        if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            try {
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return Result.success(body);
    }
}
