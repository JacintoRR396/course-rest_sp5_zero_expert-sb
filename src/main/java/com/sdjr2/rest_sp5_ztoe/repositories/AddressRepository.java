package com.sdjr2.rest_sp5_ztoe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdjr2.rest_sp5_ztoe.models.entities.AddressEntity;

/**
 * {@link AddressRepository} class.
 * <p>
 * Repository - Interface for CRUD operations on a repository JPA for a {@link AddressEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 22/12/27
 * @upgrade 23/01/24
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
	
	@Query("SELECT a FROM AddressEntity a WHERE a.profile.user.id=?1 AND a.profile.id=?2")
	List<AddressEntity> findByProfileAndUserId(Integer userId, Integer profileId);

}
