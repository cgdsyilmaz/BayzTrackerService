package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.user.entity.Role;
import com.cagdasyilmaz.bayztracker.user.entity.RoleType;
import java.util.Optional;

public interface RoleService {
	Optional<Role> findRoleByRoleType(RoleType type);
}
