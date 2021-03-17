package com.igeekhome.biz.impl;

import com.igeekhome.pojo.CustomerService;
import com.igeekhome.dao.CustomerServiceMapper;
import com.igeekhome.biz.ICustomerServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客服表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class CustomerServiceServiceImpl extends ServiceImpl<CustomerServiceMapper, CustomerService> implements ICustomerServiceService {

}
