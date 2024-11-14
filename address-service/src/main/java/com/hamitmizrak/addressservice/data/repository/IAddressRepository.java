package com.hamitmizrak.addressservice.data.repository;

import com.hamitmizrak.addressservice.data.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// CrudRepository<AddressEntity, Long>
// PagingAndSortingRepository<AddressEntity, Long>

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {
    // Delivered Query
    Optional<AddressEntity> findAddressEntityByAddressEntityEmbeddable_AddressQrCode(String qrCode);

    // JPQL
    // Native Query
}
