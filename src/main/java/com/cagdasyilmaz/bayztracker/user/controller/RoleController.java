package com.cagdasyilmaz.bayztracker.user.controller;

import com.cagdasyilmaz.bayztracker.user.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {
	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/add/{roleName}")
	public ResponseEntity<String> addRole(@PathVariable String roleName) {
		roleService.addRole(roleName.toUpperCase());
		return ResponseEntity.ok().build();
	}
}
