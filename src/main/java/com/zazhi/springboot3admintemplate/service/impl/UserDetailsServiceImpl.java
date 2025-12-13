package com.zazhi.springboot3admintemplate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zazhi.springboot3admintemplate.mapper.UserMapper;
import com.zazhi.springboot3admintemplate.pojo.LoginUserDetails;
import com.zazhi.springboot3admintemplate.pojo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author lixh
 * @since 2025/9/9 11:56
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户
        User user = userMapper.selectOne(
                new LambdaQueryWrapper<User>()
                        .eq(User::getUsername, username)
        );
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }

        // 获取用户的角色和权限
        List<String> permissions = userMapper.getPermissionsByUserId(user.getId());
        return new LoginUserDetails(user, permissions);
    }
}
