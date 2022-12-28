package com.sdjr2.rest_sp5_ztoe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdjr2.rest_sp5_ztoe.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
