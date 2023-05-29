package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.entity.AddressBook;
import com.example.qichengmall.mapper.AddressBookMapper;
import com.example.qichengmall.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>implements AddressBookService {

}
