package com.example.demo.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table ( name = "roles" )
public class Role
{
    @Id
    private String roleid;

    private String role;
}
