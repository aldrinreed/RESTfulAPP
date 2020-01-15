package com.firstSpringProject.app.ws.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstSpringProject.app.ws.ui.model.request.UserLoginRequest;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.security.util.SecurityConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   11/6/2019
 * Time:   6:48 PM
 */

public class AuthFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

/*
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse)
            throws AuthenticationException {
        try {
            UserLoginRequest creds = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequest.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth)
        throws IOException, ServletException {

        String userName = ((User) auth.getPrincipal()).getUsername();
        //String tokenSecret = new SecurityConstants().getTokenSecret();

        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + SecConstants.EXP_TIME))
                .signWith(SignatureAlgorithm.HS512, SecConstants.TOKEN_SECRET)
                .compact();

        res.addHeader(SecConstants.HEADER_STRING, SecConstants.TOKEN_PREFIX + token);
    }

 */
}