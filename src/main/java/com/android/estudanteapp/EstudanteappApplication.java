package com.android.estudanteapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EstudanteappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudanteappApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
