package com.hamitmizrak.customerservice.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorAttributesConfig {
    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes();
    }
}
