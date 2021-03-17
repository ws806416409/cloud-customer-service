package com.igeekhome.biz;

import com.igeekhome.pojo.CustomerService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceServiceTest {

    @Autowired
    private ICustomerServiceService iCustomerServiceService;

 @Test
    void  customerServiceSave()
    {
        CustomerService cs=new CustomerService();
        cs.setNickname("wang");

        this.iCustomerServiceService.save(cs);
    }
}
