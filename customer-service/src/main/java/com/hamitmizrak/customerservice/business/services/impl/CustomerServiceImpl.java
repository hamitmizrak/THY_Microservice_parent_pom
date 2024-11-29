package com.hamitmizrak.customerservice.business.services.impl;


import com.hamitmizrak.customerservice.bean.ModelMapperBean;
import com.hamitmizrak.customerservice.business.dto.CustomerDto;
import com.hamitmizrak.customerservice.business.mapper.CustomerMapper;
import com.hamitmizrak.customerservice.business.services.ICustomerService;
import com.hamitmizrak.customerservice.data.entity.CustomerEntity;
import com.hamitmizrak.customerservice.data.repository.ICustomerRepository;
import com.hamitmizrak.customerservice.exception._404_NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// LOMBOK
@RequiredArgsConstructor // for injection

// Asıl iş yükünü yapan Bean
@Service
public class CustomerServiceImpl implements ICustomerService<CustomerDto, CustomerEntity> {

    // LOMBOK CONSTRUCTOR INJECTION
    // 3.YOL
    private final ICustomerRepository iCustomerRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public CustomerDto entityCustomerToDto(CustomerEntity customerEntity) {
        // 1.YOL
        // return modelMapperBean.getModelMapper().map(customerEntity, CustomerDto.class);

        // 2.YOL
        return CustomerMapper.CustomerEntityToDto(customerEntity);
    }

    @Override
    public CustomerEntity dtoCustomerToEntity(CustomerDto customerDto) {
        // 1.YOL
        // return modelMapperBean.getModelMapper().map(customerDto, CustomerEntity.class);

        //  2.YOL
        return CustomerMapper.CustomerDtoToEntity(customerDto);
    }

    /////////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    @Transactional // create, delete, update (manipulation)
    @Override
    public CustomerDto customerServiceCreate(CustomerDto customerDto) {
        CustomerEntity customerEntityCreate = dtoCustomerToEntity(customerDto);
        customerEntityCreate = iCustomerRepository.save(customerEntityCreate);
        return entityCustomerToDto(customerEntityCreate);
    }

    // LIST
    @Override
    public List<CustomerDto> customerServiceList() {
        return iCustomerRepository.findAll()
                .stream()
                //.map(CustomerMapper::CustomerEntityToDto)// 1.YOL Method Referance
                //.sorted(Comparator.comparing((temp)->temp.getCustomerEntityEmbeddable().getCity()))
                .map((temp) -> CustomerMapper.CustomerEntityToDto(temp))// 2.YOL Lambda Expression
                .collect(Collectors.toList());
    }

    // FIND BY ID
    @Override
    public CustomerDto customerServiceFindById(Long id) {
        return iCustomerRepository.findById(id)
                .map(CustomerMapper::CustomerEntityToDto)// 1.YOL Method Referance
                //.map((temp)->CustomerMapper.AddressEntityToDto(temp))// 2.YOL Lambda Expression
                .orElseThrow(() -> new _404_NotFoundException(id + " nolu customer yoktur"));
    }

    // UPDATE
    @Transactional // create, delete, update (manipulation)
    @Override
    public CustomerDto customerServiceUpdate(Long id, CustomerDto customerDto) {
        // ID Varsa
        CustomerEntity customerEntityUpdate = dtoCustomerToEntity(customerServiceFindById(id));

        // Embeddable
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName (customerDto.getName()); ;
        customerEntity.setSurname(customerDto.getSurname());
        customerEntity.setNotes(customerDto.getNotes());

        customerEntityUpdate = iCustomerRepository.saveAndFlush(customerEntityUpdate);
        return entityCustomerToDto(customerEntityUpdate);
    }

    // DELETE
    @Transactional // create, delete, update (manipulation)
    @Override
    public CustomerDto customerServiceDeleteById(Long id) {
        // ID Varsa
        CustomerEntity customerEntityDelete = dtoCustomerToEntity(customerServiceFindById(id));
        iCustomerRepository.delete(customerEntityDelete);
        return entityCustomerToDto(customerEntityDelete);
    }

}