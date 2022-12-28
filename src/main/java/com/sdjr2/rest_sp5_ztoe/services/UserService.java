package com.sdjr2.rest_sp5_ztoe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.UserRepository;

/**
 * Service that manages business logic about Users.
 * <p>
 * This Service maps the roles of the database layer {@link UserEntity} to the
 * business logic layer and viceversa.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 22/12/28
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<UserEntity> getUsers() {
		return this.userRepo.findAll();
	}

	private UserEntity checkExistsUser(final Integer userId, final boolean isCreate) {
		final Optional<UserEntity> optRole = this.userRepo.findById(userId);
		if (optRole.isPresent()) {
			if (isCreate) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("User with ID %s already exists", userId));
			}
			return optRole.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with ID %s not found", userId));
		}
	}

	public UserEntity getUser(final Integer userId) {
		return this.checkExistsUser(userId, false);
	}

	public UserEntity createUser(final UserEntity user) {
		// TODO this.checkExistsUser(user.getId(), true);
		return this.userRepo.save(user);
	}

	public UserEntity updateUser(final Integer userId, final UserEntity user) {
		this.checkExistsUser(userId, false);
		return this.userRepo.save(user);
	}

	public void deleteUser(final Integer userId) {
		final UserEntity userToBeDeleted = this.checkExistsUser(userId, false);
		this.userRepo.delete(userToBeDeleted);
	}

}
