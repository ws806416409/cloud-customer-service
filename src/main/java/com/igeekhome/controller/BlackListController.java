package com.igeekhome.controller;


import com.igeekhome.biz.IBlackListService;
import com.igeekhome.pojo.BlackList;
import com.igeekhome.pojo.WorkLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 恶意用户列表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/blackList")
public class BlackListController {

    @Autowired
    IBlackListService blackListService;

    @GetMapping("/index")
    public String blist(Model model){
        List<BlackList> list = blackListService.list();
        model.addAttribute("blist",list);
        return "blackList/black-list";
    }

    @RequestMapping("/add")
    public String addBL(@RequestParam Integer id){
        return "blackList/black-list";
    }

}

