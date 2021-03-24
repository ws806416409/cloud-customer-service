package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.igeekhome.biz.impl.*;
import com.igeekhome.pojo.BlackList;
import com.igeekhome.pojo.CustomerInfo;
import com.igeekhome.pojo.Session;
import com.igeekhome.pojo.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    BlackListServiceImpl blackListService;

    @Autowired
    CustomerServiceServiceImpl customerServiceService;

    @Autowired
    WorkOrderServiceImpl workOrderService;

    @Autowired
    SessionServiceImpl sessionService;

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
    public String index_add(Model model){

        List<CustomerInfo> list = this.customerInfoService.list();
        //从后台获取客户的多个等级，并去重
        Set<String> level = new HashSet<>();
        for(CustomerInfo x : list){
           level.add(x.getLevel());
        }
        System.out.println("等级的个数  " + level.size());

        //从后台获取客户的多个状态，并去重
        Set<String> state = new HashSet<>();
        for(CustomerInfo x : list){
            state.add(x.getState());
        }
        model.addAttribute("state",state);
        model.addAttribute("level",level);

        return "/customerinfo/customer-add";
    }
    @PostMapping("/add")
    public String add(CustomerInfo customerInfo, Model model){

        if(customerInfo.getLevel()=="")
            customerInfo.setLevel(null);
        if(customerInfo.getCustomername()=="")
            customerInfo.setCustomername(null);
        this.customerInfoService.save(customerInfo);
        List<CustomerInfo> list = this.customerInfoService.list();
        model.addAttribute("list",list);
        return "/customerinfo/customer-list";
    }

    /**
     * 更新客户信息：GetMapping发送更新请求、PostMapping处理请求
     *
     * */
    @GetMapping("/update")
    public String index_update(CustomerInfo customerInfo, Model model){

        customerInfo = this.customerInfoService.getById(customerInfo.getId());
        model.addAttribute("csInfo",customerInfo);

        List<CustomerInfo> list = this.customerInfoService.list();
        //从后台获取客户的多个状态，并去重
        Set<String> state = new HashSet<>();
        for(CustomerInfo x : list){
            state.add(x.getState());
        }
        //从后台获取客户的多个等级，并去重
        Set<String> level = new HashSet<>();
        for(CustomerInfo x : list){
            level.add(x.getLevel());
        }

        model.addAttribute("level",level);
        model.addAttribute("state",state);
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

    /**
     * 客户的历史会话
     * */
    @RequestMapping("/details")
    public String details(CustomerInfo customerInfo, Model model){

        //个人信息
        CustomerInfo csInfo = this.customerInfoService.getById(customerInfo.getId());
        model.addAttribute("csInfo",csInfo);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("visiterName",csInfo.getRealname());
        List<Session>list = this.sessionService.list(qw);
        //根据客服id获取客服的nickName
        String nickName[] = new String[list.size()+1];
        String group[] = new String[list.size()+1];
        String startTime[] = new String[list.size()+1];
        int i = 1;
        for(Session s:list)
        {
            nickName[i] = this.customerServiceService.getById(s.getCustomerserviceid()).getNickname();
            group[i] = this.customerServiceService.getById((s.getCustomerserviceid())).getServicegroup();
            startTime[i] = dtf.format(s.getCreatetime());
            ++i;
        }
        model.addAttribute("list",list);
        model.addAttribute("startTime",startTime);
        model.addAttribute("nickName",nickName);
        model.addAttribute("group",group);
        return "/customerinfo/customer-pre-conversation";
    }

    /**
     * 客户的历史工单
     * */
    @RequestMapping("/workorder")
    public String workOrder(CustomerInfo customerInfo, Model model){
        //个人信息
        CustomerInfo csInfo = this.customerInfoService.getById(customerInfo.getId());
        model.addAttribute("csInfo",csInfo);

        //工单记录
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("customerid",csInfo.getId());
        List<WorkOrder> list = this.workOrderService.list(qw);
        String nickName[] = new String[list.size()+1];
        int i=1;
        for(WorkOrder x: list)
        {
            //根据客服id获取客服名，存放到数组中
            nickName[i] = customerServiceService.getById(x.getCustomerserviceid()).getNickname();
            ++i;

        }
        model.addAttribute("list",list);
        model.addAttribute("nickName",nickName);
        return "/customerinfo/customer-pre-order";
    }


    /**
     * 客户的拉黑记录
     * */
    @RequestMapping("/blackrecord")
    public String blackRecord(CustomerInfo customerInfo, Model model){
        //客户个人信息
        CustomerInfo csInfo = this.customerInfoService.getById(customerInfo.getId());
        model.addAttribute("csInfo",csInfo);

        //格式化日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createTime = sdf.format(csInfo.getCreatetime());
//        String loginTime = sdf.format(csInfo.getLastedlogintime());
//        String updateTime = sdf.format(csInfo.getUpdatetime());
//        model.addAttribute("createTime",createTime);
//        model.addAttribute("loginTime",loginTime);
//        model.addAttribute("updateTime",updateTime);


        //客户拉黑记录
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("customerid",csInfo.getId());
        List<BlackList> list = this.blackListService.list(qw);
        String nickName[] = new String[list.size()+1];      //存放客服名
        //String time[] = new String[list.size()+1];          //存放时间


        int i=1;
        for(BlackList x: list)
        {

            //根据客服id获取客服名，存放到数组中
            nickName[i] = customerServiceService.getById(x.getCustomerserviceid()).getNickname();
            ++i;
            //time[i] = sdf.format(x.getTime());
        }
        model.addAttribute("list",list);
        model.addAttribute("nickName",nickName);
        //model.addAttribute("time",time);
        return "/customerinfo/customer-black-record";
    }


    @RequestMapping("/chart")
    public String chartTotal(){
        return "/customerinfo/chart";
    }

    @ResponseBody
    @RequestMapping("/prochart")
    public List<CustomerInfo> chart(){
       List<CustomerInfo> list = this.customerInfoService.list();
       return list;
    }
}

