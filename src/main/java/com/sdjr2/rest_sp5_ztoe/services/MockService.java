package com.sdjr2.rest_sp5_ztoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.UserRepository;

/**
 * Service that manages mock about Data.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 22/12/28
 */
@Service
public class MockService {

	@Autowired
	private Faker faker;

	@Autowired
	private UserRepository userRepository;

	public void mockUsers() {
		final int size = 100;
		for (int i = 0; i < size; i++) {
			final UserEntity user = new UserEntity();
			user.setUsername(this.faker.name().username());
			user.setPassword(this.faker.dragonBall().character());
			this.userRepository.save(user);
		}
	}

}
