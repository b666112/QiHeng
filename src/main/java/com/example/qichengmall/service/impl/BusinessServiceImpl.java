package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.entity.Business;
import com.example.qichengmall.entity.vo.BusinessVo;
import com.example.qichengmall.mapper.BusinessMapper;
import com.example.qichengmall.service.BusinessService;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Override
    public void updateById(BusinessVo businessVo) {

    }
}
