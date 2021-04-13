package com.xyd.shop.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private int id;
    private Date date;
    private int status;
    private int gid;
    private int aid;
    private int uid;
}
