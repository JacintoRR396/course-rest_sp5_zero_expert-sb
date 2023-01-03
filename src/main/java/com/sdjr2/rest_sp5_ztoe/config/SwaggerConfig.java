package com.sdjr2.rest_sp5_ztoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger External API to document.
 *
 * @author jroldan
 * @version 1.0
 * @category Bean
 * @since 23/01/03
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.getApiInfo())
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false);
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Course SpringFramework 5 + REST")
				.version("1.0")
				.license("Apache 2.0")
				.contact(new Contact("JacintoR2", "https://jacintorr396.github.io/sdjr2-web_portfolio-js", "balbino.v12@gmail.com"))
				.description("JavaInUse API reference for developers")
				.build();
	}

}
