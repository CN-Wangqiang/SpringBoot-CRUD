package com.wangqiang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import sun.security.krb5.internal.CredentialsUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version : V1.0
 * @ClassName: MyHandlerIntercepter
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 22:38
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username == null){//未登录，返回登录页面
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            //登录，放行
            return true;
        }

    }
}
