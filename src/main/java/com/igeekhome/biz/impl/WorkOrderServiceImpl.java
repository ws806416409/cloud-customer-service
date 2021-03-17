package com.igeekhome.biz.impl;

import com.igeekhome.pojo.WorkOrder;
import com.igeekhome.dao.WorkOrderMapper;
import com.igeekhome.biz.IWorkOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作订单 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements IWorkOrderService {

}
