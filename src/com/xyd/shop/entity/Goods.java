package com.xyd.shop.entity;

import lombok.Data;

@Data
public class Goods {
    private int id;
    private int cid;
    private String name;
    private double price;
    private int reserve;
    private String image;
}
