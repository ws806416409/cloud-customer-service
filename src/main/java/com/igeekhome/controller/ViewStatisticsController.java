package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.igeekhome.biz.IAttendanceStatisticsService;
import com.igeekhome.biz.IWorkQualityStatisticsService;
import com.igeekhome.biz.IWorkloadStatisticsService;
import com.igeekhome.pojo.AttendanceStatistics;
import com.igeekhome.pojo.CustomerService;
import com.igeekhome.pojo.WorkQualityStatistics;
import com.igeekhome.pojo.WorkloadStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 视图统计 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/viewStatistics")
public class ViewStatisticsController {

    @Autowired
    private IAttendanceStatisticsService iAttendanceStatisticsService;

    @Autowired
    private IWorkQualityStatisticsService iWorkQualityStatisticsService;

    @Autowired
    private IWorkloadStatisticsService iWorkloadStatisticsService;

    @RequestMapping("/workload")
    public String workload(Model model){       //工作量统计数据

        List<WorkloadStatistics> list = iWorkloadStatisticsService.list();
        model.addAttribute("work",list);

        return "page-data/page-workload";
    }

    @RequestMapping("/workQuality")
    public String workQuality(Model model,WorkQualityStatistics workQualityStatistics){       //工作质量统计

        List<WorkQualityStatistics> list = iWorkQualityStatisticsService.list();//查询所有的数据
        model.addAttribute("workQu",list);
        return "page-data/jobQuality";
    }

//    @ResponseBody
//    @RequestMapping("/getWorkQu")
//    public WorkQualityStatistics getWorkQu(Model model,WorkQualityStatistics workQualityStatistics)
//    {
//        int iwork = workQualityStatistics.getId();//根据ID查找一条工作质量的数据
//        WorkQualityStatistics workQualityStatistics1 = this.iWorkQualityStatisticsService.getById(iwork);
//        return workQualityStatistics1;
//    }


    @RequestMapping("/attendance")
    public String attendance(HttpSession httpSession,Model model){         //考勤

        List<AttendanceStatistics> list = iAttendanceStatisticsService.list();
        model.addAttribute("attend",list);

        return "page-data/page-attendance";
    }


    @ResponseBody
    @RequestMapping("/chart")
    public List<AttendanceStatistics> chart(HttpSession httpSession,Model model){         //考勤

        List<AttendanceStatistics> list = iAttendanceStatisticsService.list();
        model.addAttribute("attend",list);

        return list;
    }

    @ResponseBody
    @RequestMapping("/workQualityChart")
    public List<WorkQualityStatistics> workQualityChart(Model model,HttpSession httpSession){       //工作质量统计

        List<WorkQualityStatistics> list = iWorkQualityStatisticsService.list();//查询所有的数据
        model.addAttribute("workQuChart",list);
        return list;
    }


}

