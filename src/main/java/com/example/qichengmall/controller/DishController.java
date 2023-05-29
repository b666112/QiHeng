package com.example.qichengmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qichengmall.entity.DishFlavor;
import com.example.qichengmall.common.R;
import com.example.qichengmall.dto.DishDto;
import com.example.qichengmall.entity.Category;
import com.example.qichengmall.entity.Dish;
import com.example.qichengmall.service.CategoryService;
import com.example.qichengmall.service.DishFlavourService;
import com.example.qichengmall.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavourService dishFlavourService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());
        dishService.saveWithFlavour(dishDto);
        Set keys=redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return R.success("新增菜品成功");
    }

    /**
     * 菜品信息分页
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page<Dish> pageInfo=new Page<>(page,pageSize);
        Page<DishDto> dishDtoPage=new Page<>();

        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Dish::getName,name);
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        dishService.page(pageInfo,queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dishDtoPage,"records");
        List<Dish> records = pageInfo.getRecords();

        List<DishDto> list=records.stream().map((item)->{
            DishDto dishDto=new DishDto();

            BeanUtils.copyProperties(item,dishDto);

            Long categoryId=item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            String categoryName = category.getName();
            dishDto.setCategoryName((categoryName));
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(list);


        return  R.success(dishDtoPage);

    }

    /**
     * 根据id回显菜品信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<DishDto> get(@PathVariable Long id){
        DishDto dishDto = dishService.getByIdFlavour(id);
        return R.success(dishDto);
    }

    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());
        dishService.updateWithFlavour(dishDto);

        Set keys=redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);

        return R.success("新增菜品成功");
    }

    /**
     * 根据条件查询对应的菜品数据
     * @return
     */
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish){
        List<DishDto> list1=null;
        String key="dish_"+dish.getCategoryId()+"_"+dish.getStatus();

       list1 = (List<DishDto>) redisTemplate.opsForValue().get(key);

       if(list1!=null){
           return R.success(list1);
       }



        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus,1);

        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(queryWrapper);

        list1=list.stream().map((item)->{
            DishDto dishDto=new DishDto();
            BeanUtils.copyProperties(item,dishDto);
            Long catagoryId= item.getCategoryId();;
            Category category=categoryService.getById(catagoryId);
            if(category!=null){
                String categoryName= category.getName();
                dishDto.setCategoryName(categoryName);
            }
            //当前菜品Id
            Long dishId=item.getId();
            LambdaUpdateWrapper<DishFlavor> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
            lambdaUpdateWrapper.eq(DishFlavor::getDishId,dishId);
            List<DishFlavor> dishFlavorsList=dishFlavourService.list(lambdaUpdateWrapper);
            dishDto.setFlavors(dishFlavorsList);
            return dishDto;
        }).collect(Collectors.toList());

        redisTemplate.opsForValue().set(key,list1,60, TimeUnit.MINUTES);

        return R.success(list1);
    }

//    @GetMapping("/list")
//    public R<List<Dish>> list(Dish dish){
//        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
//        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
//        queryWrapper.eq(Dish::getStatus,1);
//
//        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
//        List<Dish> list = dishService.list(queryWrapper);
//
//        return R.success(list);
//    }

    @PostMapping("/status/{status}")
    public  R<String> updatestatus(@PathVariable Integer status,@RequestParam Long[] ids) {
        log.info("ids为{}",ids);
        LambdaUpdateWrapper<Dish> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.set(Dish::getStatus,status).in(Dish::getId,ids);
        dishService.update(updateWrapper);
        return R.success("启售");
    }


    @DeleteMapping
    public R<String> deleteByIds(@RequestParam List<Long> ids){
        log.info("请求的ids为{}",ids);
        dishService.removeDishWithCategory(ids);
        Set keys=redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return R.success("删除成功");
    }
}
