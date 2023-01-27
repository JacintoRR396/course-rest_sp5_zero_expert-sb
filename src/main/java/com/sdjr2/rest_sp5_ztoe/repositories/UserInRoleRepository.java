package com.sdjr2.rest_sp5_ztoe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjr2.rest_sp5_ztoe.entities.UserInRoleEntity;

/**
 * Interface for CRUD operations on a repository for a {@link UserInRoleEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 23/01/26
 */
public interface UserInRoleRepository extends JpaRepository<UserInRoleEntity, Integer> {

}
