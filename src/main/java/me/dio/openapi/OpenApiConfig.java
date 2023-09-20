package me.dio.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI()
				.info(new Info()
						.title("Video API")
				.description("Video API Open to Customers")
				.version("v1")
				.contact(new Contact()
						.name("Jordan Santos")
						.url("https://github.com/jordanjsantos")
						.email("jrdnsantos@gmail.com")));
	}
	
}
