package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.authentication.model.UserDetailsImpl;
import com.cagdasyilmaz.bayztracker.user.entity.Role;
import com.cagdasyilmaz.bayztracker.user.entity.RoleType;
import com.cagdasyilmaz.bayztracker.user.entity.User;
import com.cagdasyilmaz.bayztracker.user.exception.UserAlreadyExistsException;
import com.cagdasyilmaz.bayztracker.user.exception.UserDoesNotExistException;
import com.cagdasyilmaz.bayztracker.user.repository.UserRepository;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UUID registerUser(User user) {
        validateUser(user);

        user.setUserId(UUID.randomUUID());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        addRoles(user);

        userRepository.save(user);
        return user.getUserId();
    }

    private void addRoles(User user) {
        Set<Role> roles = new HashSet<>();

        Optional<Role> userRole = roleService.findRoleByRoleType(RoleType.USER);
        userRole.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> adminRole = roleService.findRoleByRoleType(RoleType.ADMIN);
            adminRole.ifPresent(roles::add);
        }

        user.setRoles(roles);
    }

    private void validateUser(User user) {
        String username = user.getUsername();
        if (userRepository.findUserByUsername(username).isPresent()) {
            throw new UserAlreadyExistsException(username);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username).orElseThrow(() ->
            new UserDoesNotExistException(username));

        return new UserDetailsImpl(user.getUsername(), user.getPassword(), getAuthorities(user));
    }

    private Collection<? extends SimpleGrantedAuthority> getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName().name())));
        return authorities;
    }
}
