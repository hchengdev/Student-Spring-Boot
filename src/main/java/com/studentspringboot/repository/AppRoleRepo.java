package com.studentspringboot.repository;

import com.studentspringboot.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
