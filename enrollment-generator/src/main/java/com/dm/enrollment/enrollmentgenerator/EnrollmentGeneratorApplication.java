package com.dm.enrollment.enrollmentgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnrollmentGeneratorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EnrollmentGeneratorApplication.class, args);

	    Comparator c = new Comparator();

	    c.compare();
	    c.writeCSV();

	}
}
