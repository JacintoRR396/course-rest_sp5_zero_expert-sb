package com.sdjr2.rest_sp5_ztoe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdjr2.rest_sp5_ztoe.entities.AddressEntity;

/**
 * Interface for CRUD operations on a repository for a {@link AddressEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 22/12/27
 */
public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

}
