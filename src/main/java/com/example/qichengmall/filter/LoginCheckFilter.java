package com.example.qichengmall.filter;

import com.alibaba.fastjson.JSON;
import com.example.qichengmall.common.BaseContext;
import com.example.qichengmall.common.R;
import com.example.qichengmall.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*检查
*/
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
@Order(1)
public class LoginCheckFilter implements Filter {
    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER =new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        //获取本次请求的uri
        String requestURI=request.getRequestURI();
//        log.info("拦截到请求: {}",requestURI);

        String[] urls=new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };
        //判断本次请求是否需要处理
        boolean check=check(urls,requestURI);

        //如果不需要处理，则直接放行
        if(check){
//            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }

        //判断登录状态(employee)
        if(request.getSession().getAttribute("employee")!=null){
            log.info("用户已登录,用户id为:{}",request.getSession().getAttribute("employee"));

            Employee employee = (Employee) request.getSession().getAttribute("employee");
            Long empId = employee.getId();
            BaseContext.setCurrentId(empId);
            long id = Thread.currentThread().getId();
            log.info("线程id为：{}",id);


            filterChain.doFilter(request,response);
            return;
        }

        if(request.getSession().getAttribute("user")!=null){
            log.info("用户已登录,用户id为:{}",request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);
            long id = Thread.currentThread().getId();
            log.info("线程id为：{}",id);


            filterChain.doFilter(request,response);
            return;
        }
        else {
            log.info("用户未登录");
            //如果未登录则放回登录结果
            response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
            return ;
        }



    }

    public boolean check(String[] urls,String requestURI){
        for (String url:urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
