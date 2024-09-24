package com.example.bookkeeping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookkeepingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookkeepingPlatformApplication.class, args);
	}

	  @Bean
	    public CommandLineRunner demo() {
	        return args -> {
	            System.out.println("MongoDB connection established successfully!");
	        };
	    }
}
