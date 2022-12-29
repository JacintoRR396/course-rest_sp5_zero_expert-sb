package com.sdjr2.rest_sp5_ztoe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdjr2.rest_sp5_ztoe.entities.ProfileEntity;

/**
 * Interface for CRUD operations on a repository for a {@link ProfileEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 22/12/27
 */
public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer> {

}
