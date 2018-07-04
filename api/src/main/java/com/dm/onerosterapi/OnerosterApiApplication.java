package com.dm.onerosterapi;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@SpringBootApplication
public class OnerosterApiApplication implements CommandLineRunner {

	@Autowired
    RosterService rosterService;

	public static void main(String[] args) {
		SpringApplication.run(OnerosterApiApplication.class, args);
	}

    @Override
    public void run(String... arg0) throws Exception {

          List<User> allUsers = rosterService.getAllUsers();
          User u = rosterService.repGetUserById(5);
        System.out.println();
    }

}
