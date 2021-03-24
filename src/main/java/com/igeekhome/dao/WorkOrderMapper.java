package com.igeekhome.dao;

import com.igeekhome.pojo.WorkOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * <p>
 * 工作订单 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
public interface WorkOrderMapper extends BaseMapper<WorkOrder> {

    /*@Select("SELECT DISTINCT #{type} FROM work_order")
    List<String> selectByType(@Param("type") String type);*/
}
