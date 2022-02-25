package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.user.entity.User;

public interface UserService {
    User getUserByUsername(String username);
}
