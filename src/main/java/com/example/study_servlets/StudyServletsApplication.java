package com.example.study_servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StudyServletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyServletsApplication.class, args);
	}

}
