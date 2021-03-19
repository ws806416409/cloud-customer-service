package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.igeekhome.biz.impl.CustomerInfoServiceImpl;
import com.igeekhome.pojo.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.awt.*;
import java.util.List;

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

    @Autowired
    CustomerInfoServiceImpl customerInfoService;




    /**
     * 展示客户列表
     * */
    @RequestMapping("/list")
    public String list(Model model){

        List<CustomerInfo> list = this.customerInfoService.list();
        model.addAttribute("list",list);
        return "/customerinfo/customer-list";
    }

    /**
     * 添加客户信息：GetMapping发送请求，PostMapping处理请求
     * */
    @GetMapping("/add")
    public String index_add(){
        return "/customerinfo/customer-add";
    }
    @PostMapping("/add")
    public String add(CustomerInfo customerInfo, Model model){


        this.customerInfoService.save(customerInfo);
        List<CustomerInfo> list = this.customerInfoService.list();
        model.addAttribute("list",list);
        return "/customerinfo/customer-list";
    }

    @RequestMapping("/details")
    public String details(){
        return null;
    }


    /**
     * 更新客户信息：GetMapping发送更新请求、PostMapping处理请求
     *
     * */
    @GetMapping("/update")
    public String index_update(CustomerInfo customerInfo, Model model){

        customerInfo = this.customerInfoService.getById(customerInfo.getId());
        model.addAttribute("csInfo",customerInfo);
        return "/customerinfo/customer-update";
    }

    @PostMapping("/update")
    public String update(CustomerInfo customerInfo, Model model){

        this.customerInfoService.updateById(customerInfo);
        List<CustomerInfo> list = this.customerInfoService.list();
        model.addAttribute("list",list);
        return "/customerinfo/customer-list";
    }

    /**
     * 删除客户信息
     * */
    @RequestMapping("/delete")
    public String del(Model model, CustomerInfo cs){

        this.customerInfoService.removeById(cs.getId());
        List<CustomerInfo> list = this.customerInfoService.list();
        model.addAttribute("list",list);
        return "/customerinfo/customer-list";
    }
}

