package com.hamitmizrak.addressservice.runner;

import com.hamitmizrak.addressservice.business.dto.AddressDto;
import com.hamitmizrak.addressservice.business.services.IAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// DATA SET
@Order(1)
@Component
public class _1_ProjectDataSet implements CommandLineRunner {

    // Injection
    private final IAddressService iAddressService;

    // AddressDto List Save
    private List<AddressDto> addressSave(){
        List<AddressDto> addressDtoList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            AddressDto addressDto = new AddressDto();
            addressDto.setCity("İstanbul "+i);
            addressDto.setDescription("tanımlama "+i);
            addressDto.setStreet("cadde "+i);
            addressDto.setState("state "+i);
            addressDto.setZipCode("zip code "+i);
            addressDto.setDoorNumber("door number "+i);
            addressDto.setAddressQrCode(UUID.randomUUID().toString());
            iAddressService.addressServiceCreate(addressDto);
            addressDtoList.add(addressDto);
        }
        return addressDtoList;
    }

    // Address Save
    private AddressDto saveAddress(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCity("Hatay ");
        addressDto.setDescription("tanımlama ");
        addressDto.setStreet("cadde ");
        addressDto.setState("state ");
        addressDto.setZipCode("zip code ");
        addressDto.setDoorNumber("door number ");
        addressDto.setAddressQrCode(UUID.randomUUID().toString());
        return addressDto;
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("1.Data set çalıştı");
        log.info("1.Data set çalıştı");
        addressSave();
    }
}
