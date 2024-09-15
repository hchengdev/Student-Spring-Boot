package com.studentspringboot.service.appUser;

import com.studentspringboot.model.AppUser;
import com.studentspringboot.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAppUserService extends IGenerateService<AppUser>, UserDetailsService {
    Optional<AppUser> findByName(String name);
}
