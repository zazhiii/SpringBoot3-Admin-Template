package com.zazhi.springboot3admintemplate.service.impl;

import com.zazhi.springboot3admintemplate.mapper.UserMapper;
import com.zazhi.springboot3admintemplate.pojo.entity.User;
import com.zazhi.springboot3admintemplate.pojo.vo.UserInfoVO;
import com.zazhi.springboot3admintemplate.service.UserService;
import com.zazhi.springboot3admintemplate.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zazhi
 * @date 2025/12/14
 * @description:
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

//    TODO: cache
    @Override
    public UserInfoVO getUserInfo() {
        Integer userId = SecurityUtil.getCurrentUserId();
        User user = userMapper.selectById(userId);
        List<String> permissions = userMapper.getPermissionsByUserId(userId);
        return UserInfoVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .permissions(permissions)
                .build();
    }
}
