package com.example.qichengmall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qichengmall.common.R;
import com.example.qichengmall.entity.Business;
import com.example.qichengmall.entity.Employee;
import com.example.qichengmall.entity.vo.BusinessVo;
import com.example.qichengmall.service.BusinessService;
import com.example.qichengmall.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        Page<Business> pageInfo = new Page<>(page, pageSize);

        LambdaQueryWrapper<Business> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(name),Business::getName,name);
        Page<Business> businessPage = businessService.page(pageInfo, queryWrapper);
        List<Business> records = businessPage.getRecords();

        //todo 循环查库了，可以优化
        List<BusinessVo> collect = records.stream().map(item -> {
            BusinessVo businessVo = new BusinessVo();
            String inviteManger = employeeService.getInviteManger(item.getInviteId());
            BeanUtils.copyProperties(item,businessVo);
            businessVo.setInviteManger(inviteManger);
            return businessVo;
        }).collect(Collectors.toList());
        Page<BusinessVo> pagenow = new Page<>(page, pageSize);
        pagenow.setTotal(pageInfo.getTotal());
        pagenow.setRecords(collect);
        return R.success(pagenow);
    }

    @PutMapping("/update")
    public R<String> update(HttpServletRequest request, @RequestBody Business business){
        businessService.updateById(business);
        return R.success("商家信息修改成功");
    }
    @PutMapping("/updatePassword")
    public R<String> updatePassword(String password,Long id){
        Business byId = businessService.getById(id);
        if(password.equals("")||password.length()==0){
            byId.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        businessService.updateById(byId);
        return R.success("商家信息修改成功");
    }


    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody BusinessVo businessVo){
        Business business = new Business();
        BeanUtils.copyProperties(businessVo,business);
        business.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        //获得当前用户登录id
        Employee employee1 = (Employee) request.getSession().getAttribute("employee");
        Long id = employee1.getId();
        business.setInviteId(String.valueOf(id));
        business.setRole("business");
        businessService.save(business);
        return R.success("保存成功");
    }
    @GetMapping("/{id}")
    public R<BusinessVo> getById(@PathVariable Long id){
        log.info("根据员工id{}查询信息",id);
        Business business = businessService.getById(id);
        BusinessVo businessVo = new BusinessVo();
        BeanUtils.copyProperties(business,businessVo);
        return R.success(businessVo);
    }
}
