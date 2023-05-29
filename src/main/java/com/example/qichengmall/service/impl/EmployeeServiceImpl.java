package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.entity.Employee;
import com.example.qichengmall.mapper.EmployeeMapper;
import com.example.qichengmall.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService{
    @Override
    public String getInviteManger(String inviteId) {
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getId,inviteId);
        Employee one = this.getOne(queryWrapper);
        return one.getName();
    }
}
