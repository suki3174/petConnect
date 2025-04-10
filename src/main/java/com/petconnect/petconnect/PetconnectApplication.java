package com.petconnect.petconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetconnectApplication {

	public static void main(String[] args) {

		SpringApplication.run(PetconnectApplication.class, args);
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
