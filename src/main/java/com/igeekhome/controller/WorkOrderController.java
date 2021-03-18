package com.igeekhome.controller;


import com.igeekhome.biz.IWorkOrderService;
import com.igeekhome.pojo.Session;
import com.igeekhome.pojo.WorkOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 工作订单 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Slf4j
@Controller
@RequestMapping("/workOrder")
public class WorkOrderController {

    @Autowired
    IWorkOrderService iWorkOrderService;

    @GetMapping("/index")
    public String OrderList(Model model){
        List<WorkOrder> list = iWorkOrderService.list();
        model.addAttribute("OrderList",list);
        return "order/order-list-page";
    }

    @RequestMapping("/del")
    public String del(Model model, @RequestParam Integer id){
        log.info("Delete OrderById" + id);
        this.iWorkOrderService.removeById(id);
        return "redirect:/workOrder/index";
    }
}

