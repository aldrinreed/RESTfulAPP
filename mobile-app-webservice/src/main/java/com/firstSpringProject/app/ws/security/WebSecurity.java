package com.firstSpringProject.app.ws.security;

import com.firstSpringProject.app.ws.services.userService;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;


/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/30/2019
 * Time:   2:31 PM
 */

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final userService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(userService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, SecConstants.SIGN_UP_URL)
        .permitAll().anyRequest().authenticated().and().addFilter(new AuthenticationFilterFilter(authenticationManager()));
    }
    */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}
