package com.zazhi.springboot3admintemplate.utils;

import com.zazhi.springboot3admintemplate.pojo.LoginUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {

    public static LoginUserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof LoginUserDetails)) {
            return null;
        }
        return (LoginUserDetails) auth.getPrincipal();
    }

    public static Integer getCurrentUserId() {
        LoginUserDetails user = getCurrentUser();
        if(user == null || user.getUser() == null){
            return null;
        }
        return user.getUser().getId();
    }
}
