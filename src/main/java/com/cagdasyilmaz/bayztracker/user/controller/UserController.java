package com.cagdasyilmaz.bayztracker.user.controller;

import com.cagdasyilmaz.bayztracker.user.controller.mapper.UserMapper;
import com.cagdasyilmaz.bayztracker.user.controller.model.request.RegisterUserRequest;
import com.cagdasyilmaz.bayztracker.user.service.UserService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UUID> registerUser(@RequestBody @Validated RegisterUserRequest registerUserRequest) {
		UUID userId = userService.registerUser(UserMapper.mapRegisterUserRequestToUser(registerUserRequest));
		return ResponseEntity.ok().body(userId);
	}
}
