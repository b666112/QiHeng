package com.example.qichengmall.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessVo implements Serializable {
    private Long id;
    private String name;
    private String mobile;
    private String username;
    private int sex;
    private int status;
    private String inviteManger;
}
