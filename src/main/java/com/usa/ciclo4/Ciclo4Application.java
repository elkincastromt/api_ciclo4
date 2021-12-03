package com.usa.ciclo4;

import com.usa.ciclo4.app.repositories.crud.CloneCrudRepository;
import com.usa.ciclo4.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ciclo4Application implements CommandLineRunner {

	@Autowired
	private CloneCrudRepository cloneCrudRepository;
	@Autowired
	private UserCrudRepository userCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ciclo4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
		cloneCrudRepository.deleteAll();
	}
}
