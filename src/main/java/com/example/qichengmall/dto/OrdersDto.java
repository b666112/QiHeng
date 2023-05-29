package com.example.qichengmall.dto;

import com.example.qichengmall.entity.OrderDetail;
import com.example.qichengmall.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
