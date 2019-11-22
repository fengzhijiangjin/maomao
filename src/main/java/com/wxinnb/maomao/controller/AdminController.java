package com.wxinnb.maomao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController extends BaseController{

    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
    public String login() {

        return "admin/login";
    }


    //登录动作
    @RequestMapping(value = { "/admin/login" }, method = RequestMethod.POST)
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, ModelMap modelMap){
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return redirect("/admin/index");
        }catch (AuthenticationException e){
            modelMap.put("message",e.getMessage());
            System.out.println(e.getMessage());
        }
        return "admin/login";
    }


    @RequestMapping(value ={"/admin/","/admin/index"})
    public String index(){

        return "admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
    public String welcome(){

        return "admin/welcome";
    }

}
