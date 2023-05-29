package com.example.qichengmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.qichengmall.common.R;
import com.example.qichengmall.entity.OrderDetail;
import com.example.qichengmall.entity.vo.OrderDetailVo;
import com.example.qichengmall.service.OrderDetailService;
import com.example.qichengmall.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderDetail")
@Slf4j
public class OrderDetailController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @GetMapping("/{orderId}")
    public R<List<OrderDetailVo>> getDetailByOrderId(@PathVariable Long orderId){
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId,orderId);
        List<OrderDetail> list = orderDetailService.list(queryWrapper);
        List<OrderDetailVo> collect = list.stream().map(item -> {
            OrderDetailVo orderDetailVo = new OrderDetailVo();
            BeanUtils.copyProperties(item, orderDetailVo);
            return orderDetailVo;
        }).collect(Collectors.toList());
        return R.success(collect);

    }
}
