package com.example.serverTest.global.jwt;

import com.example.serverTest.domain.user.dto.User;
import com.example.serverTest.global.auth.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserSecurityImpl implements UserSecurity{

    @Override
    public User getUser() {
        return ((CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUser();
    }

}
