package com.example.demo.service.impl;

import java.util.UUID;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public UserDto create(UserDto dto) {
		dto.setUserId(UUID.randomUUID().toString());
		return null;
	}

}
