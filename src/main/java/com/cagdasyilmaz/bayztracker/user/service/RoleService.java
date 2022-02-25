package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.user.entity.Role;

public interface RoleService {
    Role findRoleByRoleName(String roleName);
}