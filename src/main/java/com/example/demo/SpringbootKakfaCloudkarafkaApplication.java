package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Habilita la ejecución de tareas programada
public class SpringbootKakfaCloudkarafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKakfaCloudkarafkaApplication.class, args);
	}

}
