package com.dm.onerosterapi;

import com.dm.onerosterapi.utility.SSLUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class OnerosterApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnerosterApiApplication.class, args);
    }

}
