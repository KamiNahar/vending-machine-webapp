/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineSpringMVCDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;

public class VendingMachineSpringMVCServiceLayerFileImpl implements VendingMachineSpringMVCServiceLayer {

    VendingMachineSpringMVCDao dao;

//takes the dao bean and injects it here so that it can use your service layer
    @Inject
    public VendingMachineSpringMVCServiceLayerFileImpl(VendingMachineSpringMVCDao dao) {
        this.dao = dao;
    }

//created a variable that holds the total money. 
    BigDecimal totalMoney = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    BigDecimal costOfItem = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
//holds the user change value but in a BigDecimal Variable, allows me to use this variable in the controller 
    BigDecimal userMoney = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
//create variable to hold messages/exceptions.
    String messageDisplay = "";

//create variable to hold user's return change, not returning the variable in the controller 
//only used for calculations in the service layer
    Change userChange = new Change(totalMoney);

//variable created to hold the item Id
    int itemPicked = 0;

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(int ItemId) {
        return dao.getItem(ItemId);
    }

    
    
    @Override
    public BigDecimal getTotalMoneyIn() {
        return totalMoney;
    }

    //method to calculate total money user puts in 
    public void totalMoney(String money) {
        //this variable holds the money the user actually enters 
        BigDecimal moneyUserInserted = new BigDecimal(money).setScale(2, RoundingMode.HALF_UP);
        //and then here takes the user money and adds it to total value of the money which is stored in totalMoney
        //so it changes the value for the variable totalMoney to get the final  total amount the user puts in to vend item.
        totalMoney = totalMoney.add(moneyUserInserted);
    }

    @Override
    public void itemPicked(String itemId) {
        itemPicked = Integer.parseInt(itemId);

        //dao.getItem(itemId);
    }

    @Override
    public void makePurchase() {
        //made a global variable called itemPicked
        //if itemPicked is not equal  to 0
        if (itemPicked != 0) {
            /* - then get the item by id
            - create a variable item and set it to equal method getItem from dao
            (which gets the item by itemId num) and pass in the itemPicked variable. 
            - so the itemId is now equal to itemPicked value*/
            Item item = dao.getItem(itemPicked);
            /* - create a BigDecimal to hold the value of the itemPrice */
            BigDecimal itemPrice = item.getItemPrice();
            /* - if the item quantity is less than or equal to zero, display message sold out */
            if (item.getQuantity() <= 0) {
                messageDisplay = "Sold out!!!";
                /* - compare the value of the user money(totalMoney) and item price. 
              if the value is less than zero it means total money is less than item price.
            - if totalMoney value is less than itemPrice, then you get a message
              that displays a request to enter more money */
            } else if (totalMoney.compareTo(itemPrice) < 0) {
                /* - depositMoreMoney variable holds the difference the user owes
              item price - usermoney = difference */
                BigDecimal depositMoreMoney = itemPrice.subtract(totalMoney);
                messageDisplay = "Please insert: $" + depositMoreMoney;
            } else {
                /* - else if user enters sufficient funds, subtract itemprice from total money
              and return change back to user. variable newChange holds users change */
                BigDecimal newChange = totalMoney.subtract(itemPrice);
                /* - create a new change object using the constructor for change, 
              pass in the variable newchange. you create a new object to pass in the bigdecimal. you can't set the bigdecimal to equal the object. */
               Change change = new Change(newChange);
                /* - create a new variable to hold the users change*/
               userChange = change;
                /* - sets user money back to zero once user gets their change return*/
                totalMoney = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
                /* - once item is vended, subtract 1 item from the inventory and display 
              message "thank you" */
                int newQuantity = item.getQuantity() - 1;
                item.setQuantity(newQuantity);
                dao.updateItem(item);
                messageDisplay = "Thank You!!!";
            }
        }
    }


    //userChange is what holds the customer money
    //totalMoney gets set back to zero after purchase is made. 
    //totalMoney is what the user initially enters,
   
    
       @Override
    public Change returnedChange() {
       
        Item item = dao.getItem(itemPicked);
        if(item == null){
            return new Change(totalMoney);
        }
        BigDecimal itemPrice = item.getItemPrice();
        BigDecimal newChange = totalMoney.subtract(itemPrice);
      Change change = new Change(newChange);
      userChange = change;
      return userChange;

    }
    
    
    
    
    @Override
    public Change returnChange() {
      Change change = new Change(totalMoney);
      change.calculateChange(new BigDecimal("0.00"), totalMoney);
      return change; 

    }

    //all getter and setter methods here
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Change getUserChange() {
        return userChange;
    }

    public void setUserChange(Change userChange) {
        this.userChange = userChange;
    }

    public int getItemPicked() {
        return itemPicked;
    }

    public void setItemPicked(int itemPicked) {
        this.itemPicked = itemPicked;
    }

    public String getMessageDisplay() {
        return messageDisplay;
    }

    public void setMessageDisplay(String messageDisplay) {
        this.messageDisplay = messageDisplay;
    }




}
