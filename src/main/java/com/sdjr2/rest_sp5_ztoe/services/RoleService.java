package com.sdjr2.rest_sp5_ztoe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sdjr2.rest_sp5_ztoe.entities.RoleEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.RoleRepository;

/**
 * Service that manages business logic about Roles.
 * <p>
 * This Service maps the roles of the database layer to the business logic
 * layer.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 22/12/27
 */
@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;

	public List<RoleEntity> getRoles() {
		return this.roleRepo.findAll();
	}

	public RoleEntity getRole(final Integer roleId) {
		final Optional<RoleEntity> optRole = this.roleRepo.findById(roleId);
		if (optRole.isPresent()) {
			return optRole.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role with ID %s not found", roleId));
	}

	public RoleEntity createRole(final RoleEntity role) {
		// TODO management exception
		return this.roleRepo.save(role);
	}

	public RoleEntity updateRole(final Integer roleId, final RoleEntity role) {
		this.getRole(roleId);
		return this.roleRepo.save(role);
	}

	public void deleteRole(final Integer roleId) {
		final RoleEntity roleToBeDeleted = this.getRole(roleId);
		this.roleRepo.delete(roleToBeDeleted);
	}

}
