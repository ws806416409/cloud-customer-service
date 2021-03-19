package com.igeekhome.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 会话表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@Slf4j
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/get")
    public String getSession(){
        return "session/conversation";
    }

    @RequestMapping("/sendMsg")
    public String csMsg(String csMsg){
        log.info(csMsg);
        return "index";
    }

}

