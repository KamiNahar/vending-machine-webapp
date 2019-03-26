<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">
    </head>
    <body>
        <div id="pageTitle" class="container">
            <h1 class = "text-center" >Vending Machine</h1>
            <hr/>
        </div>
                
    <div class="container-fluid">
    <!-- put 9 and 3 in one row -->
    <div class="row">



      <!--only the item buttons are in this div -->
    <div class="col-md-9">
        ​
        <!-- dynamic item button goes in here when we call function loaditems in home.js file-->
        <div id="allItems" class="row">
            
            <c:forEach var="currentItem" items = "${eachItem}">
        	<div class="col-md-4 itemButton">
                    <a href="${pageContext.request.contextPath}/selectItem?itemId=${currentItem.itemId}" class="btn-block eachItemButton" value="${currentItem.itemPrice}">
				
					<div class ="idNumber">
					<h6> ${currentItem.itemId} </h6>
					</div>
					<div class= "item">
					<h6> ${currentItem.itemName} </h6>
				        </div>
                                        <div class= "price">
					<h6> $${currentItem.itemPrice} </h6>
				        </div>
				        <div class ="quantity">
					<h6> Quantity Left: ${currentItem.quantity} </h6>
				        </div>
                                        
                    </a>
			</div>
			
            </c:forEach>
​
        </div>
    </div>
      ​

      <!--Inside this div is everything from the last column in the wire frame -->

      <div class="col-md-3">

        <div id="allTheOtherStuffBesidesItemButtons" class="row">
          ​
       <!-- displays totalMoney text box here and all your add money buttons -->
          ​
          <div class="row text-center">
            <div class="col-md-12">
              <h4 id="totalMoneyIn">
                Total $ In
              </h4>
            </div>
          </div>
          ​
          ​
          <div class="row text-center">
            <div class="col-md-12">
              <input id="textBoxForMoney" type="BigDecimal" value="${totalMoneyInValue}">
            </div>
          </div>
          ​
          ​
          <div class="row text-center">
            <div class="col-md-6">
              <a href="${pageContext.request.contextPath}/selectMoneyButtons?moneyValue=1.00" id = addDollar class ="btn moneyButtons">Add Dollar</a>
            </div>
            ​
            <div class="col-md-6">
               <a href="${pageContext.request.contextPath}/selectMoneyButtons?moneyValue=0.25" id = addQuarter class ="btn moneyButtons">Add Quarter</a>
            </div>
          </div>
          ​
          <div class="row text-center">
            <div class="col-md-6">
               <a href="${pageContext.request.contextPath}/selectMoneyButtons?moneyValue=0.10" id = addDime class ="btn moneyButtons">Add Dime</a>
            </div>
            ​
            <div class="col-md-6 ">
               <a href="${pageContext.request.contextPath}/selectMoneyButtons?moneyValue=0.05" id = addNickel class ="btn moneyButtons">Add Nickel</a>
            </div>
          </div>

          ​
          ​
          ​
          ​<!-- Displays Message box, Item selection, and Make purchase button -->
          ​

            ​
            <div class="row text-center">
              <div class="col-md-12">
                <h4 id= "Messages">Messages</h4>
              </div>
            </div>
            ​
            <div class="row text-center">
              <div class="col-md-12">
                <input id="messageTextBox" type="text" value="${messageDisplay}"></input>
              </div>
            </div>
            ​
            ​
            ​
            <div class="row text-center">
              <div class="col-md-12">
                <h4>
                  Item:
                </h4>
                ​
              </div>
              <div class="col-md-12 text-center">
                <input id="itemTextBox" type="text" value="${itemChoice}"></input>
              </div>
            </div>
            ​
            ​
            ​
            <div class="row text-center">
              <div class="col-md-12">
                <a href="makePurchase" id = makePurchaseButton class ="btn ">Make Purchase</a>
<!--            <a href="$ {pageContext.request.contextPath}/makePurchase" id = makePurchaseButton class ="btn ">Make Purchase</a>-->
              </div>
            </div>
            ​
          ​
          ​
          <!-- displays  change here -->
          ​
          <div class="row text-center">
            <div class="col-md-12">
              <h4 id ="change">Change</h4>
            </div>
          </div>
          ​
          <div class="row text-center">
            <div class="col-md-12">
                <!--value = $  {changeReturn} -->
              <input id="textBoxChange" type="text" id="changeReturned" value= " quarter: ${calculateChange.quarter} dime: ${calculateChange.dime} nickel: ${calculateChange.nickel} penny: ${calculateChange.penny}" />
            </div>
          </div>
          ​
          <div class="row text-center">
            <div  class="col-md-12">
                <a href="${pageContext.request.contextPath}/changeButton" id = changeButton class ="btn">
                    Change Return
                </a>
            </div>
          </div>
          ​
        </div>  ​
      </div> 
      ​
      ​
    </div>        
                
          
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

