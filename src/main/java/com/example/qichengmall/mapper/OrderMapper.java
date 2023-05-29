package com.example.qichengmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qichengmall.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
