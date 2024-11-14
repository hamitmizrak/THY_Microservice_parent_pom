package com.hamitmizrak.addressservice.business.dto;

import com.hamitmizrak.addressservice.auditing.AuditingAwareBaseDto;
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
