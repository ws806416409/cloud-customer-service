package com.igeekhome.biz.impl;

import com.igeekhome.pojo.SessionMessage;
import com.igeekhome.dao.SessionMessageMapper;
import com.igeekhome.biz.ISessionMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会话管理 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class SessionMessageServiceImpl extends ServiceImpl<SessionMessageMapper, SessionMessage> implements ISessionMessageService {

}
