package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.igeekhome.biz.IWorkOrderService;
import com.igeekhome.pojo.Session;
import com.igeekhome.pojo.WorkOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public String orderList(Model model){
        List<WorkOrder> list = iWorkOrderService.list();
        model.addAttribute("OrderList",list);
        return "order/order-list-page";
    }

    /**
     * 查看工单详细资料
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public String find(Model model, @RequestParam Integer id){
        log.info("find OrderById" + id);
        this.iWorkOrderService.removeById(id);
        return "redirect:/workOrder/index";
    }

    /**
     * 修改工单信息
     * @param session
     * @param id
     * @return
     */
    @GetMapping("/update")
    public String updatePage(HttpSession session, @RequestParam Integer id){
        session.setAttribute("orderId",id);
        return "order/order-update";
    }

    @PostMapping("/updateById")
    public String update(WorkOrder workOrder, HttpSession session){
        LocalDateTime localDateTime = LocalDateTime.now();
        workOrder.setUpdatetime(localDateTime);
        Integer orderId = (Integer) session.getAttribute("orderId");
        UpdateWrapper<WorkOrder> up = new UpdateWrapper<>();
        up.eq("id",orderId);
        this.iWorkOrderService.update(workOrder, up);
        return "redirect:/workOrder/index";
    }

    @RequestMapping("/del")
    public String del(Model model, @RequestParam Integer id){
        log.info("Delete OrderById" + id);
        this.iWorkOrderService.removeById(id);
        return "redirect:/workOrder/index";
    }


    @PostMapping("/add")
    public String addOrder(WorkOrder workOrder, Model model){
        if(workOrder.getCustomerserviceid() != null && workOrder.getCustomerid() != null){
            workOrder.setState("未处理");
            LocalDateTime localDateTime = LocalDateTime.now();
            workOrder.setCreatetime(localDateTime);
            workOrder.setChannel("自动录入");
            this.iWorkOrderService.save(workOrder);
            return "redirect:/workOrder/index";
        } else{
            model.addAttribute("fail_msg", "创建工单失败");
            return "order/order-list-page";
        }
    }
}

