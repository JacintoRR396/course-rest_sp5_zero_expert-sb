package com.sdjr2.rest_sp5_ztoe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.entities.UserInRoleEntity;

/**
 * Interface for CRUD operations on a repository for a {@link UserInRoleEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 23/01/26
 * @upgrade 23/01/27
 */
public interface UserInRoleRepository extends JpaRepository<UserInRoleEntity, Integer> {
	
	@Query("SELECT uir.user FROM UserInRoleEntity uir WHERE uir.role.name = ?1")
	List<UserEntity> findUsersByRoleName( String roleName );

}
