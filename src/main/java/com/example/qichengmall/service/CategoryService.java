package com.example.qichengmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qichengmall.entity.Category;

public interface CategoryService extends IService<Category> {

    public void remove(Long id);
}
