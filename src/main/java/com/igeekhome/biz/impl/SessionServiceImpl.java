package com.igeekhome.biz.impl;

import com.igeekhome.pojo.Session;
import com.igeekhome.dao.SessionMapper;
import com.igeekhome.biz.ISessionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会话表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session> implements ISessionService {

}
