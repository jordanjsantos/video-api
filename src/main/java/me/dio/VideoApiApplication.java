package me.dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default URL Server")})
@SpringBootApplication
public class VideoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApiApplication.class, args);
	}

}
