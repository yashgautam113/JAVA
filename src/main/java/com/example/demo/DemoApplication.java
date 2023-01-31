package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
//@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

//	@GetMapping(path = "/api")
//	public List<Student> hello() {
//		return List.of(
//				Student.builder().name("arun").email("dasnjdknaksdjnas.com").build(),
//				new Student(
//						1L,
//						"Yash",
//						LocalDate.of(2000, Month.JANUARY,5),
//						"yash@gmail.com",
//						22
//				)
//		);
//	}

}
