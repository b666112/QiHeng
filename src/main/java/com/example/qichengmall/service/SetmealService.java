package com.example.qichengmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qichengmall.dto.SetmealDto;
import com.example.qichengmall.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐的菜品关联信息
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
