package com.sdjr2.rest_sp5_ztoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdjr2.rest_sp5_ztoe.services.MockService;

@SpringBootApplication
public class CourseRestSp5ZeroExpertSbApplication implements ApplicationRunner {

	@Autowired
	private MockService mockService;

	public static void main(final String[] args) {
		SpringApplication.run(CourseRestSp5ZeroExpertSbApplication.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		this.mockService.mockUsers();
	}

}
