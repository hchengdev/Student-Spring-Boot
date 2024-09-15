package com.studentspringboot.controller;

import com.studentspringboot.model.AppRole;
import com.studentspringboot.model.AppUser;
import com.studentspringboot.service.appUser.IAppUserService;
import com.studentspringboot.service.approle.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

import static com.studentspringboot.model.ROLE.ROLE_USER;

@Controller
public class AuthenController {
    @GetMapping("/dangky")
    public String showRegisterForm( Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IAppRoleService appRoleService;

    @PostMapping("/dangky")
    public String showLoginForm(AppUser user) {
//        set role mac dinh la user
//        AppRole appRole = appRoleService.findByName("ROLE_USER");
        AppRole appRole = appRoleService.findByName(ROLE_USER.toString());
        user.setRoles(Collections.singleton(appRole));

//        nhap password moi
        String newp = passwordEncoder.encode(user.getPassword());
        user.setPassword(newp);
        appUserService.save(user);

        return "redirect:/login";
    }

//    public String login() {
//        return "authen/login";
//    }
}

