package com.studentspringboot.configuration;

import com.studentspringboot.controller.StudentSuccessHandle;
import com.studentspringboot.service.appUser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private IAppUserService appUserService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    //    xac thuc
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
//        tiem app user service
        dao.setUserDetailsService(appUserService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

    @Bean
    public StudentSuccessHandle customSuccessHandle() {
        return new StudentSuccessHandle();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorize -> authorize.requestMatchers("/error_404", "/css/**", "/js/**", "/images/**", "/dangky").permitAll()
                                .requestMatchers(HttpMethod.POST, "/dangky").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .successHandler(customSuccessHandle()));
        return httpSecurity.build();
    }
}

