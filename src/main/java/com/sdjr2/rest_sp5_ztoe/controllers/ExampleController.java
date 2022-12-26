/**
 *
 */
package com.sdjr2.rest_sp5_ztoe.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jroldan
 * @version 1.0
 * @category Controller
 * @since 22/12/26
 */
@RestController
@RequestMapping("/example")
public class ExampleController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "!Hello World¡";
	}

}
