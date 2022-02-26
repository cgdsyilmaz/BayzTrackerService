package com.cagdasyilmaz.bayztracker.user.service;

import com.cagdasyilmaz.bayztracker.user.entity.Role;
import com.cagdasyilmaz.bayztracker.user.entity.RoleType;
import com.cagdasyilmaz.bayztracker.user.repository.RoleRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Optional<Role> findRoleByRoleType(RoleType type) {
		return roleRepository.findRoleByRoleName(type);
	}

	@Override
	@Transactional
	public void addRole(String roleName) {
		roleRepository.save(new Role(UUID.randomUUID(), RoleType.valueOf(roleName)));
	}
}
