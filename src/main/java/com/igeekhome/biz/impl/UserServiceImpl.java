package com.igeekhome.biz.impl;

import com.igeekhome.pojo.User;
import com.igeekhome.dao.UserMapper;
import com.igeekhome.biz.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
