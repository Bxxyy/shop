package com.xyd.shop.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int phone;
    private int rid;
}
