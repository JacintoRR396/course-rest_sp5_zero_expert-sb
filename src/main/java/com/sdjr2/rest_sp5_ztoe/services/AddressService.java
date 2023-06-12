package com.sdjr2.rest_sp5_ztoe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjr2.rest_sp5_ztoe.models.entities.AddressEntity;
import com.sdjr2.rest_sp5_ztoe.models.entities.ProfileEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.AddressRepository;

/**
 * {@link AddressService} class.
 * <p>
 * Service - Manages business logic about Addresses, it uses the repository
 * {@link AddressRepository} and the service {@link ProfileService}.
 * <p>
 * This Service maps the addresses of the database layer {@link AddressEntity} to
 * the business logic layer and viceversa.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 23/01/24
 * @upgrade 23/01/24
 */
@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private ProfileService profileService;

	public List<AddressEntity> findAddressesByProfileAndUserId(Integer userId, Integer profileId) {
		return this.addressRepo.findByProfileAndUserId(userId, profileId);
	}

	public AddressEntity createAddress(Integer userId, Integer profileId, AddressEntity address) {
		ProfileEntity profileDB = this.profileService.getByProfileIdAndUserId(userId, profileId);
		address.setProfile(profileDB);
		return this.addressRepo.save(address);
	}

}
