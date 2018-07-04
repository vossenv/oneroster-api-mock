package com.dm.onerosterapi;

import com.dm.onerosterapi.Service.RosterService;
import com.dm.onerosterapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@SpringBootApplication
@EntityScan("com.dm.onerosterapi.dao")
public class OnerosterApiApplication implements CommandLineRunner {

	@Autowired
    RosterService rosterService;

	public static void main(String[] args) {
		SpringApplication.run(OnerosterApiApplication.class, args);
	}

    @Override
    public void run(String... arg0) throws Exception {

//        User x = rosterService.getUserById(5);
//        List<User> allUsers = rosterService.getAllUsers();

        System.out.println();
    }

}
