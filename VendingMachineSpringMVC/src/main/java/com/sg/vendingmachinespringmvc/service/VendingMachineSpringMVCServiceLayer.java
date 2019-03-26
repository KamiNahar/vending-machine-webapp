/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author kaminahar
 */
public interface VendingMachineSpringMVCServiceLayer {
    List<Item> getAllItems(); 
    Item getItem(int ItemId);
    public void totalMoney(String money);
    BigDecimal getTotalMoneyIn(); 
    public void  makePurchase();
    public void itemPicked(String itemId);
    int getItemPicked();
    void setItemPicked(int itemPicked);
    String getMessageDisplay();
    void setMessageDisplay(String messageDisplay);
    Change returnChange(); 
    Change getUserChange();
    void setUserChange(Change userChange);
    
    
    
    Change returnedChange();
}
