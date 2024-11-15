package com.hamitmizrak.customerservice.feignclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// LOMBOK
@RequiredArgsConstructor

@Service
public class CustomerAddressServiceFeign {

    // Injection
    private final IAddressFeignClient iAddressFeignClient;

    // id üzerinden Adress erişim sağlamak
    public AddressDto getAddressForCustomer(Long addressId) {
        return iAddressFeignClient.getAddressFindByIdOnCustomer(addressId);
    }
}
