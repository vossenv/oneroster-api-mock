package com.dm.onerosterapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class OnerosterApiApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(OnerosterApiApplication.class, args);}

    public static void main(String[] args) {
        new SpringApplicationBuilder(OnerosterApiApplication.class)
                .properties("spring.config.name:application,version")
                .build()
                .run(args);

    }

}
