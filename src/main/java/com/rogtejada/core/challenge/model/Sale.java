package com.rogtejada.core.challenge.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int id;
    private String salesmanName;
    private List<Item> itensList = new ArrayList<>();
    private Double totalPrice = 0D;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public void addItem(Item item){
        itensList.add(item);
        totalPrice+=item.getTotalPrice();
    }

    public List<Item> getItensList() {
        return itensList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
