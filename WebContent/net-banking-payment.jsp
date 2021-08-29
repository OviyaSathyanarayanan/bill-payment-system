<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Payment</title>
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
     	<p class="sign" align="center">Internet Banking</p>
    	<form name="bankForm" action="BillController" onsubmit="return validateBank()" class="inputForm" method="get">
			<table id = "user-tab">
				<tr>
					<td><label for ="accountNumber">Account Number</label></td>
            		<td>
            			<input type="text"  id="accountNumber" name="accountNumber">
                		<span id="errNumber" class="error"></span>
                	</td>
				</tr>
				<tr>
					<td><label for ="userName">UserId</label></td>
           			<td>
           				<input type="text" id="userName" name="userName">
                		<span id="errUser" class="error"></span>
                	</td>
				</tr>
				<tr>
					<td><label for ="password">password</label></td>
            		<td>
            			<input type="password" id="password" name="password">
                		<span id="errPassword" class="error"></span>
                	</td>
				</tr>
				<tr>
            		<td><input class = "submit" type="submit" value="netPay" name="action"> </td>
            		<td><input class = "submit" type="reset" value="Cancel" name ="action"> </td>
        		</tr>
			</table>
		</form>
		<input type="hidden" name="userId" value="${customer.userId}">
        <input type="hidden" name="vendorId" value="${vendor.vendorId}">
	</div>
</body>
</html>