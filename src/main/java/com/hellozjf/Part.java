package com.hellozjf;

/**
 * Created by zjf on 2017/6/26.
 */
public class Part {

    public Part(String id, String name, String unit, String unitPrice, String quota, String quantity, String price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.quota = quota;
        this.quantity = quantity;
        this.price = price;
    }

    public String id;
    public String name;
    public String unit;
    public String unitPrice;
    public String quota;
    public String quantity;
    public String price;
}
