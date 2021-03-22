package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.igeekhome.biz.ICustomerInfoService;
import com.igeekhome.pojo.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 会话管理 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/sessionMessage")
public class SessionMessageController {

    @Autowired
    private ICustomerInfoService iCustomerInfoService;

    @GetMapping("/enter")
    public String Message(Model model, @RequestParam Integer id){
        QueryWrapper<CustomerInfo> qu = new QueryWrapper<>();
        qu.eq("id",id);
        CustomerInfo info = iCustomerInfoService.getOne(qu);
        model.addAttribute("csInfo",info);
        return "session/conversation";
    }


}

