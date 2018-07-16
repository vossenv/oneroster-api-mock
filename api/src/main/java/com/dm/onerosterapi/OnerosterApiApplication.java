package com.dm.onerosterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class OnerosterApiApplication {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                    .paths(regex("/classes.*"))
                .paths(PathSelectors.any())
                .build();
    };

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("OneRoster Mock API")
                .description("Simple API based on the OneRoster specification")
                .version("1.0")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(OnerosterApiApplication.class, args);
    }

}
