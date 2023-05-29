//package com.example.qichengmall.entity;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//public class UserDao {
//    private Long id;
//    public String username;
//    public String password;
//    public String role;
//
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //获取用户所有权限
//        String[] roles = role.split(",");
//        //取出所有的权限，并且给每个权限都要进行认证，添加到 SimpleGrantedAuthority()
//        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
//        //遍历roles，取出每一个权限，添加到 简单的授予认证类
//        for (String s : roles) {
//            //添加了 ROLE_ 前缀 为了前端页面thymeleaf-security 中自带的 hasRole()方法，能得到ROLE_格式的角色信息
//            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(s));
//        }
//        //返回到已经被 授予认证的权限集合 这里面的角色所拥有的权限都已经被spring security所知道
//        return simpleGrantedAuthorities;
//    }
//}
