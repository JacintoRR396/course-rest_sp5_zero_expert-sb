package com.sdjr2.rest_sp5_ztoe.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sdjr2.rest_sp5_ztoe.models.SecurityRule;
import com.sdjr2.rest_sp5_ztoe.models.entities.RoleEntity;
import com.sdjr2.rest_sp5_ztoe.models.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.RoleRepository;
import com.sdjr2.rest_sp5_ztoe.repositories.UserInRoleRepository;

/**
 * {@link RoleService} class.
 * <p>
 * Service - Manages business logic about Roles, it uses the repository
 * {@link RoleRepository} and the service {@link UserInRoleRepository}.
 * <p>
 * This Service maps the roles of the database layer to the business logic
 * layer.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 22/12/27
 * @upgrade 23/01/30
 */
@Service
public class RoleService {

	private static final Logger log = LoggerFactory.getLogger( RoleService.class );

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserInRoleRepository userInRoleRepo;

	@SecurityRule
	public List<RoleEntity> getRoles() {
		log.info( "getRoles()." );
		return this.roleRepo.findAll();
	}

	@Secured({"ROLE_ADMIN"})
	public List<UserEntity> getUsersByRole( String roleName ) {
		log.info( "getUsersByRole() with roleName '{}'.", roleName );
		return this.userInRoleRepo.findUsersByRoleName(roleName);
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
