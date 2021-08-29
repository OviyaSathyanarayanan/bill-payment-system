<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="style/fpstyle.css">
  <script type="text/javascript" src="js/script.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta charset="ISO-8859-1">
  <title>Bill Payment</title>
</head>
<body>
    <header>
        <img id="logo" src="images/logo.png">
        <a href="help.jsp" id = "login">Help</a>
    </header>
    <div class="payment">
        <h2 class="err">${errMsg}</h2>
        <p class="sign" align="center">To make the payment, please fill in the details:</p>
        <form name="paymentForm" action="BillController" method="get" onsubmit="return validatePayment()">
            <table>
                <tr>
                   <td><label for ="amount">Amount</label></td>
                   <td><input type="text" name="amount" id="amount">
                   	   <span id="errAmount" class="error"></span></td>
                </tr>
                <tr>
                	<td><label for ="paymentType">Payment Type</label></td>
  					<td><select id="paymentType" name="paymentType">
			              	    <option value="" disabled selected>--Type--</option>
			                	<option value="1">Credit Card</option>
			                	<option value="1">Debit Card</option>
				                <option value="2">Google Pay</option>
				                <option value="2">Paytm</option>
				                <option value="2">e-Wallet</option>
				                <option value="3">NetBanking</option>
		              	</select>
                   	  	<span id="errPaymentMode" class="error"></span>
                  	</td>
                </tr>
                <tr>
                   <td><label for ="billDate">Bill date</label></td>
                   <td><input type="date" name="billDate" id="billDate">
                   	   <span id="errBillDate" class="error"></span></td>
                </tr>
                <tr>
            		<td><input class = "submit" type="submit" value="Proceed" name="action"> </td>
        		</tr>
            </table>
        </form>
        <input type="hidden" name="userId" value="${customer.userId}">
        <input type="hidden" name="vendorId" value="${vendor.vendorId}">
    </div>
</body>
</html>
