package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto create(UserDto dto);
	UserDto getUserDetailsByEmail(String email);
}
