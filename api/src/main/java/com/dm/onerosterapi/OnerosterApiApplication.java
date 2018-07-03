package com.dm.onerosterapi;

import com.dm.onerosterapi.Service.SchoolService;
import com.dm.onerosterapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OnerosterApiApplication implements CommandLineRunner {

	@Autowired
	SchoolService schoolService;

	public static void main(String[] args) {
		SpringApplication.run(OnerosterApiApplication.class, args);
	}

    @Override
    public void run(String... arg0) throws Exception {
        List<User> studentList = schoolService.findByRole("student");
        System.out.printf("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

}
