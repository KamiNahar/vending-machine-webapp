/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
  
    addMoney();
    
    
    
});

var money = 0; 

function addMoney() {

//add dollar by clicking on the dollar button
$("#addDollar").click(function() {
  //set money value to 1.00 
  money += 1.00; 
  //in your total money display, display value of money and round to 2 decimal points. 
$("#textBoxForMoney").val(money.toFixed(2));
});

//add quarter
$("#addQuarter").click(function() {
  money += .25;
$("#textBoxForMoney").val(money.toFixed(2));
});

$("#addDime").click(function() {
  money += .10;
$("#textBoxForMoney").val(money.toFixed(2));
});

$("#addNickel").click(function() {
  money += .05;
$("#textBoxForMoney").val(money.toFixed(2));
});

return money; 
}