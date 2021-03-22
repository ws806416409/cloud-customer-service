package com.igeekhome.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/add")
    public String addBL(@RequestParam Integer id){
        return "index";
    }

}

