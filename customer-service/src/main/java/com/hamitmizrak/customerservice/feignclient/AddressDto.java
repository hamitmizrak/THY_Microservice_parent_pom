package com.hamitmizrak.customerservice.feignclient;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// Address(1) - Customer(1)
public class AddressDto  implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // FIELD
    private Long id;

    private String doorNumber;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String addressQrCode;
    private String description;

    @Builder.Default
    private Date systemCreatedDate=new Date(System.currentTimeMillis());

    // RELATION

} //end class AddressDto
