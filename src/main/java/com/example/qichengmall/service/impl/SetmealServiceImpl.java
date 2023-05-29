package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.dto.SetmealDto;
import com.example.qichengmall.service.SetmealService;
import com.example.qichengmall.common.CustomException;
import com.example.qichengmall.entity.Setmeal;
import com.example.qichengmall.entity.SetmealDish;
import com.example.qichengmall.mapper.SetmealMapper;
import com.example.qichengmall.service.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper,Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //先保存套餐基本信息(setmeal)
        this.save(setmealDto);
        //在保存关联信息
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return  item;
        }).collect(Collectors.toList());
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids) {
        //只能删除停售的套餐
        LambdaQueryWrapper<Setmeal> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);

        int count=this.count(queryWrapper);
        if (count>0){
            throw  new CustomException("套餐正在售卖不能删除");
        }
        //如果可以删除,先删除setmeal
        this.removeByIds(ids);
        //再删除setmealDish
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);

        setmealDishService.remove(lambdaQueryWrapper);
    }
}
