package com.wangqiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @version : V1.0
 * @ClassName: Login
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 22:07
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Model model){
        if ( !StringUtils.isEmpty(username) && "1".equals(password)){
            //登录成功！
            session.setAttribute("username",username);
            //登录成功！防止表单重复提交，我们重定向
            return "redirect:/main.html";
        }else {
            //登录失败！存放错误信息
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }


    @GetMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
