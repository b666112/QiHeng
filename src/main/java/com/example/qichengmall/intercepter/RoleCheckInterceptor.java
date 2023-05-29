package com.example.qichengmall.intercepter;

import com.alibaba.fastjson.JSON;
import com.example.qichengmall.common.R;
import com.example.qichengmall.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class RoleCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("RoleCheckInterceptor拦截到请求: {}",request.getRequestURI());
        //如果这个请求需要处理，鉴别身份role
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        String role = employee.getRole();
        if (role.equals("admin")) {
            //放行
            return true;
        } else {
            response.getWriter().write(JSON.toJSONString(R.error("NO PERMISSION!")));
            return false;
        }

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
