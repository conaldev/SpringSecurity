package com.minh.service;


import com.minh.model.MyUser;
import com.minh.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthenticatedUser extends org.springframework.security.core.userdetails.User{

    private static final long serialVersionUID = 1L;
    private MyUser user;

    public AuthenticatedUser(MyUser user)
    {
        super(user.getEmail(), user.getPassword(), getAuthorities(user));
        this.user = user;
    }

    public MyUser getUser()
    {
        return user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(MyUser user)
    {
        Set<String> roleAndPermissions = new HashSet<>();
        List<Role> roles = user.getRoles();

        for (Role role : roles)
        {
            roleAndPermissions.add(role.getName());
        }
        String[] roleNames = new String[roleAndPermissions.size()];
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
        return authorities;
    }
}
