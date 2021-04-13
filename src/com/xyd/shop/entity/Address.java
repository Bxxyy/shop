package com.xyd.shop.entity;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.Data;
import org.w3c.dom.ls.LSOutput;

@Data
public class Address {
    private int id;
    private String name;
    private int phone;
    private String address;
    private int uid;
    private int age;
}
