package com.example.qichengmall.service.impl;

import com.example.qichengmall.entity.StockOrderEntity;
import com.example.qichengmall.mapper.StockOrderDao;
import com.example.qichengmall.service.StockOrderService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("stockOrderService")
public class StockOrderServiceImpl extends ServiceImpl<StockOrderDao, StockOrderEntity> implements StockOrderService {


}