/**
 *
 */
package com.sdjr2.rest_sp5_ztoe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.sdjr2.rest_sp5_ztoe.models.UserFaker;

import jakarta.annotation.PostConstruct;

/**
 * Service that manages business logic about Users Faker.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 22/12/26
 */
@Service
public class UserFakerService {

	@Autowired
	private Faker faker;

	private final List<UserFaker> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 6; i++) {
			this.users.add(new UserFaker(this.faker.funnyName().name(), this.faker.name().username(),
					this.faker.dragonBall().character()));
		}
	}

	public List<UserFaker> getUsers(final String startWith) {
		if (startWith != null) {
			return this.users.stream().filter(u -> u.getUsername().startsWith(startWith)).collect(Collectors.toList());
		} else {
			return this.users;
		}
	}

	public UserFaker getUser(final String username) {
		return this.users.stream().filter(u -> u.getUsername().equals(username)).findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("User %s not found", username)));
	}

	public UserFaker createUser(final UserFaker user) {
		if (this.users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format("User %s already exists", user.getUsername()));

		}
		this.users.add(user);
		return user;
	}

	public UserFaker updateUser(final String username, final UserFaker user) {
		final UserFaker userToBeUpdated = this.getUser(username);
		userToBeUpdated.setNickName(user.getNickName());
		userToBeUpdated.setPassword(user.getPassword());
		return userToBeUpdated;
	}

	public void deleteUser(final String username) {
		final UserFaker userToBeDeleted = this.getUser(username);
		this.users.remove(userToBeDeleted);
	}

}
