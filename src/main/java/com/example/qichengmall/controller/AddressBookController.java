package com.example.qichengmall.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.qichengmall.common.BaseContext;
import com.example.qichengmall.common.R;
import com.example.qichengmall.entity.AddressBook;
import com.example.qichengmall.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/addressBook")
@RestController
@Slf4j
public class AddressBookController{
    @Autowired
    private AddressBookService addressBookService;

    /**
     * 保存地址
     * @param addressBook
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody AddressBook addressBook){
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookService.save(addressBook);
        return R.success("保存成功");
    }

    /**
     * 显示所有地址
     */
    @GetMapping("/list")
    public R<List<AddressBook>> getAll(AddressBook addressBook){
        List<AddressBook> list = addressBookService.list();
        return R.success(list);
    }
    /**
     * 设置默认地址
     */
    @PutMapping("/default")
    public R<String> setdefault(@RequestBody AddressBook addressBook){
        LambdaUpdateWrapper<AddressBook> queryWrapper=new LambdaUpdateWrapper<>();
        queryWrapper.eq(AddressBook::getUserId,BaseContext.getCurrentId());
        queryWrapper.set(AddressBook::getIsDefault,0);
        addressBookService.update(queryWrapper);

        addressBook.setIsDefault(1);
        addressBookService.updateById(addressBook);

        return R.success("默认地址已修改");
    }

    /**
     * 在支付界面时，自动调用默认地址
     *
     */
    @GetMapping("/default")
    public R<AddressBook> getDefaultAddress(){
        LambdaQueryWrapper<AddressBook> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(AddressBook::getIsDefault,1);
        AddressBook serviceOne = addressBookService.getOne(lambdaQueryWrapper);
        return R.success(serviceOne);
    }



    @GetMapping("/{id}")
    public R<AddressBook> getById(@PathVariable Long id){
        AddressBook addressBook = addressBookService.getById(id);
        return R.success(addressBook);
    }

    @PutMapping
    public R<String> update(@RequestBody AddressBook addressBook){
        log.info(addressBook.toString());
        addressBookService.updateById(addressBook);
        return R.success("修改成功");

    }

    @DeleteMapping
    public R<String > delete(@RequestParam long ids){
        addressBookService.removeById(ids);
        return R.success("删除成功");
    }
}
