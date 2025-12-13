package com.zazhi.springboot3admintemplate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zazhi.springboot3admintemplate.pojo.RoleAndPermission;
import com.zazhi.springboot3admintemplate.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author lixh
 * @since 2025/9/9 11:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * Get roles and permissions by user ID
     * @param userId user ID
     * @return roles and permissions
     */
    RoleAndPermission getRolesAndPermissions(Integer userId);
}
