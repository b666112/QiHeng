package com.example.qichengmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qichengmall.entity.Employee;

public interface EmployeeService extends IService<Employee>  {
    String getInviteManger(String inviteId);
}
