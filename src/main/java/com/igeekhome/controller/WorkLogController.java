package com.igeekhome.controller;


import com.igeekhome.biz.IWorkLogService;
import com.igeekhome.pojo.WorkLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 工作日志 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/workLog")
public class WorkLogController {

    @Autowired
    IWorkLogService iWorkLogService;

    @GetMapping("/index")
    public String list(Model model){
        List<WorkLog> list = iWorkLogService.list();
        model.addAttribute("logs",list);
        return "order/work-log";
    }

}

