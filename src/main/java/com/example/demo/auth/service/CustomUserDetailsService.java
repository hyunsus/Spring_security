package com.example.demo.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.auth.model.Account;

import jakarta.annotation.Resource;

@Service
// UserDetailsService - 내부적으로 사용자의 인증을 수행할 때 사용하는 인터페이스
public class CustomUserDetailsService implements UserDetailsService
{
    protected Logger log = LoggerFactory.getLogger ( this.getClass () );
    @Resource ( name = "userServiceImpl" )
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername ( final String username ) throws UsernameNotFoundException
    {
        this.log.debug ( "[ykson] call the loadUserByUsername()" );
        Account user = null;
        try
        {
            user = this.userService.getUserByUserName ( username );

            if ( user != null )
            {
                return new User ( user );
            }
        } catch ( final Exception e )
        {
            this.log.error ( e.getMessage () );
            throw new UsernameNotFoundException ( e.getMessage () );
        }
        return null;
    }

}
