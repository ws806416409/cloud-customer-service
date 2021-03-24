package com.igeekhome.controller;


import com.igeekhome.biz.impl.CustomerInfoServiceImpl;
import com.igeekhome.biz.impl.CustomerServiceServiceImpl;
import com.igeekhome.biz.impl.SessionServiceImpl;
import com.igeekhome.pojo.CustomerInfo;
import com.igeekhome.pojo.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 会话表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    SessionServiceImpl sessionService;

    @Autowired
    CustomerInfoServiceImpl customerInfoService;

    @RequestMapping("/prelist")
    public String prelist(Model model){

        List<Session> list = this.sessionService.list();
        model.addAttribute("list",list);
        return "/session/session-pre-list";
    }

    @RequestMapping("/list")
    public String list(Model model){

        List<CustomerInfo> list = this.customerInfoService.list();
        model.addAttribute("list",list);
        return "/session/session-list";
    }
}

