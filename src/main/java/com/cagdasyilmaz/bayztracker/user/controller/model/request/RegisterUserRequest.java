package com.cagdasyilmaz.bayztracker.user.controller.model.request;

import com.cagdasyilmaz.bayztracker.user.util.UserValidationConstraints;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequest {
	@NotBlank(message = UserValidationConstraints.USERNAME_BLANK_MESSAGE)
	private String username;

	@NotBlank(message = UserValidationConstraints.PASSWORD_BLANK_MESSAGE)
	private String password;

	@NotNull(message = UserValidationConstraints.IS_ADMIN_NULL_MESSAGE)
	private Boolean isAdmin;
}
