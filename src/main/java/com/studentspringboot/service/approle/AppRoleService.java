package com.studentspringboot.service.approle;

import com.studentspringboot.model.AppRole;
import com.studentspringboot.model.AppUser;
import com.studentspringboot.model.UserPrinciple;
import com.studentspringboot.repository.AppRoleRepo;
import com.studentspringboot.repository.AppUserRepo;
import com.studentspringboot.service.appUser.AppUserService;
import com.studentspringboot.service.appUser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppRoleService implements IAppRoleService {

    @Autowired
    private AppRoleRepo appRoleRepo;

    @Override
    public AppRole findByName(String name) {
        return appRoleRepo.findByName(name);
    }

    @Override
    public Iterable<AppRole> findAll() {
        return appRoleRepo.findAll();
    }

    @Override
    public void save(AppRole appRole) {
        appRoleRepo.save(appRole);
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return appRoleRepo.findById(id);
    }

    @Override
    public void remove(Long id) {
        appRoleRepo.deleteById(id);
    }
}
