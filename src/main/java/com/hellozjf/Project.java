package com.hellozjf;

/**
 * Created by zjf on 2017/6/26.
 */
public class Project {

    public Project(String range, String name, String item, String detailItem, String unit, String quantity, String tableId) {
        this.range = range;
        this.name = name;
        this.item = item;
        this.detailItem = detailItem;
        this.unit = unit;
        this.quantity = quantity;
        this.tableId = tableId;
    }

    public String range;
    public String name;
    public String item;
    public String detailItem;
    public String unit;
    public String quantity;
    public String tableId;
}
