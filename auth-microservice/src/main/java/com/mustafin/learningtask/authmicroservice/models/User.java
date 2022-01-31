package com.mustafin.learningtask.authmicroservice.models;

import com.mustafin.learningtask.authmicroservice.enums.Role;
import com.mustafin.learningtask.authmicroservice.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 70, nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition =  "varchar(30) default 'USER'")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition =  "varchar(30) default 'ACTIVE'")
    private Status status;
}
