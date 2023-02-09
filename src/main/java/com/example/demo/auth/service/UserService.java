package com.example.demo.auth.service;

import com.example.demo.auth.model.Account;

public interface UserService
{
    public Account getUserByUserName ( String username ) throws Exception;

    public Account setUser ( Account user ) throws Exception;
}
