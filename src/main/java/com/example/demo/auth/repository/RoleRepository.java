package com.example.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.auth.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>
{
    public Role findByRole ( String role );
}
