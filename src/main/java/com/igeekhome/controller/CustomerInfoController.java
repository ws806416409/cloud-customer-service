package com.igeekhome.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 客户信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/customerInfo")
public class CustomerInfoController {

    @GetMapping("/screen")
    public String screen(){
        return "tables/table-row-select";
    }

}

