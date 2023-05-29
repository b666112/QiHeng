package com.example.qichengmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.qichengmall.entity.ShoppingCart;
import com.example.qichengmall.common.BaseContext;
import com.example.qichengmall.common.R;
import com.example.qichengmall.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shoppingCart")
@RestController
@Slf4j
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     * @param shoppingCart
     * @return
     */
    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart){

        //设置用户id,指定是哪个用户的购物车
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);
        //查询菜品是否在购物车中
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();

        Long dishId = shoppingCart.getDishId();

        queryWrapper.eq(ShoppingCart::getUserId,currentId);
        if(dishId!=null){
            //添加到购物车的是菜品
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }else{
            //添加到购物车的是套餐
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }
        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);
        //如果存在，就在原来基础上加一
        if(cartServiceOne!=null){
            Integer number = cartServiceOne.getNumber();
            cartServiceOne.setNumber(number+1);
            shoppingCartService.updateById(cartServiceOne);
        }else {
            //如果不存在，就添加到购物车，默认数量是一
            shoppingCart.setNumber(1);
            shoppingCartService.save(shoppingCart);
            cartServiceOne=shoppingCart;
        }
        return R.success(cartServiceOne);
    }

    /**
     *查看购物车
     * @return
     */
    @GetMapping("/list")
    public R<List<ShoppingCart>> list(){
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);
        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);
        return R.success(list);
    }

    /**
     * 清空购物车
     */
    @DeleteMapping("/clean")
    public R<String> clean(){
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        shoppingCartService.remove(queryWrapper);
        return R.success("清空购物车成功");
    }

    /**
     * 删除购物车的一项
     */
    @PostMapping("/sub")
    public R<ShoppingCart> deleteById(@RequestBody ShoppingCart shoppingCart){
        Long dishId = shoppingCart.getDishId();
        Long setmealId = shoppingCart.getSetmealId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        if(dishId!=null){
            queryWrapper.eq(ShoppingCart::getDishId,dishId);
        }else{
            queryWrapper.eq(ShoppingCart::getSetmealId,setmealId);
        }
        ShoppingCart shoppingCartServiceOne = shoppingCartService.getOne(queryWrapper);
        Integer number = shoppingCartServiceOne.getNumber();
        shoppingCartServiceOne.setNumber(number-1);
        if(shoppingCartServiceOne.getNumber()==0){
            shoppingCartService.removeById(shoppingCartServiceOne);
        }else{
            shoppingCartService.updateById(shoppingCartServiceOne);
        }

        return R.success(shoppingCartServiceOne);

    }
}
