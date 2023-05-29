package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.service.OrderDetailService;
import com.example.qichengmall.entity.OrderDetail;
import com.example.qichengmall.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>implements OrderDetailService {
}
