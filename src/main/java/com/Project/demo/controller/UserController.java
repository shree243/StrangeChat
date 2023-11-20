package com.Project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.demo.entity.User;
import com.Project.demo.entity.UserRegistrationDetails;
import com.Project.demo.entity.UserResponse;
import com.Project.demo.entity.userRequestDto;
import com.Project.demo.serviceImpl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/user/findAll")
	public List<User> findAll() {
		return userServiceImpl.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/lat/long")
	public List<UserResponse> getLat(@RequestBody userRequestDto entity) {
		return userServiceImpl.getLat(entity);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/saveUser")
	public User save(@RequestBody String Userentity) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		UserRegistrationDetails userRegistrationDetails = null;
		userRegistrationDetails = objectMapper.readValue(Userentity, UserRegistrationDetails.class);
		return userServiceImpl.save(userRegistrationDetails);
	}

	@PostMapping("/user/update")
	public User update(@RequestBody User entity) {
		return userServiceImpl.update(entity);
	}

	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userServiceImpl.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/findByUserName")
	public User getOne(@RequestBody String userName) {
		return userServiceImpl.getUser(userName);
	}

}
