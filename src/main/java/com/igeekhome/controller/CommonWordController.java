package com.igeekhome.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 常见的用语 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/commonWord")
public class CommonWordController {

    public void test(){
        System.out.println("test");
    }
}

