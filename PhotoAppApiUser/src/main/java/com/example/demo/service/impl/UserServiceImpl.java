package com.example.demo.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDto create(UserDto dto) {
		dto.setUserId(UUID.randomUUID().toString());
		dto.setEncryptedPassword("test");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		entity = repository.save(entity);
		return modelMapper.map(entity, UserDto.class);
	}

}
