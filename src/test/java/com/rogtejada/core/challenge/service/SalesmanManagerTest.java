package com.rogtejada.core.challenge.service;

import com.rogtejada.core.challenge.model.Salesman;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesmanManagerTest {

    private SalesmanManager salesmanManager = SalesmanManager.getInstance();

    @Before
    public void init(){
        Salesman salesman = new Salesman();
        salesman.setName("Rodrigo");
        salesman.setAmountSold(1203D);
        salesmanManager.addSalesman(salesman);
        Salesman salesmanOne = new Salesman();
        salesmanOne.setName("Jonas");
        salesmanOne.setAmountSold(9520D);
        salesmanManager.addSalesman(salesmanOne);
        Salesman salesmanTwo = new Salesman();
        salesmanTwo.setName("Marcos");
        salesmanTwo.setAmountSold(150D);
        salesmanManager.addSalesman(salesmanTwo);
    }

    @Test
    public void getInstance() {
        assertEquals(true, salesmanManager instanceof  SalesmanManager);
    }

    @Test
    public void generateNumberOfSalesman() {
        assertEquals(3, salesmanManager.generateNumberOfSalesman());
    }

    @Test
    public void findSalesmanByName() {
        assertEquals("Rodrigo", salesmanManager.findSalesmanByName("Rodrigo").get().getName());
    }

    @Test
    public void ordenateSalesman() {
        salesmanManager.ordenateSalesman();
        assertEquals("Marcos", salesmanManager.getSalesmanList().get(0).getName());
    }
}