package com.example.qichengmall.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qichengmall.common.R;
import com.example.qichengmall.dto.ExcelOrderDto;
import com.example.qichengmall.entity.OrderDetail;
import com.example.qichengmall.entity.Orders;
import com.example.qichengmall.service.OrderDetailService;
import com.example.qichengmall.service.OrderService;
import com.example.qichengmall.utils.POIUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/submit")
    public R<String > submit(@RequestBody Orders orders){
        orderService.submit(orders);
        return R.success("下单成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String orderId, String beginTime,String endTime){
        Page pageInfo = orderService.pageByCondition(page, pageSize, orderId, beginTime, endTime);
//        Page pageInfo=new Page(page,pageSize);
//        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();
//        //添加排序条件
//        queryWrapper.orderByDesc(Orders::getOrderTime);
//        //执行查询
//        orderService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
    @Transactional
    @PostMapping("/uploadExcel")
    public R<String> uploadExcel(MultipartFile file) throws IOException {
        List<String[]> strings = POIUtils.readExcel(file);
        ArrayList<ExcelOrderDto> excelOrderDtos = new ArrayList<>();
        for(int i=0;i<strings.size();i++){
            String[] stringArray = strings.get(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime stringArray4 = LocalDateTime.parse(stringArray[4], formatter);
            LocalDateTime stringArray5 = LocalDateTime.parse(stringArray[5], formatter);
            ExcelOrderDto excelOrderDto = new ExcelOrderDto();
            excelOrderDto.setOrderId(stringArray[0]);
            excelOrderDto.setStatus(Integer.valueOf(stringArray[1]));
            excelOrderDto.setUserId(Long.valueOf(stringArray[2]));
            excelOrderDto.setAddressBookId(Long.valueOf(stringArray[3]));
            excelOrderDto.setOrderTime(stringArray4);
            excelOrderDto.setCheckoutTime(stringArray5);
            excelOrderDto.setPayMethod(Integer.valueOf(stringArray[6]));
            excelOrderDto.setAmount(new BigDecimal(stringArray[7]));
            excelOrderDto.setRemark(stringArray[8]);
            excelOrderDto.setPhone(stringArray[9]);
            excelOrderDto.setAddress(stringArray[10]);
            excelOrderDto.setUserName(stringArray[11]);
            excelOrderDto.setConsignee(stringArray[12]);
            excelOrderDto.setImage(stringArray[13]);
            excelOrderDto.setProductId(Long.valueOf(stringArray[14]));
            excelOrderDto.setProductName(stringArray[15]);
            excelOrderDto.setNumber(Long.valueOf(stringArray[16]));
            excelOrderDtos.add(excelOrderDto);
        }
        Map<String, List<ExcelOrderDto>> collect = excelOrderDtos.stream().collect(Collectors.groupingBy(ExcelOrderDto::getOrderId));
        for (String s : collect.keySet()) {
            BigDecimal sum= BigDecimal.valueOf(0);
            BigDecimal temp;
            List<ExcelOrderDto> OrderDtos = collect.get(s);
            ExcelOrderDto excelOrderDto = OrderDtos.get(0);
            Orders orders = new Orders();
            BeanUtils.copyProperties(excelOrderDto,orders);
            for (ExcelOrderDto orderDto : OrderDtos) {
                temp = sum.add(new BigDecimal(String.valueOf(orderDto.getAmount())));
                sum=temp;
                OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(orderDto, orderDetail);
            orderDetail.setName(orderDto.getProductName());
            orderDetail.setOrderId(Long.valueOf((orderDto.getOrderId())));
            orderDetail.setNumber(Math.toIntExact(orderDto.getNumber()));
            orderDetailService.save(orderDetail);
            }
            //遍历订单项的金额，求总价格
            orders.setAmount(sum);
            orderService.save(orders);
        }


        return R.success("表格订单保存成功");
    }
//@Transactional
//void extracted(ExcelOrderDto excelOrderDto) {
//        Orders orders = new Orders();
//        BeanUtils.copyProperties(excelOrderDto,orders);
//        orderService.save(orders);
//        OrderDetail orderDetail = new OrderDetail();
//        BeanUtils.copyProperties(excelOrderDto, orderDetail);
//        orderDetail.setName(excelOrderDto.getProductName());
//        orderDetail.setOrderId(Long.valueOf((excelOrderDto.getOrderId())));
//        orderDetail.setNumber(Math.toIntExact(excelOrderDto.getNumber()));
//        orderDetailService.save(orderDetail);
//
//    }
//    //        Orders byId = orderService.getById(excelOrderDto.getOrderId());
////        //excelOrderDto是某一个订单里的一个订单项！！！先去查数据库有没有该订单，如果有订单的话
////        if (byId==null){
////            extracted(excelOrderDto);
////        }
////        else {
////            OrderDetail orderDetail = new OrderDetail();
////            BeanUtils.copyProperties(excelOrderDto, orderDetail);
////            orderDetail.setName(excelOrderDto.getProductName());
////            orderDetail.setOrderId(Long.valueOf((excelOrderDto.getOrderId())));
////            orderDetail.setNumber(Math.toIntExact(excelOrderDto.getNumber()));
////            orderDetailService.save(orderDetail);
////        }


}
