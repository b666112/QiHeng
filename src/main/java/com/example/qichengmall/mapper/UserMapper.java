package com.example.qichengmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qichengmall.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
