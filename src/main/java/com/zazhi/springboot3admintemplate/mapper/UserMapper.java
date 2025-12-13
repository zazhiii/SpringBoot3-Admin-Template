package com.zazhi.springboot3admintemplate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zazhi.springboot3admintemplate.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author lixh
 * @since 2025/9/9 11:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * Get permissions by user ID
     * @param userId user ID
     * @return permissions
     */
    List<String> getPermissionsByUserId(Integer userId);
}
