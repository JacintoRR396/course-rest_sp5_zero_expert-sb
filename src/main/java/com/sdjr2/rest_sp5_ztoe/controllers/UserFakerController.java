/**
 *
 */
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdjr2.rest_sp5_ztoe.models.UserFaker;
import com.sdjr2.rest_sp5_ztoe.services.UserFakerService;

/**
 * Controller to manage Java Faker External API.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 22/12/26
 */
@RestController
@RequestMapping("/users/faker")
public class UserFakerController {

	@Autowired
	private UserFakerService userService;

	@GetMapping
	public ResponseEntity<List<UserFaker>> getUsers(
			@RequestParam(value = "startWith", required = false) final String startWith) {
		return new ResponseEntity<>(this.userService.getUsers(startWith), HttpStatus.OK);
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<UserFaker> getUser(@PathVariable("username") final String username) {
		return new ResponseEntity<>(this.userService.getUser(username), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserFaker> createUser(@RequestBody final UserFaker user) {
		return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{username}")
	public ResponseEntity<UserFaker> updateUser(@PathVariable("username") final String username,
			@RequestBody final UserFaker user) {
		return new ResponseEntity<>(this.userService.updateUser(username, user), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") final String username) {
		this.userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
