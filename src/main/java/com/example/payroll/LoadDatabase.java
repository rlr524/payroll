package com.example.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Albus Dumbledore", "headmaster")));
            log.info("Preloading " + repository.save(new Employee("Minerva McGonagall", "teacher")));
            log.info("Preloading " + repository.save(new Employee("Argus Fitch", "caretaker")));
        };
    }

    // When this class is loaded, Spring Boot will run ALL CommandLineRunner beans once the application context
    // is loaded. This runner will request a copy of the EmployeeRepository that was just created and using it, it
    // will create the three new entities and store them.

    // Left off at HTTP is the Platform
}
