//package com.example.qichengmall.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.example.qichengmall.entity.Employee;
//import com.example.qichengmall.entity.UserDao;
//import com.example.qichengmall.service.EmployeeService;
//import com.example.qichengmall.service.UserDaoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Component
//public class UserDetailsServiceImpl implements UserDetailsService {
//
////    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserDaoService userDaoService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        LambdaQueryWrapper<UserDao> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(UserDao::getUsername,username);
//        UserDao user = userDaoService.getOne(queryWrapper);
//        if(user == null){
//            return null;
//        }else{
//            User userDetail = new User(user.getUsername(),user.getPassword(),user.getAuthorities());
//            System.out.println("管理员信息："+user.getUsername()+"   "+"  "+user.getAuthorities());
//            return userDetail;
//        }
//    }
//}
