package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.common.CustomException;
import com.example.qichengmall.entity.Category;
import com.example.qichengmall.entity.Dish;
import com.example.qichengmall.entity.Setmeal;
import com.example.qichengmall.mapper.CategoryMapper;
import com.example.qichengmall.service.CategoryService;
import com.example.qichengmall.service.DishService;
import com.example.qichengmall.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category>implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id){
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper=new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = dishService.count(dishLambdaQueryWrapper);

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper=new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count1 = setmealService.count(setmealLambdaQueryWrapper);


        //查询当前分类是否关联菜品，如果已经关联，抛出一个业务异常
        if(count>0){
            throw new CustomException("当前分类关联了菜品，不能删除");
        }

        //查询当前分类是否关联套餐，如果已经关联，抛出一个业务异常
        if(count1>0){
            throw new CustomException("当前分类关联了套餐,不能删除");
        }
        //正常删除分类
        super.removeById(id);
    }
}
