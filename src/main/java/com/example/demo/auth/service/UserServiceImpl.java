package com.example.demo.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.auth.erole.ERole;
import com.example.demo.auth.model.Account;
import com.example.demo.auth.model.Role;
import com.example.demo.auth.repository.AccountRepository;
import com.example.demo.auth.repository.RoleRepository;

public class UserServiceImpl implements UserService
{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @Override
    public Account getUserByUserName ( final String username ) throws Exception
    {
        return this.accountRepository.findByUsername ( username );
    }

    @Override
    public Account setUser ( final Account user ) throws Exception
    {
        // bcryptPasswordEncoder를 활용하여 비밀번호 암호화
        user.setPassword ( ( this.bcryptPasswordEncoder.encode ( user.getPassword () ) ) );
        user.setIsActive ( true );
        Role userRole = null;
        // username이 admin일 때 ADMIN 권한 할당
        if ( user.getUsername ().equals ( "admin" ) )
        {
            userRole = this.roleRepository.findByRole ( ERole.ADMIN.getValue () );
        } else
        { // 나머지 사용자 GUEST 권한 할당
            userRole = this.roleRepository.findByRole ( ERole.GUEST.getValue () );
        }

        // 위에서 받은 권한인 userRole을 setRoles로 넣기
        user.setRoles ( userRole );
        return this.accountRepository.save ( user );
    }

}
