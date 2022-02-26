package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.user.entity.User;
import java.util.UUID;

public interface UserService {
	UUID registerUser(User user);
}
