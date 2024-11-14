package com.hamitmizrak.addressservice.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

// LOMBOK
@Log4j2
@Configuration

// DATA SET
@Order(2)
public class _2_ProjectDataSet {
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Project Data set -2 ");
            log.info("Project Data set -2 ");
        };
    } // end Bean
}
