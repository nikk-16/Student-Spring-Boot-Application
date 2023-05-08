package com.example.student.stud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentconfig {
    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args -> {
            student Nikhil = new student(
                    "Nikhil",
                    "nikhil@gmail.com",
                    LocalDate.of(2001, Month.APRIL, 16)
            );
            student Alok = new student(
                    "Alok",
                    "alok@gmail.com",
                    LocalDate.of(2004, Month.DECEMBER, 26)
            );
            repository.saveAll(List.of(Nikhil, Alok));
        };
    }
}

