package com.gj.modules.controller;

import com.gj.modules.model.VerifyCode;
import com.gj.modules.service.IVerifyCodeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 关于验证码
 * @author ：gengjian
 * @date ：Created in 2020/6/19 14:56
 */

@RestController
public class VerificationCodeController {

    @Autowired
    private IVerifyCodeGen iVerifyCodeGen;

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code.toUpperCase());
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {

        }
    }

    @GetMapping("/provingCode/{code}")
    public String provingCode(HttpServletRequest request, @PathVariable String code){

        String verifyCode = (String) request.getSession().getAttribute("VerifyCode");

        if(verifyCode.equals(code.toUpperCase())){
            return "验证成功";
        }else{
            return "验证失败";
        }
    }



}