//package com.example.qichengmall.config;
//
//
//import com.example.qichengmall.service.EmployeeService;
//import com.example.qichengmall.service.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    //授权
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    //认证
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/front/**").permitAll()
//                .antMatchers("/backend/index.html").hasRole("admin");
//        //开启自动配置登录
//        http.formLogin().loginPage("/backend/page/login/login.html")
//                .loginProcessingUrl("/employee/login")
//                .usernameParameter("username")
//                .passwordParameter("password");
//
//
//        //开启自动配置退出登录
//        http.logout().logoutUrl("/employee/logout").logoutSuccessUrl("/backend/page/login/login.html");
//
//
//        http.rememberMe();
//
//    }
//}
//
//
