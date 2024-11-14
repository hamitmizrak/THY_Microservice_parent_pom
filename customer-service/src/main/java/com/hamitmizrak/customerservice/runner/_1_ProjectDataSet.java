package com.hamitmizrak.customerservice.runner;


import com.hamitmizrak.customerservice.business.dto.CustomerDto;
import com.hamitmizrak.customerservice.business.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// DATA SET
@Order(1)
@Component
public class _1_ProjectDataSet implements CommandLineRunner {

    // Injection
    private final ICustomerService iCustomerService;


    // Address Save
    private CustomerDto saveCustomer(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Hamit");
        customerDto.setSurname("Mızrak ");
        customerDto.setNotes("Notes");
        return customerDto;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("1.Data set çalıştı");
        log.info("1.Data set çalıştı");
        saveCustomer();
    }
}
