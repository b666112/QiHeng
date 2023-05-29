package com.example.qichengmall.entity.bean;

import lombok.Data;

import java.util.List;
@Data
public class RoleBean {
    private String roleId;
    private String roleName;
    private List<ReasourceBean> resources;

}
