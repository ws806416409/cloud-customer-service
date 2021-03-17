package com.igeekhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.igeekhome.dao")
public class CloudCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCustomerServiceApplication.class, args);
    }

}
