package com.cagdasyilmaz.bayztracker.user.controller.mapper;

import com.cagdasyilmaz.bayztracker.user.controller.model.request.RegisterUserRequest;
import com.cagdasyilmaz.bayztracker.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	private static ModelMapper modelMapper;

	public UserMapper(ModelMapper modelMapper) {
		UserMapper.modelMapper = modelMapper;
	}

	public static User mapRegisterUserRequestToUser(RegisterUserRequest registerUserRequest) {
		return modelMapper.map(registerUserRequest, User.class);
	}
}
