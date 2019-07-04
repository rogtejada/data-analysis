package com.rogtejada.core.challenge.service;

import com.rogtejada.core.challenge.model.Salesman;

import java.util.*;

public class SalesmanManager {
    private static SalesmanManager instance;

    private List<Salesman> salesmanList = new ArrayList<>();

    private SalesmanManager(){}

    public static synchronized SalesmanManager getInstance(){
        if(instance==null){
            instance = new SalesmanManager();
        }
        return instance;
    }

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void addSalesman(Salesman salesman){
        if(!findSalesmanByName(salesman.getName()).isPresent()) {
            salesmanList.add(salesman);
        }
    }

    public Salesman getWorstSalesmanEver(){
        ordenateSalesman();
        return salesmanList.get(0);
    }

    public int generateNumberOfSalesman(){
        return salesmanList.size();
    }

    public Optional<Salesman> findSalesmanByName(String name){
        return salesmanList.stream().filter(salesman -> salesman.getName().equals(name)).findFirst();
    }

    public void ordenateSalesman(){
        Collections.sort(salesmanList, Comparator.comparing(Salesman::getAmountSold));
    }
}
