package com.rogtejada.core.challenge.model;

public class OutputModel {
    private int clientQuantity;
    private int salemanQuantity;
    private int mostExpansiveSale;
    private Salesman worstSalesmanEver;

    public int getClientQuantity() {
        return clientQuantity;
    }

    public void setClientQuantity(int clientQuantity) {
        this.clientQuantity = clientQuantity;
    }

    public int getSalemanQuantity() {
        return salemanQuantity;
    }

    public void setSalemanQuantity(int salemanQuantity) {
        this.salemanQuantity = salemanQuantity;
    }

    public int getMostExpansiveSale() {
        return mostExpansiveSale;
    }

    public void setMostExpansiveSale(int mostExpansiveSale) {
        this.mostExpansiveSale = mostExpansiveSale;
    }

    public Salesman getWorstSalesmanEver() {
        return worstSalesmanEver;
    }

    public void setWorstSalesmanEver(Salesman worstSalesmanEver) {
        this.worstSalesmanEver = worstSalesmanEver;
    }

    @Override
    public String toString() {
        return "clientQuantity=" + clientQuantity +
                "\nsalemanQuantity=" + salemanQuantity +
                "\nmostExpansiveSale=" + mostExpansiveSale +
                "\nworstSalesmanEver=" + worstSalesmanEver;
    }
}
