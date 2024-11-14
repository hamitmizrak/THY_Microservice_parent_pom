package com.hamitmizrak.customerservice.business.mapper;


import com.hamitmizrak.customerservice.business.dto.CustomerDto;
import com.hamitmizrak.customerservice.data.entity.CustomerEntity;

public class CustomerMapper {

    // Address Entity To Dto
    public static CustomerDto CustomerEntityToDto(CustomerEntity customerEntity) {
        // Instance (AddressDto)
        CustomerDto customerDto = new CustomerDto();

        // ID
        customerDto.setId(customerEntity.getId());
        customerDto.setSystemCreatedDate(customerEntity.getSystemCreatedDate());
        customerDto.setName(customerEntity.getName());
        customerDto.setSurname(customerEntity.getSurname());
        customerDto.setNotes(customerEntity.getNotes());
        return customerDto;
    }

    // Address Dto To Entity
    public static CustomerEntity CustomerDtoToEntity(CustomerDto customerDto) {
        // Instance (AddressDto)
        CustomerEntity customerEntity = new CustomerEntity();

        // ID
        customerEntity.setId(customerDto.getId());
        customerEntity.setSystemCreatedDate(customerDto.getSystemCreatedDate());
        customerEntity.setName(customerDto.getName());
        customerEntity.setSurname(customerDto.getSurname());
        customerEntity.setNotes(customerDto.getNotes());
        return customerEntity;
    }
}
