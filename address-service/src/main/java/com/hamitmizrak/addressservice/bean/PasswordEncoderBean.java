package com.hamitmizrak.addressservice.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {

    @Bean
    public PasswordEncoder getPasswordEncoderBeanMethod() {
        return new BCryptPasswordEncoder();
    } //end

} //end class PasswordEncoderBean
