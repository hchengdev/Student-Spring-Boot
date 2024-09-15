package com.studentspringboot.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
@Data
public class AppUser {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

}
