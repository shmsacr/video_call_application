package com.shmsacr.video_call_application;

import com.shmsacr.video_call_application.user.User;
import com.shmsacr.video_call_application.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService){
		return args -> {
			userService.register(User.builder()
					.username("Sehmus")
					.email("shmsacr@gmail.com")
					.password("aaa")
					.build());

			userService.register(User.builder()
					.username("Other")
					.email("other@gmail.com")
					.password("aaa")
					.build());

			userService.register(User.builder()
					.username("Test")
					.email("test@gmail.com")
					.password("aaa")
					.build());
		};
	}


}
