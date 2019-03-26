/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author kaminahar
 */
public interface VendingMachineSpringMVCDao {
   
    //search for all items
    List<Item> getAllItems() ;
    //get item by Id
    Item getItem (int itemId) ;
    //remove an item
    Item removeItem(Item item) ;
    //add an item
    public void addItem(int itemId, Item item1) ;
    // update Item
    void updateItem (Item item); 
    
    
    
}
