package com.igeekhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.igeekhome.biz.IRoleManageService;

import com.igeekhome.pojo.RoleManage;
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
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色管理 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */

@Slf4j
@Controller
@RequestMapping("/roleManage")
public class RoleManageController {

    @Autowired
    IRoleManageService iRoleManegeService;

    @GetMapping("/index")
    public String RoleManageList(Model model){

        List<RoleManage> list = this.iRoleManegeService.list();
        model.addAttribute("RoleManageList",list);
        return "rolemanage/role-manage-list";
    }


    @RequestMapping("/del")
    public String del(Model model, @RequestParam Integer id){
        log.info("Delete RoleManageById" + id);
        this.iRoleManegeService.removeById(id);
        return "redirect:/roleManage/index";
    }

    @GetMapping("/update")
    public String updatePage(Model model,@RequestParam Integer id){
        RoleManage roleManage = this.iRoleManegeService.getById(id);
        model.addAttribute("role",roleManage);
        System.out.println(roleManage.getRoleid());
        return "rolemanage/rolemanage-update";
    }

    @PostMapping("/updateById")
    public String updateProfile(RoleManage roleManage,Model model){

        this.iRoleManegeService.updateById(roleManage);
        List<RoleManage> list = this.iRoleManegeService.list();
        model.addAttribute("RoleManageList",list);
        return "rolemanage/role-manage-list";

    }



}

