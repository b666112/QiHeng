package com.example.qichengmall.service.impl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.entity.StockOrderInfoEntity;
import com.example.qichengmall.mapper.StockOrderInfoDao;
import com.example.qichengmall.service.StockOrderInfoService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("stockOrderInfoService")
public class StockOrderInfoServiceImpl extends ServiceImpl<StockOrderInfoDao, StockOrderInfoEntity> implements StockOrderInfoService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<StockOrderInfoEntity> page = this.page(
//                new Query<StockOrderInfoEntity>().getPage(params),
//                new QueryWrapper<StockOrderInfoEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}