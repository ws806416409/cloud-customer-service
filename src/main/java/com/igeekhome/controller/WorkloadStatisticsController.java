package com.igeekhome.controller;


import com.igeekhome.biz.IWorkloadStatisticsService;
import com.igeekhome.pojo.WorkloadStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 工作量统计 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/workloadStatistics")
public class WorkloadStatisticsController {

    @Autowired
    private IWorkloadStatisticsService iWorkloadStatisticsService;

    @ResponseBody
    @RequestMapping("/details")
    public List<WorkloadStatistics> method1(){
        List<WorkloadStatistics> list = iWorkloadStatisticsService.list();
        return list;
    }

}

