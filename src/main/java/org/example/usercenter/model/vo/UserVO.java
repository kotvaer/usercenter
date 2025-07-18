package org.example.usercenter.model.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
}