package com.sdjr2.rest_sp5_ztoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdjr2.rest_sp5_ztoe.entities.ProfileEntity;
import com.sdjr2.rest_sp5_ztoe.services.ProfileService;

/**
 * Controller to manage Profiles of a User, it uses the service {@link ProfileService}.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 23/01/24
 * @upgrade 23/01/24
 */
@RestController
@RequestMapping("/users/{userId}/profiles")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value="/{profileId}")
	public ResponseEntity<ProfileEntity> getProfileById(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId ){
		return new ResponseEntity<>(this.profileService.getByProfileIdAndUserId(userId, profileId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProfileEntity> createProfile(@PathVariable("userId") Integer userId, @RequestBody final ProfileEntity profile) {
		return new ResponseEntity<>(this.profileService.createProfile(userId, profile), HttpStatus.CREATED);
	}

}
