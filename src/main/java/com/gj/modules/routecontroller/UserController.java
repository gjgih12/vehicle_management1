package com.gj.modules.routecontroller;

import org.springframework.stereotype.Controller;

/**
 * 定义用户相关网址映射的Controller
 */
@Controller
public class UserController {

    /*@RequestMapping("/backHome")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "index/backHome";
    }





    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "admin/admin";
    }*/
}
