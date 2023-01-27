package com.sdjr2.rest_sp5_ztoe.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.sdjr2.rest_sp5_ztoe.entities.RoleEntity;
import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;
import com.sdjr2.rest_sp5_ztoe.entities.UserInRoleEntity;
import com.sdjr2.rest_sp5_ztoe.repositories.RoleRepository;
import com.sdjr2.rest_sp5_ztoe.repositories.UserInRoleRepository;
import com.sdjr2.rest_sp5_ztoe.repositories.UserRepository;

/**
 * Service that manages mock about Data.
 *
 * @author jroldan
 * @version 1.0
 * @category Service
 * @since 22/12/28
 * @upgrade 23/01/27
 */
@Service
public class MockService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private Faker faker;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserInRoleRepository userInRoleRepository;
	
	public void mockRoles() {
		List<RoleEntity> roles = Arrays.asList( new RoleEntity("ADMIN"), new RoleEntity("SUPPORT"), new RoleEntity("USER") );
		roles.stream().forEach( role -> this.roleRepository.save( role ) );
	}

	public void mockUsers() {
		this.mockRoles();
		
		final int size = 15;
		for ( int i = 0; i < size; i++ ) {
			final UserEntity user = new UserEntity();
			user.setUsername( this.faker.name().username() );
			user.setPassword( this.faker.dragonBall().character() );
			final UserEntity userDB = this.userRepository.save( user );
			
			int index = new Random().nextInt(3);
			RoleEntity roleDB = this.roleRepository.findById(++index).get();
			UserInRoleEntity userInRole = new UserInRoleEntity( userDB, roleDB );
			this.userInRoleRepository.save( userInRole );
		}
	}

}
