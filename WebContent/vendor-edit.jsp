<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Edit</title>
<link href="style/fpstyle.css" rel="stylesheet">
<script type="text/javascript" src="js/script.js"></script>
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
	 <header>
           <img id="logo" src="images/logo.png"> 
           <a onclick=logout() id="login">Logout</a>
     </header>
     <div class="content">
     	<h1>Vendor Edit</h1>
     	<h2 class="err">${errMsg}</h2>
        <form name="vendorEditForm" action="EditController" method="post" onsubmit="return validateEdit()">
			<table id="view-tab">
           		<tr>
                   <td><label for="email">Email</label></td>
                   <td>
                   	   <input type="email" id="email" name="email" value="${vendor.email}">
                       <span id="errEmail" class="error"></span>
                   </td>
                </tr>
                <tr>
                	<td><label for="contact">Contact Number</label></td> 
                    <td>
                    	<input type="text" id="contact" name="contact" value="${vendor.contact}">
                    	<span id="errContact" class="error"></span>
                    </td>
                </tr>
                <tr>
                	<td><label for="website">Web site</label></td>
                    <td>
                    	<input type="text" id="website" name="website" value="${vendor.website}">
                    	<span id="errWebsite" class="error"></span>
                    </td>
                </tr>
                <tr>
                	<td><label for="validityDate">Certificate validity Date</label></td>
                    <td>
                    	<input type="date" id="validityDate" name="validityDate" value="${vendor.validityDate}" />
                    	<span id="errValidityDate" class="error"></span>
                    </td>
                </tr>
                <tr>
                	<td><label for="payment">Payment Gateway </label></td>
                    <td>
                    	<select id="payment" name="payment" >
		                    <option value="-" disabled selected>${vendor.paymentType}</option>
			                <option value="Credit Card">Credit Card</option>
			                <option value="Debit Card">Debit Card</option>
				            <option value="Google Pay">Google Pay</option>
				            <option value="Paytm">Paytm</option>
				            <option value="e-Wallet">e-Wallet</option>
				            <option value="NetBanking">NetBanking</option>
                   	    </select>
                    	<span id="errPayment" class="error"></span>
                    </td>
                </tr>      
                <tr>
                	<td><label for="password">Password</label></td>
                    <td>
                    	<input type="password" id="password" name="password" value="${vendor.password}">
                    	<span id="errPassword" class="error"></span>
                    </td>
                </tr>
                <tr>
                    <td><input class = "submit" type="submit" value="Save" name="action"> </td>
                    <td><input class = "submit" type="submit" value="Cancel" name="action"> </td>
                </tr>
           </table>
           <input type="hidden" name="id" value="${vendor.vendorId}">
        </form>
     </div>
</body>
</html>


