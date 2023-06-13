package com.sdjr2.rest_sp5_ztoe.models;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * {@link SecurityRule} class.
 * <p>
 * Rule - Includes annotations about security rules in pre and post state.
 *
 * @author jroldan
 * @version 1.0
 * @category Annotation
 * @since 23/02/01
 * @upgrade 23/02/01
 */
@Retention(RUNTIME)
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
@PostAuthorize("hasRole('ROLE_ADMIN')")
public @interface SecurityRule {

}
