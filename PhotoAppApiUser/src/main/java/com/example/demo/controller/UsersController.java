package com.example.demo.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	@Autowired
	private UserService service;

	@GetMapping("/status/check")
	public String status() {
		return "It's working in... " + env.getProperty("local.server.port");
	}
	
	
	@PostMapping
	public ResponseEntity<UserDto> createNew(@RequestBody @Valid UserModel userModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto dto = modelMapper.map(userModel, UserDto.class);
		service.create(dto);
		return new ResponseEntity<UserDto>(dto, HttpStatus.CREATED);
	}
}
