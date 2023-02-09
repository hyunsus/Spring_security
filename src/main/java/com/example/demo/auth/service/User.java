package com.example.demo.auth.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.auth.model.Role;

public class User implements UserDetails
{
    private Role role;

    public User ( final User user )
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities ()
    {
        final Collection<GrantedAuthority> collect = new ArrayList<> ();
        collect.add ( new SimpleGrantedAuthority ( this.role.getRole () ) );
        return collect;
    }

    @Override
    public String getPassword ()
    {
        return null;
    }

    @Override
    public String getUsername ()
    {
        return null;
    }

    @Override
    public boolean isAccountNonExpired ()
    {
        return false;
    }

    @Override
    public boolean isAccountNonLocked ()
    {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired ()
    {
        return false;
    }

    @Override
    public boolean isEnabled ()
    {
        return false;
    }

}
