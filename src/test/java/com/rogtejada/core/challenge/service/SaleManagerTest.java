package com.rogtejada.core.challenge.service;

import com.rogtejada.core.challenge.model.Sale;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleManagerTest {

    private SaleManager saleManager = SaleManager.getInstance();
    private static final Double TOTAL_PRICE = 3000D;

    @Before
    public void init(){
        Sale saleTestOne = new Sale();
        saleTestOne.setTotalPrice(150D);
        saleTestOne.setId(10);
        saleManager.addSale(saleTestOne);
        Sale saleTestTwo = new Sale();
        saleTestTwo.setTotalPrice(3000D);
        saleTestTwo.setId(15);
        saleManager.addSale(saleTestTwo);
    }

    @Test
    public void getInstance() {
        assertEquals(true, saleManager instanceof SaleManager);
    }

    @Test
    public void ordenateSales() {
        saleManager.ordenateSales();
        assertEquals(TOTAL_PRICE, saleManager.getSaleList().get(0).getTotalPrice());
    }

    @Test
    public void findSaleById() {
        assertEquals(10, saleManager.findSaleById(10).get().getId());
    }
}