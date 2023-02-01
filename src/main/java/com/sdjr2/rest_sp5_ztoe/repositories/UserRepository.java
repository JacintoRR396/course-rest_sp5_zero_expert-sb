package com.sdjr2.rest_sp5_ztoe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdjr2.rest_sp5_ztoe.models.entities.UserEntity;

/**
 * {@link UserRepository} class.
 * <p>
 * Interface for CRUD operations on a repository for a {@link UserEntity}.
 *
 * @author jroldan
 * @version 1.0
 * @category Repository
 * @since 22/12/27
 * @upgrade 22/12/29
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByUsername(String usename);

	public Optional<UserEntity> findByUsernameAndPassword(String usename, String password);

	@Query("SELECT u.username FROM UserEntity u ")
	public List<String> findAllUserNames();

}
