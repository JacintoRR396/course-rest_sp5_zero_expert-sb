package com.sdjr2.rest_sp5_ztoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjr2.rest_sp5_ztoe.entities.ProfileEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.ProfileRepository;

/**
 * Service that manages business logic about Profiles, it uses the repository
 * {@link ProfileRepository}.
 * <p>
 * This Service maps the profiles of the database layer {@link ProfileEntity} to
 * the business logic layer and viceversa.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 23/01/24
 * @upgrade 23/01/24
 */
@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserService userService;

	public ProfileEntity createProfile(Integer userId, final ProfileEntity profile) {
		this.userService.getUserById(userId);
		return this.profileRepository.save(profile);
	}

}