package com.cagdasyilmaz.bayztracker.user.repository;

import com.cagdasyilmaz.bayztracker.user.entity.Role;
import com.cagdasyilmaz.bayztracker.user.entity.RoleType;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, UUID> {
	Optional<Role> findRoleByRoleName(RoleType roleName);
}
