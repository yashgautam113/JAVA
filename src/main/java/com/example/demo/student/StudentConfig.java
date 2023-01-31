package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args-> {
            Student Yash = new Student(
                    "Yash",
                    LocalDate.of(2000, Month.JANUARY,5),
                    "yash@gmail.com"
            );

            Student Alex = new Student(
                    "Alex",
                    LocalDate.of(2000, Month.JANUARY,5),
                    "yash@gmail.com"
            );
            repository.saveAll(
                    List.of(Yash,Alex)
            );
        };
    }
}
