package demo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.*;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean   //docket object returned to spring context allows for swagger doc. customization
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData(){
		Contact contact=new Contact("Pushkar Singh Rawat", "https://linkedin.com/in/pushkar-singh-rawat-24540787/",
                "pushkarsinghrawat7@gmail.com");
		return new ApiInfo("Rest API","APIs developed with Spring framework", "v0.1", "Terms of service",contact,"Apache License Version 2.0", "https://www.apache.org/license/License-2.0",
				new ArrayList<>());
	}
	
}
