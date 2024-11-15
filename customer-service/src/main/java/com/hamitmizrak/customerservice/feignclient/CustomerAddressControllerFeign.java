package com.hamitmizrak.customerservice.feignclient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// LOMBOK
@RequiredArgsConstructor

// http://localhost:1111/api/address/find/1
// http://localhost:2222/api/customer/find/1
// http://localhost:2222/api/customer/address/1

// Rest Api
@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerAddressControllerFeign {

    // Injection
    private final CustomerAddressServiceFeign customerAddressServiceFeign;

    // http://localhost:2222/api/customer/address/1
    @GetMapping("/address/{addressId}")
    @CircuitBreaker(name="address-service", fallbackMethod = "fallbackAddressById")
    public AddressDto getAddressForCustomer( @PathVariable(name="addressId") Long addressId) {
        return customerAddressServiceFeign.getAddressForCustomer(addressId);
    }

    // CircuitBreaker => fallbackAddressById
     AddressDto fallbackAddressById(Long id, Throwable throwable ) {
        AddressDto fallBackAddressDto = new AddressDto();
        fallBackAddressDto.setId(id);
        fallBackAddressDto.setCity("Bilinmeyen bir Şehir");
        System.out.println( "Hata");
        return fallBackAddressDto;
    }

} // end CustomerAddressControllerFeign
