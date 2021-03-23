package com.igeekhome.controller;


import com.igeekhome.biz.IVisitorInfoService;
import com.igeekhome.pojo.VisitorInfo;
import com.igeekhome.pojo.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 视图统计 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */

@Slf4j
@Controller
@RequestMapping("/visitorInfo")
public class VisitorInfoController {

    @Autowired
    IVisitorInfoService iVisitorInfoService;

    @GetMapping("/index")
    public String VisitorList(Model model){

        List<VisitorInfo> list = iVisitorInfoService.list();
        model.addAttribute("VisitorList",list);
        return "visitor/visitor-list";

    }



}

