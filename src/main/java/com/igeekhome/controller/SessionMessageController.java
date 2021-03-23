package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.igeekhome.biz.ICommonWordService;
import com.igeekhome.biz.ICustomerInfoService;
import com.igeekhome.biz.ISessionMessageService;
import com.igeekhome.pojo.CommonWord;
import com.igeekhome.pojo.CustomerInfo;
import com.igeekhome.pojo.SessionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @Autowired
    private ISessionMessageService iSessionMessageService;

    @Autowired
    private ICommonWordService iCommonWordService;

    @GetMapping("/enter")
    public String Message(Model model, @RequestParam Integer id){
        QueryWrapper<CustomerInfo> qu = new QueryWrapper<>();
        qu.eq("id",id);
        CustomerInfo info = iCustomerInfoService.getOne(qu);
        model.addAttribute("csInfo",info);
        return "session/conversation";
    }
    @PostMapping("/send")
    public String send_Message(Model model, SessionMessage sessionMessage){

        //获取个人信息
        System.out.println("你的id：" + sessionMessage.getId());
        CustomerInfo csInfo = this.iCustomerInfoService.getById(sessionMessage.getSessionid());
        model.addAttribute("csInfo",csInfo);

        //获取消息内容：先存后取
        this.iSessionMessageService.save(sessionMessage);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("sessionid",sessionMessage.getSessionid());
        List<SessionMessage> list = this.iSessionMessageService.list(qw);
        model.addAttribute("list",list);
        return "session/conversation";
    }

    @RequestMapping("/phrase")
    public String phrase_Message(Model model, @RequestParam("id")Integer id , @RequestParam("wordid")Integer wordid){

        //获取个人信息
        System.out.println("你的id：" + id);
        CustomerInfo csInfo = this.iCustomerInfoService.getById(id);
        model.addAttribute("csInfo",csInfo);

        //获取消息内容：先存后取
        CommonWord commonWord = this.iCommonWordService.getById(wordid);
        SessionMessage sessionMessage = new SessionMessage();
        sessionMessage.setSessionid(id);
        sessionMessage.setContent(commonWord.getContent());
        this.iSessionMessageService.save(sessionMessage);

        QueryWrapper qw = new QueryWrapper();
        qw.eq("sessionid",sessionMessage.getSessionid());
        List<SessionMessage> list = this.iSessionMessageService.list(qw);
        model.addAttribute("list",list);
        return "session/conversation";
    }

}

