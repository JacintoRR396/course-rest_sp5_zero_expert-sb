package com.sdjr2.rest_sp5_ztoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.services.UserService;

import io.micrometer.core.annotation.Timed;

/**
 * Controller to manage Users, it uses the service {@link UserService}.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 22/12/28
 * @upgrade 22/12/29
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	@Timed(value = "get.users")
	public ResponseEntity<List<UserEntity>> getUsers() {
		return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/pagination")
	public ResponseEntity<Page<UserEntity>> getUsersWithPagination(
			@RequestParam(value = "page", defaultValue = "0", required = false) final int pageNum,
			@RequestParam(value = "size", defaultValue = "15", required = false) final int pageSize) {
		return new ResponseEntity<>(this.userService.getUsersWithPagination(pageNum, pageSize), HttpStatus.OK);
	}

	@GetMapping(value = "/order")
	public ResponseEntity<List<UserEntity>> getUsersWithOrder(
			@RequestParam(value = "attribute", defaultValue = "username", required = false) final String attribute,
			@RequestParam(value = "asc", defaultValue = "true", required = false) final boolean isAsc) {
		return new ResponseEntity<>(this.userService.getUsersWithOrder(attribute, isAsc), HttpStatus.OK);
	}

	@GetMapping(value = "/paginationAndOrder")
	public ResponseEntity<Page<UserEntity>> getUsersWithPaginationAndOrder(
			@RequestParam(value = "page", defaultValue = "0", required = false) final int pageNum,
			@RequestParam(value = "size", defaultValue = "15", required = false) final int pageSize,
			@RequestParam(value = "attribute", defaultValue = "username", required = false) final String attribute,
			@RequestParam(value = "asc", defaultValue = "true", required = false) final boolean isAsc) {
		return new ResponseEntity<>(
				this.userService.getUsersWithPaginationAndOrder(pageNum, pageSize, attribute, isAsc), HttpStatus.OK);
	}

	@GetMapping(value = "/usernames")
	public ResponseEntity<List<String>> getUsernames() {
		return new ResponseEntity<>(this.userService.getUsernames(), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("userId") final Integer userId) {
		return new ResponseEntity<>(this.userService.getUserById(userId), HttpStatus.OK);
	}

	@GetMapping(value = "/username/{username}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("username") final String username) {
		return new ResponseEntity<>(this.userService.getUserByUsername(username), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody final UserEntity user) {
		return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{userId}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("userId") final Integer userId,
			@RequestBody final UserEntity user) {
		return new ResponseEntity<>(this.userService.updateUser(userId, user), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") final Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "authenticate")
	public ResponseEntity<UserEntity> authenticate(@RequestBody final UserEntity user) {
		return new ResponseEntity<>(
				this.userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
	}

}
