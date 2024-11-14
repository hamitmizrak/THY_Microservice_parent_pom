package com.hamitmizrak.customerservice.data.repository;

import com.hamitmizrak.customerservice.data.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<AddressEntity, Long>
// PagingAndSortingRepository<AddressEntity, Long>

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // JPQL
    // Native Query
}
