/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;


import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kaminahar
 */
public class VendingMachineSpringMVCDaoInMemImpl implements VendingMachineSpringMVCDao {
private Map<Integer, Item> items = new HashMap<>(); 

//add mock data
public VendingMachineSpringMVCDaoInMemImpl() {
    
    Item itemA = new Item(1, "Snickers", new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP),10);
    Item itemB = new Item(2, "M&M's", new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP),10);
    Item itemC = new Item(3, "Almond Joy", new BigDecimal(2.00).setScale(2, RoundingMode.HALF_UP),10);
    Item itemD = new Item(4, "Milky Way", new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP),10);
    Item itemE = new Item(5, "Payday", new BigDecimal(1.75).setScale(2, RoundingMode.HALF_UP),10);
    Item itemF = new Item(6, "Pringles", new BigDecimal(2.00).setScale(2, RoundingMode.HALF_UP),10);
    Item itemG = new Item(7, "Cheezits", new BigDecimal(2.50).setScale(2, RoundingMode.HALF_UP),10);
    Item itemH = new Item(8, "Doritos", new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP),10);
    Item itemI = new Item(9, "Reese's Pieces", new BigDecimal(1.75).setScale(2, RoundingMode.HALF_UP),1);
    
    items.put(1, itemA);
    items.put(2, itemB);
    items.put(3, itemC);
    items.put(4, itemD);
    items.put(5, itemE);
    items.put(6, itemF);
    items.put(7, itemG);
    items.put(8, itemH);
    items.put(9, itemI);
    
}

   @Override
    public Item getItem(int itemId) {
        return items.get(itemId);
    }
    
    @Override
    public List<Item> getAllItems() {
         return new ArrayList<Item>(items.values()); 
    }

    @Override
    public Item removeItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addItem(int itemId, Item item1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void  updateItem(Item item) {
    items.put(item.getItemId(), item);
    }
    
}
