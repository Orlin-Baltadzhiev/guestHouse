package com.GuestHouseBaltadzhiev;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;


@SpringBootApplication
@EnableEncryptableProperties

public class GuestHouseBaltadzhievApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestHouseBaltadzhievApplication.class, args);
	}

}
