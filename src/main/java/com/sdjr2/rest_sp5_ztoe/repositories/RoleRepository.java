package com.sdjr2.rest_sp5_ztoe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjr2.rest_sp5_ztoe.models.entities.RoleEntity;

/**
 * {@link RoleRepository} class.
 * <p>
 * Interface for CRUD operations on a repository for a {@link RoleEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 22/12/27
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
