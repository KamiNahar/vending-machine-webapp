/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author kaminahar
 */
public class Change {
 
    private int quarter = 0;
    private int dime = 0;
    private int nickel = 0;
    private int penny =0;
    
 public Change (BigDecimal change)  {
//     int totalMoneyInt = totalMoney.intValue();
//        int amount = totalMoneyInt; 
     
        int amount = change.multiply(new BigDecimal("100")).intValue();
        if (amount > 25) {
           quarter = amount/25;
           amount= amount - (quarter * 25);
        }
          if (amount > 10) {
           dime = amount/10;
           amount= amount - (dime * 10);
        } 
          if (amount > 5) {
           nickel = amount/5;
           amount= amount - (nickel * 25);
        } 
           penny = amount;
                    
    }

    public int getQuarter() {
        return quarter;
    }

    public int getDime() {
        return dime;
    }

    public int getNickel() {
        return nickel;
    }

    public int getPenny() {
        return penny;
    }
    
    

 
    public BigDecimal calculateChange(BigDecimal cost, BigDecimal userMoney){
    BigDecimal change = new BigDecimal ("0.00");
   //BigDecimal cost = new BigDecimal (costOfItem);
   // BigDecimal item = item.getItemPrice();
    
    
   // change = userMoney.subtract(cost);
    int amount = change.intValue();
            //int amount = 0; 
        if (amount > 25) {
           quarter = amount/25;
           amount= amount - (quarter * 25);
        }
          if (amount > 10) {
           dime = amount/10;
           amount= amount - (dime * 10);
        } 
          if (amount > 5) {
           nickel = amount/5;
           amount= amount - (nickel * 25);
        } 
           penny = amount;
    return change; 
    }



    
    

}
