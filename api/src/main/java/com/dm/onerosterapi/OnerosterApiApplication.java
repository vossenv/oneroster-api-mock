package com.dm.onerosterapi;

import com.dm.onerosterapi.service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnerosterApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnerosterApiApplication.class, args);
    }

}
