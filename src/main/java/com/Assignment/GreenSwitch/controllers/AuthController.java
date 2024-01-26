package com.Assignment.GreenSwitch.controllers;

import com.Assignment.GreenSwitch.config.JwtHelper;
import com.Assignment.GreenSwitch.model.dtos.JwtResponse;
import com.Assignment.GreenSwitch.model.dtos.UserDto;
import com.Assignment.GreenSwitch.model.entities.UserEntity;
import com.Assignment.GreenSwitch.repository.UserRepo;
import com.Assignment.GreenSwitch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserDto request){
        return new ResponseEntity<>(userService.signUp(request),HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserDto request) {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }

}

