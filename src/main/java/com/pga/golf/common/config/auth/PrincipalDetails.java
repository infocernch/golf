package com.pga.golf.common.config.auth;

import com.pga.golf.golfer.domain.GolferEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {


    private GolferEntity golfer;

    public PrincipalDetails(GolferEntity golfer){this.golfer = golfer;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        golfer.getRoleList().forEach(r -> {
            authorities.add(() -> r);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return golfer.getPassword();
    }

    @Override
    public String getUsername() {
        return golfer.getId();
    }

    @Override//니 계정 만료됨?
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override//니 계정 잠김?
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override//니 계정 비번 바꿀 때 안됨?
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override//니 계정 활성화 됨?
    public boolean isEnabled() {
        return true;
    }
}
