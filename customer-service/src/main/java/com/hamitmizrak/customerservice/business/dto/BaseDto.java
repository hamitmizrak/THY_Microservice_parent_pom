package com.hamitmizrak.customerservice.business.dto;


import com.hamitmizrak.customerservice.auditing.AuditingAwareBaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// LOMBOK
@Getter
@Setter

public class BaseDto extends AuditingAwareBaseDto {

    private Long id;
    private Date systemCreatedDate;
}
