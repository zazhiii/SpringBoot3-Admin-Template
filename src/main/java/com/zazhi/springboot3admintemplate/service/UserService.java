package com.zazhi.springboot3admintemplate.service;

import com.zazhi.springboot3admintemplate.pojo.vo.UserInfoVO;

/**
 *
 * @author lixh
 * @since 2025/12/14 15:36
 */
public interface UserService {
    /**
     * Get user information
     * @return user information
     */
    UserInfoVO getUserInfo();
}
