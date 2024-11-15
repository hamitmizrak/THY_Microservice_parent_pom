package com.hamitmizrak.customerservice.feignclient;

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
    public AddressDto getAddressForCustomer( @PathVariable(name="addressId") Long addressId) {
        return customerAddressServiceFeign.getAddressForCustomer(addressId);
    }

} // end CustomerAddressControllerFeign
