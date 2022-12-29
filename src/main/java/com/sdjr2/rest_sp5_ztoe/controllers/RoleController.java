package com.sdjr2.rest_sp5_ztoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdjr2.rest_sp5_ztoe.entities.RoleEntity;
import com.sdjr2.rest_sp5_ztoe.services.RoleService;

/**
 * Controller to manage Roles.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 22/12/27
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<List<RoleEntity>> getRoles() {
		return new ResponseEntity<>(this.roleService.getRoles(), HttpStatus.OK);
	}

	@GetMapping(value = "/{roleId}")
	public ResponseEntity<RoleEntity> getRole(@PathVariable("roleId") final Integer roleId) {
		return new ResponseEntity<>(this.roleService.getRole(roleId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RoleEntity> createRole(@RequestBody final RoleEntity role) {
		return new ResponseEntity<>(this.roleService.createRole(role), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{roleId}")
	public ResponseEntity<RoleEntity> updateRole(@PathVariable("roleId") final Integer roleId,
			@RequestBody final RoleEntity role) {
		return new ResponseEntity<>(this.roleService.updateRole(roleId, role), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{roleId}")
	public ResponseEntity<Void> deleteRole(@PathVariable("roleId") final Integer roleId) {
		this.roleService.deleteRole(roleId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
