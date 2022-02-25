package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.authentication.model.UserDetailsImpl;
import com.cagdasyilmaz.bayztracker.user.entity.User;
import com.cagdasyilmaz.bayztracker.user.exception.UserDoesNotExistException;
import com.cagdasyilmaz.bayztracker.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() ->
                new UserDoesNotExistException(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        return new UserDetailsImpl(user);
    }
}
