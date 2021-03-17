package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.igeekhome.biz.ICustomerServiceService;
import com.igeekhome.pojo.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 客服表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/customerService")
public class CustomerServiceController {

    @Autowired
    private ICustomerServiceService iCustomerServiceService;

    @RequestMapping("/login")
    public String checkCustomerServiceNameAndPwd(CustomerService customerService, Model model, HttpSession session)
    {

        String path="login";
       // System.out.println(customerService);
        QueryWrapper<CustomerService> qu=new QueryWrapper();
        qu.eq("email",customerService.getEmail());
        qu.eq("password",customerService.getPassword());
        CustomerService cs=  iCustomerServiceService.getOne(qu);
        if(cs!=null)
        {
            session.setAttribute("cs", cs);
            //找到了eｍai
            path = "redirect:/index";
        }
        else {
            // 没有找到email
            model.addAttribute("msg","用户名密码不正确");
            path = "page-login";
        }
        return path;

    }

}

