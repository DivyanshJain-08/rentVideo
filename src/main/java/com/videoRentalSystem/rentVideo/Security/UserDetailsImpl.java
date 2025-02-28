package com.videoRentalSystem.rentVideo.Security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.videoRentalSystem.rentVideo.Entity.User;

public class UserDetailsImpl implements UserDetails 
{
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    @Autowired
    public UserDetailsImpl(User user) 
    {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return authorities;
    }

    @Override
    public String getPassword() 
    {
        return password;
    }

    @Override
    public String getUsername() 
    {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
