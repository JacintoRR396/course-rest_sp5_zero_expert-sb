package com.sdjr2.rest_sp5_ztoe.services;

import java.util.List;

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

	private UserEntity checkExistsUser(final Integer userId) {
		return this.userRepo.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("User with ID '%d' not found", userId)));
	}

	public UserEntity getUserById(final Integer userId) {
		return this.checkExistsUser(userId);
	}

	public UserEntity getUserByUsername(final String username) {
		return this.userRepo.findByUsername(username)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("User with Username '%s' not found", username)));
	}

	public UserEntity getUserByUsernameAndPassword(final String username, final String password) {
		return this.userRepo.findByUsernameAndPassword(username, password)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("User with Username '%s' and Password '%s' not found", username, password)));
	}

	public UserEntity createUser(final UserEntity user) {
//		this.userRepo.findByUsername(user.getUsername())
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//						String.format("User with Username '%s' already exists", user.getUsername())));
		return this.userRepo.save(user);
	}

	public UserEntity updateUser(final Integer userId, final UserEntity user) {
		this.checkExistsUser(userId);
		return this.userRepo.save(user);
	}

	public void deleteUser(final Integer userId) {
		final UserEntity userToBeDeleted = this.checkExistsUser(userId);
		this.userRepo.delete(userToBeDeleted);
	}

}
