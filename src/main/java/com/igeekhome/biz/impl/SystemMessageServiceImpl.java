package com.igeekhome.biz.impl;

import com.igeekhome.pojo.SystemMessage;
import com.igeekhome.dao.SystemMessageMapper;
import com.igeekhome.biz.ISystemMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统信息 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class SystemMessageServiceImpl extends ServiceImpl<SystemMessageMapper, SystemMessage> implements ISystemMessageService {

}
