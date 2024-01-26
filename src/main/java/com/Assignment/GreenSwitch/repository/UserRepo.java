package com.Assignment.GreenSwitch.repository;

import com.Assignment.GreenSwitch.model.dtos.UserDto;
import com.Assignment.GreenSwitch.model.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepo extends CrudRepository<UserEntity,Integer> {
    Optional<UserEntity> findByEmail(String email);
}
