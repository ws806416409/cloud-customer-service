package com.igeekhome.controller;

import com.igeekhome.biz.ICustomerServiceService;
import com.igeekhome.pojo.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ICustomerServiceService iCustomerServiceService;

    @RequestMapping({"/","/login"})  //当地址栏目为　http://localhost:80/   时，到棕登录页
    public String index()
    {
        return "page-login";
    }
    @GetMapping("/index")
    public String main(HttpSession session, Model model){

        List<CustomerService> list = iCustomerServiceService.list();//首页客服监控
        model.addAttribute("monitoring",list);
        return "index";
    }

    //退出
    @RequestMapping("/exit")
    public String exit(HttpSession session)
    {
        //退出：就是删除 登录时存储的session对象
        session.removeAttribute(("cs"));
        return "page-login";
    }

}
