package com.sdjr2.rest_sp5_ztoe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdjr2.rest_sp5_ztoe.models.entities.AddressEntity;
import com.sdjr2.rest_sp5_ztoe.services.AddressService;

/**
 * {@link AddressController} class.
 * <p>
 * Controller - Manage Addresses of a Profile {@link ProfileController}.
 * <p>
 * it uses the dto {@link AddressEntity} and the service {@link AddressService}.
 *
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 23/01/24
 * @upgrade 23/01/24
 */
@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<AddressEntity>> getAddressesByProfileAndUserId(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId) {
		return new ResponseEntity<>(this.addressService.findAddressesByProfileAndUserId(userId, profileId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AddressEntity> createAddress(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId, @RequestBody final AddressEntity address) {
		return new ResponseEntity<>(this.addressService.createAddress(userId, profileId, address), HttpStatus.CREATED);
	}

}
