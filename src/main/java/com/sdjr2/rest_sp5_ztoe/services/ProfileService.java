package com.sdjr2.rest_sp5_ztoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sdjr2.rest_sp5_ztoe.entities.ProfileEntity;
import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
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
	private ProfileRepository profileRepo;

	@Autowired
	private UserService userService;

	public ProfileEntity getByProfileIdAndUserId(Integer userId, Integer profileId) {
		return this.profileRepo.findByUserIdAndProfileId(userId, profileId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Profile with ID '%d' for User with ID '%d' not found", profileId, userId)));
	}

	public ProfileEntity createProfile(Integer userId, final ProfileEntity profile) {
		UserEntity userDB = this.userService.getUserById(userId);
		profile.setUser(userDB);
		return this.profileRepo.save(profile);
	}

}
