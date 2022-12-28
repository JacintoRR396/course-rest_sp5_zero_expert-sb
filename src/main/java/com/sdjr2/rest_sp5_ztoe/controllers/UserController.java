package com.sdjr2.rest_sp5_ztoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.services.UserService;

/**
 * Controller to manage Users.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 22/12/28
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserEntity>> getUsers() {
		return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("userId") final Integer userId) {
		return new ResponseEntity<>(this.userService.getUser(userId), HttpStatus.OK);
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

}
