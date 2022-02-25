package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.user.entity.Role;
import com.cagdasyilmaz.bayztracker.user.exception.RoleDoesNotExistException;
import com.cagdasyilmaz.bayztracker.user.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName).orElseThrow(() ->
                new RoleDoesNotExistException(roleName));
    }
}
