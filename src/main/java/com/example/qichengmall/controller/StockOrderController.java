//package com.example.qichengmall.controller;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.qichengmall.common.R;
//import com.example.qichengmall.entity.Orders;
//import com.example.qichengmall.entity.StockOrderEntity;
//import com.example.qichengmall.service.StockOrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
///**
// * 库存销售订单
// *
// * @author HuChangQi
// * @email 1029812802@qq.com
// * @date 2023-04-28 13:28:34
// */
//@RestController
//@RequestMapping("order/stockorder")
//public class StockOrderController {
//    @Autowired
//    private StockOrderService stockOrderService;
//
//    /**
//     * 分页查询订单
//     */
//    @GetMapping("/page")
////    @RequiresPermissions("order:stockorder:list")
//    public R<Page> list(int page, int pageSize){
//        Page pageInfo = new Page(page, pageSize);
//        LambdaQueryWrapper<StockOrderEntity> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.orderByDesc(StockOrderEntity::getSaleDate);
//        stockOrderService.page(pageInfo,queryWrapper);
////        PageUtils page = stockOrderService.queryPage(params);
//        return R.success(pageInfo);
//    }
//
////    public R<Page> page(int page, int pageSize){
////        Page pageInfo=new Page(page,pageSize);
////        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();
////        //添加排序条件
////        queryWrapper.orderByDesc(Orders::getOrderTime);
////        //执行查询
////        orderService.page(pageInfo,queryWrapper);
////        return R.success(pageInfo);
////    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("order:stockorder:info")
//    public R info(@PathVariable("id") Integer id){
//		StockOrderEntity stockOrder = stockOrderService.getById(id);
//
//        return R.success(stockOrder);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("order:stockorder:save")
//    public R save(@RequestBody StockOrderEntity stockOrder){
//		stockOrderService.save(stockOrder);
//
//        return R.success("保存成功");
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//   // @RequiresPermissions("order:stockorder:update")
//    public R update(@RequestBody StockOrderEntity stockOrder){
//		stockOrderService.updateById(stockOrder);
//
//        return R.success("更新成功");
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//   // @RequiresPermissions("order:stockorder:delete")
//    public R delete(@RequestParam List<Long> ids){
//		stockOrderService.removeByIds(ids);
//
//        return R.success("删除成功");
//    }
//
//}
