package com.example.qichengmall.mapper;

import com.example.qichengmall.entity.StockOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存销售订单
 * 
 * @author HuChangQi
 * @email 1029812802@qq.com
 * @date 2023-04-28 13:28:34
 */
@Mapper
public interface StockOrderDao extends BaseMapper<StockOrderEntity> {
	
}
