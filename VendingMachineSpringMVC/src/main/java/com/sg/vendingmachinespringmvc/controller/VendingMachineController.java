/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.service.VendingMachineSpringMVCServiceLayer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author kaminahar
 */

@Controller
public class VendingMachineController {
    private VendingMachineSpringMVCServiceLayer service;
   
    //takes the service layer bean and injects in controller
   @Inject
       public VendingMachineController(VendingMachineSpringMVCServiceLayer service) {
           this.service = service; 
    }
    
    //method brings you back to index.jsp
    //the plain slash "/" is what takes you back to the default page which is index.jsp
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String homePage(HttpServletRequest request, Model model) {
        
        //gets each item from the mock data in dao and through the service layer
        List<Item> eachItem = service.getAllItems();
        //adds all items to the model, and then passes it to index.jsp so that it can be  viewed on the home page.
        model.addAttribute("eachItem", eachItem);
        
        //get totalMoneyIn variable value from the service layer
        BigDecimal getTotalMoneyIn = service.getTotalMoneyIn();
        //add totalMoneyIn variable value into model, sends to index.jsp to view on web page.
        model.addAttribute("totalMoneyInValue",getTotalMoneyIn);
        
        //get itemPicked value from the service layer
        int getItemPicked = service.getItemPicked();
        //add itemPicked value into model and send to index.jsp
        model.addAttribute("itemChoice",getItemPicked);
        
        /*takes the messages from the makePurchase method, stores the messages inside
        the variable messageDisplay, and then from the service we take the getMessageDisplay method and 
        add it to the model and send to index.jsp*/
        
        
        model.addAttribute("messageDisplay",service.getMessageDisplay());
              Change changer =service.returnedChange();

        model.addAttribute("calculateChange",changer);
        
        return "index";
    }
     
    @RequestMapping(value ="/selectMoneyButtons", method = RequestMethod.GET)
        public String selectMoneyButtons (HttpServletRequest request, Model model){
        //takes the moneyValue parameter from index.jsp and puts in this string variable
        String money = request.getParameter("moneyValue");
        //takes the totalMoney method from the service layer and passes in the moneyValue parameter.
        service.totalMoney(money);
        // "/" takes you back to the index.jsp, in your RequestMapping value needs to be the same, value="/"
        return "redirect:/";  
    }
    
    @RequestMapping(value ="/selectItem", method = RequestMethod.GET)
        public String selectItem (HttpServletRequest request, Model model) {
        //takes the itemId parameter from index.jsp and puts in string variable
        String  itemId  = request.getParameter("itemId");
        //takes itemPicked method from service layer (which gets the item by itemId number passed in from Dao) 
        //and passes in the "itemId" parameter from index.jsp here
        service.itemPicked(itemId);
        //takes you back to index/view page.
        return "redirect:/";  
    }
        
    @RequestMapping(value="/makePurchase", method=RequestMethod.GET)
        public String makePurchase(HttpServletRequest request, Model model) {
        //takes the makePurchase method from service 
        service.makePurchase();
        //sends you back to index.jsp
        return "redirect:/";
    }
     
    @RequestMapping(value="/changeButton", method=RequestMethod.GET)
        public String returnChange (HttpServletRequest request, Model model) {
        //takes the returnChange method from service 
        service.returnedChange();
        //sends you back to index.jsp
        return "redirect:/";
    }    
  

        
}

    
    


