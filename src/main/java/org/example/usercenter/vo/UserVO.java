package org.example.usercenter.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
}