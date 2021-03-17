package com.igeekhome.biz.impl;

import com.igeekhome.pojo.WorkLog;
import com.igeekhome.dao.WorkLogMapper;
import com.igeekhome.biz.IWorkLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作日志 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class WorkLogServiceImpl extends ServiceImpl<WorkLogMapper, WorkLog> implements IWorkLogService {

}
