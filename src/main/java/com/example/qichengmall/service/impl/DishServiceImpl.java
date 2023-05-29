package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.dto.DishDto;
import com.example.qichengmall.entity.DishFlavor;
import com.example.qichengmall.service.DishService;
import com.example.qichengmall.common.CustomException;
import com.example.qichengmall.entity.Dish;
import com.example.qichengmall.mapper.DishMapper;
import com.example.qichengmall.service.DishFlavourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavourService dishFlavourService;
    /**
     * 新增菜品，同时保存对应的口味数据
     * @param dishDto
     */
    @Transactional
    public void saveWithFlavour(DishDto dishDto) {
        this.save(dishDto);

        Long dishid = dishDto.getId();
        List<DishFlavor> flavors=dishDto.getFlavors();
        flavors=flavors.stream().map((item)->{
            item.setDishId(dishid);
            return item;
        }).collect((Collectors.toList()));
        //保存口味数据到dish flavour
        dishFlavourService.saveBatch(flavors);
    }

    /**
     * 根据id回显
     * @param id
     * @return
     */
    public DishDto getByIdFlavour(Long id) {
        Dish dish = this.getById(id);
        DishDto dishDto=new DishDto();
        BeanUtils.copyProperties(dish,dishDto);


        LambdaQueryWrapper<DishFlavor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors=dishFlavourService.list(queryWrapper);
        dishDto.setFlavors(flavors);
        return dishDto;
    }

    @Override
    public void updateWithFlavour(DishDto dishDto) {
        //更新dish表的基本信息
        this.updateById(dishDto);

        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavourService.remove(queryWrapper);

        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors=flavors.stream().map((item)->{
            item.setDishId(dishDto.getId());
            return item;
        }).collect((Collectors.toList()));
        dishFlavourService.saveBatch(flavors);
    }


    /**
     * 删除dish并且删除category的种类????
     * @param ids
     */
    @Transactional
    public void removeDishWithCategory(List<Long> ids) {
    //只能删除停售的dish
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.in(Dish::getId,ids);
        queryWrapper.eq(Dish::getStatus,1);
        int count=this.count(queryWrapper);
        if(count>0){
               throw new CustomException("起售的不能删除哦");
        }
        this.removeByIds(ids);
        //再删除catefory????

    }
}
