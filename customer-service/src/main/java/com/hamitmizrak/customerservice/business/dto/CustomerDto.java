package com.hamitmizrak.customerservice.business.dto;


import com.hamitmizrak.customerservice.auditing.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
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
public class CustomerDto extends AuditingAwareBaseDto implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // FIELD
    private Long id;

    @NotEmpty(message = "{customer.name.validation.constraints.NotNull.message}")
    private String name;

    @NotEmpty(message = "{customer.surname.validation.constraints.NotNull.message}")
    private String surname;

    @NotEmpty(message = "{customer.notes.validation.constraints.NotNull.message}")
    private String notes;


    @Builder.Default
    private Date systemCreatedDate=new Date(System.currentTimeMillis());

    // RELATION

} //end class AddressDto
