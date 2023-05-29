package com.example.qichengmall.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderDetailVo implements Serializable {
    private String name;
    private String image;
    private Integer number;
    private BigDecimal amount;
}
