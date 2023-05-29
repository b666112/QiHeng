package com.example.qichengmall.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qichengmall.entity.Orders;

public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);

    Page pageByCondition(int page, int pageSize, String orderId, String beginTime, String endTime);
}
