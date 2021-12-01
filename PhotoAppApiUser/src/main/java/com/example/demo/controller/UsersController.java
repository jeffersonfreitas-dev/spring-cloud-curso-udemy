package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment env;

	@GetMapping("/status/check")
	public String status() {
		return "It's working in... " + env.getProperty("local.server.port");
	}
	
	
	@PostMapping
	public String createNew(@RequestBody @Valid UserModel userModel) {
		return "Create";
	}
}
