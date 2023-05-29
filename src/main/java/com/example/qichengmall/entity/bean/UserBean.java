package com.example.qichengmall.entity.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserBean {
    private String userId;
    private String userName;
    private String userPass;
    private List<RoleBean> userRoles=new ArrayList<>();
    private  List<ReasourceBean> resourceBeans =new ArrayList<>();

    public boolean havaPermission(String resource){
        return this.resourceBeans.stream()
                .filter(resourceBean -> resourceBean.getResourceName().equals(resource))
                .count()>0;
    }
}
