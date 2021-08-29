<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Card Details</title>
	<script type="text/javascript" src="js/script.js"></script>
	<link href="style/fpstyle.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
	 <header>
           <img id="logo" src="images/logo.png"> 
           <a href="help.jsp" id = "login">Help</a>
     </header>
     <div class = "payment">
        <h2 class="err">${errMsg}</h2>
     	<p class="sign" align="center">Credit Card/Debit Card</p>
    	<form name="cardForm" action="BillController" onsubmit="return validateCard()" class="inputForm" method="get">
			<table id = "user-tab">
				<tr>
					<td><label for ="cardNum">CardNumber</label></td>
            		<td><input type="text" name="cardNum" id="cardNum">
                	<span id="errCard" class="error"></span></td>
				</tr>
				<tr>
		    		<td><label for ="number">CVV</label></td>
            		<td>
            			<input type="text"  id="number" name="number">
                		<span id="errNumber" class="error"></span>
            		</td>
				</tr>
				<tr>
					<td><label for ="validityDate">Validity Date</label></td>
            		<td>
            			<input type="date" id="validityDate" name="validityDate">
                		<span id="errValidityDate" class="error"></span>
           			</td>
           		</tr>
				<tr>
            		<td><input class = "submit" type="submit" value="Pay" name ="action"> </td>
            		<td><input class = "submit" type="reset" value="Cancel" name ="action"> </td>
        		</tr>
			</table>
		</form>
		<input type="hidden" name="userId" value="${customer.userId}">
       	<input type="hidden" name="vendorId" value="${vendor.vendorId}">
	 </div>
</body>
</html>