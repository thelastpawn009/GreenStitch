package com.Assignment.GreenSwitch.service;

import com.Assignment.GreenSwitch.model.dtos.JwtAuthenticationResponse;
import com.Assignment.GreenSwitch.model.dtos.JwtResponse;
import com.Assignment.GreenSwitch.model.dtos.UserDto;

public interface UserService {
    String signUp(UserDto user);
    JwtResponse login(UserDto user);
}
