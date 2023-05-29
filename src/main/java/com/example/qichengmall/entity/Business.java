package com.example.qichengmall.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Business implements Serializable {
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private String rememberToken;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill =FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    private LocalDateTime lastChangeTime;
    private String username;
    private String businessId;
    private int status;
    private int sex;
    private String personalized;
    private String qrCode;
    private String headerImg;
    private String wxuserId;
    private String joinTime;
    private String deleteTime;
    private String returnProportion;
    private String settlement;
    private String settlementDays;
    private String guideDesc;
    private String clientid;
    private String inviteId;
    private String inviterMobile;
    private String role;
    @TableField(exist = false)
    private Long createUser;
    @TableField(exist = false)
    private Long updateUser;


}
