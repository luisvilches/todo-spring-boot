package com.bukitech.taskmaster.controllers;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.bukitech.taskmaster.classes.AuthRequest;
import com.bukitech.taskmaster.models.UserModel;
import com.bukitech.taskmaster.security.JwtUtils;
import com.bukitech.taskmaster.services.CustomUserDetailsService;
import com.bukitech.taskmaster.services.UserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            System.out.println("USER: " + authRequest.getUsername() + " PASS: " + authRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtils.generateToken(userDetails.getUsername());
    }

    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user) {
        UserModel data = new UserModel();
        data.setName(user.getName());
        data.setLastname(user.getLastname());
        data.setEmail(user.getEmail());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        data.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.create(data);
    }
}
