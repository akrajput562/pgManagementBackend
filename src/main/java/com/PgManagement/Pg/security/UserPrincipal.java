package com.PgManagement.Pg.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.PgManagement.Pg.user.entity.MstUser;

public class UserPrincipal implements UserDetails {
    private MstUser user;

    public UserPrincipal(MstUser user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return List.of(new SimpleGrantedAuthority(user.getRole_id()));
        return List.of(new SimpleGrantedAuthority("owner"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}