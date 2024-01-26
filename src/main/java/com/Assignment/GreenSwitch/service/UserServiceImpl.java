package com.Assignment.GreenSwitch.service;

import com.Assignment.GreenSwitch.config.JwtHelper;
import com.Assignment.GreenSwitch.controllers.AuthController;
import com.Assignment.GreenSwitch.model.dtos.JwtResponse;
import com.Assignment.GreenSwitch.model.dtos.UserDto;
import com.Assignment.GreenSwitch.model.entities.UserEntity;
import com.Assignment.GreenSwitch.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtHelper helper;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Override
    public String signUp(UserDto request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());
        userRepo.save(userEntity);
        return "SignUp Successful";
    }

    @Override
    public JwtResponse login(UserDto request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .email(userDetails.getUsername()).build();
        return response;
    }
    private void doAuthenticate(String email, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        Optional<UserEntity> userByEmail = userRepo.findByEmail(userEntity.getEmail());
        if(userByEmail.isPresent() && userByEmail.get().getEmail().equals(userEntity.getEmail()) && userByEmail.get().getPassword().equals(userEntity.getPassword())){
            logger.info("Authenticated");
        }
        else {
            throw new BadCredentialsException("Invalid UserName and password");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
