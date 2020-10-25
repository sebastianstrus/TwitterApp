package com.backend.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.post.PostController;
import com.backend.user.UserController;

@Import({UserController.class, PostController.class})

@SpringBootApplication
@ComponentScan({"com.backend"})
@EntityScan("com.backend")
@EnableJpaRepositories("com.backend")
@RestController
public class TwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}

	@GetMapping("/messages")
	public String getMessages() { return "Hello World";}

}
