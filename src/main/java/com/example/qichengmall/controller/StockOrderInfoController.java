//package com.example.qichengmall.controller;
//
//import java.util.Arrays;
//import java.util.Map;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.qichengmall.common.R;
//import com.example.qichengmall.entity.StockOrderInfoEntity;
//import com.example.qichengmall.service.StockOrderInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//
//
///**
// * 库存销售订单详情
// *
// * @author HuChangQi
// * @email 1029812802@qq.com
// * @date 2023-04-28 13:28:34
// */
//@RestController
//@RequestMapping("order/stockorderinfo")
//public class StockOrderInfoController {
//    @Autowired
//    private StockOrderInfoService stockOrderInfoService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//   // @RequiresPermissions("order:stockorderinfo:list")
//    public R list(int page, int pageSize){
//        Page pageInfo = new Page(page, pageSize);
//        LambdaQueryWrapper<StockOrderInfoEntity> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.orderByDesc(StockOrderInfoEntity::getUpdatedAt);
//        stockOrderInfoService.page(pageInfo,queryWrapper);
//
//        return R.success(pageInfo);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//   // @RequiresPermissions("order:stockorderinfo:info")
//    public R info(@PathVariable("id") Integer id){
//		StockOrderInfoEntity stockOrderInfo = stockOrderInfoService.getById(id);
//
//        return R.success(stockOrderInfo);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//   // @RequiresPermissions("order:stockorderinfo:save")
//    public R<String> save(@RequestBody StockOrderInfoEntity stockOrderInfo){
//		stockOrderInfoService.save(stockOrderInfo);
//
//        return R.success("保存成功");
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//  //  @RequiresPermissions("order:stockorderinfo:update")
//    public R update(@RequestBody StockOrderInfoEntity stockOrderInfo){
//		stockOrderInfoService.updateById(stockOrderInfo);
//
//        return R.success("更新成功");
//    }
//
//    /**
//     * 删除
//     */
//    @DeleteMapping("/delete")
//   // @RequiresPermissions("order:stockorderinfo:delete")
//    public R<String> delete(@RequestBody Integer[] ids){
//		stockOrderInfoService.removeByIds(Arrays.asList(ids));
//
//        return R.success("删除成功");
//    }
//
//}
