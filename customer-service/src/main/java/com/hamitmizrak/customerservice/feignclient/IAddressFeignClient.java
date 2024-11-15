package com.hamitmizrak.customerservice.feignclient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// http://localhost:1111/api/address/find/1
// http://localhost:2222/api/customer/find/1

@FeignClient(name ="address-service", url="http://localhost:1111")
/*@FeignClient(name ="address-service")*/
public interface IAddressFeignClient {

    // http://localhost:2222/api/customer/address/1
    @GetMapping("/api/address/find/{id}")
    @CircuitBreaker(name="address-service", fallbackMethod = "fallbackAddressById")
    AddressDto getAddressFindByIdOnCustomer( @PathVariable(name = "id") Long id);

    // CircuitBreaker => fallbackAddressById
    default AddressDto fallbackAddressById(Long id, Throwable throwable ) {
        AddressDto fallBackAddressDto = new AddressDto();
        fallBackAddressDto.setId(id);
        fallBackAddressDto.setCity("Bilinmeyen bir Şehir");
        System.out.println( "Hata");
        return fallBackAddressDto;
    }
}
