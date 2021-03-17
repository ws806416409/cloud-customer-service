package com.igeekhome.biz.impl;

import com.igeekhome.pojo.CustomerInfo;
import com.igeekhome.dao.CustomerInfoMapper;
import com.igeekhome.biz.ICustomerInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService {

}
