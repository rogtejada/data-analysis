package com.rogtejada.core.challenge.model;

public class Item{
    private int id;
    private int quantity;
    private Double price;
    private Double totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        this.totalPrice = price*quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
