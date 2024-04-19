package com.project.recycleit;

import com.project.recycleit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecycleitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecycleitApplication.class, args);
	}

}
