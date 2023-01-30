package com.sdjr2.rest_sp5_ztoe.models;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RUNTIME)
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
@PostAuthorize("hasRole('ROLE_ADMIN')")
public @interface SecurityRule {

}
