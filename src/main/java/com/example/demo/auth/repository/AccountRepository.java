package com.example.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.auth.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>
{
    public Account findByUsername ( String username );
}
