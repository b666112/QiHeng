package com.example.qichengmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qichengmall.entity.Business;
import com.example.qichengmall.entity.vo.BusinessVo;
import org.springframework.stereotype.Service;

public interface BusinessService extends IService<Business> {
    void updateById(BusinessVo businessVo);
}
