package com.example.qichengmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qichengmall.dto.DishDto;
import com.example.qichengmall.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {
    //新增菜品，同时插入对应口味数据，需要操作两个表:dish,dish_flavour
    public void saveWithFlavour(DishDto dishDto);


    public DishDto getByIdFlavour(Long id);

    public void updateWithFlavour(DishDto dishDto);

    public  void removeDishWithCategory(List<Long> ids);
}
