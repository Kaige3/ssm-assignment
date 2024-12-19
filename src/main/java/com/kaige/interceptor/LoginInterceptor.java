package com.kaige.interceptor;

import com.kaige.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器执行了postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器执行了afterCompletion");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 白名单，放行登录接口
        if ("/ssm_demo_war_exploded/user/login".equals(request.getRequestURI())){
            return true;
        }
        // 从请求头获取token字符串 解析
        Claims claims = JwtUtils.validateToken(request.getHeader("Authorization"));
        if (claims != null){
            return true;
        }
        // 走到这里代表是其他接口 但是没有token 或者token过期
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("请先登录");
        writer.flush();
        writer.close();
        return false;
    }

}
