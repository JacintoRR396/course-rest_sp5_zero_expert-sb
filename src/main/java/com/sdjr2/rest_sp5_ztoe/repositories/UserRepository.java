package com.sdjr2.rest_sp5_ztoe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;

/**
 * Interface for CRUD operations on a repository for a {@link UserEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 22/12/27
 */
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
