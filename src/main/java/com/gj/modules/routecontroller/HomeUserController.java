package com.gj.modules.routecontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * 主页用户相关页面映射
 */
@Controller
public class HomeUserController {

    /**
     * 大门主页
     * @return
     */
    @RequestMapping({"/", "/index"})
    public String index(){
        return "security/index/index";
    }

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "security/index/login";
    }

    /**
     * 登录后主页
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping("/backHome")
    public String user(/*@AuthenticationPrincipal Principal principal, Model model*/){
//        model.addAttribute("username", principal.getName());
        return "security/index/backHome";
    }


    /**
     * 登录后管理员能看的界面
     * @param principal
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String admin(/*@AuthenticationPrincipal Principal principal, Model model*/){
//        model.addAttribute("username", principal.getName());
        return "security/admin/admin";
    }

}
