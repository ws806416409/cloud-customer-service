package com.igeekhome.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.igeekhome.biz.INoticeService;
import com.igeekhome.biz.impl.NoticeServiceImpl;
import com.igeekhome.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 通知表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-16
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService iNoticeService;

    @RequestMapping("/iSettings")
    public String Notice(Model model){


        return "mysetting/page-isettings";
    }

    @RequestMapping("/noticeset")
    public String noticeSet(){

        return "mysetting/page-isettings";
    }

    @RequestMapping("/noticeinsert")
    public String uploadNotice(Notice no,HttpSession session,Model model){


        if(no.getContent() != "")
        {
            System.out.println(no.getContent());
            System.out.println(no.getCreatorid());
            System.out.println(no.getCreatorid());
            this.iNoticeService.save(no);
            model.addAttribute("notice_msg", "发布成功");
        } else {
            model.addAttribute("notice_msg","请至少填写公告内容");
        }
        QueryWrapper qw =new QueryWrapper();
        qw.orderByDesc("id");
        List<Notice> list = iNoticeService.list(qw);
        session.setAttribute("notice",list);

        return "mysetting/page-isettings";
    }


//    @RequestMapping("/getNotices")
//    public void getNotices(HttpSession session){
//        //通告栏
//        List<Notice> list = iNoticeService.list();
//        session.setAttribute("notice",list);
//    }


}

