package com.rogtejada.core.challenge.service;

import com.rogtejada.core.challenge.model.Sale;

import java.util.*;

public class SaleManager {
    private static SaleManager instance;

    private List<Sale> saleList = new ArrayList<>();
    private SalesmanManager salesmanManager = SalesmanManager.getInstance();

    private SaleManager(){}

    public static synchronized SaleManager getInstance(){
        if(instance==null){
            instance = new SaleManager();
        }
        return instance;
    }

    public void addSale(Sale sale){
        if(!findSaleById(sale.getId()).isPresent()) {
            saleList.add(sale);
            addSaleInformationToSalesman(sale);
        }
    }

    private void addSaleInformationToSalesman(Sale sale){
        if(salesmanManager.findSalesmanByName(sale.getSalesmanName()).isPresent()) {
            salesmanManager.findSalesmanByName(sale.getSalesmanName()).get().setAmountSold(sale.getTotalPrice());
        }
    }

    public int getMostExpansiveSale(){
        ordenateSales();
        return saleList.get(0).getId();
    }

    public void ordenateSales(){
        Collections.sort(saleList, Comparator.comparing(Sale::getTotalPrice).reversed());
    }

    public Optional<Sale> findSaleById(int id){
        return saleList.stream().filter(sale -> sale.getId()==id).findFirst();
    }

    public List<Sale> getSaleList() {
        return saleList;
    }
}
