package com.igeekhome.biz.impl;

import com.igeekhome.pojo.BlackList;
import com.igeekhome.dao.BlackListMapper;
import com.igeekhome.biz.IBlackListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 恶意用户列表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackList> implements IBlackListService {

}
