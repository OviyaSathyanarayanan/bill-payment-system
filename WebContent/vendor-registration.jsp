<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Vendor Registration</title>
<script type="text/javascript" src="js/script.js"></script>
<link href="style/fpstyle.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
     <header>
          <img src="images/logo.png" id="logo"> 
          <a href="login.jsp" id="login">Login</a>
     </header>
     <div class = "container">
     	<p class="title" align="center">Vendor Registration</p>
     	<c:if test="${RegisterStatus==true}">
     		<p class="sign" align="center">Vendor Registered Successfully</p>
     	</c:if>
     	<p class="err">${errMsg}</p>
        <form name="vendorForm" action="UserController" method ="post" onsubmit = "return validateVendor()">
          	<table id = "user-tab">
              	<tr>
					<td><label for ="name">Name of Vendor</label></td>
					<td><label for ="registerNum">Company Register Number</label></td>
					<td><label for ="vendorType">Vendor Type</label></td>
				</tr>
				<tr>
                    <td><input type="text" name="name"></td>
                    <td><input type="text" id="registerNum" name="registerNum"></td>
                    <td><select id="vendorType" name="vendorType">
		              		<option value="-" disabled selected>--Type--</option>
		                	<option value="1">Electricity</option>
		                	<option value="2">Telephone</option>
			                <option value="3">DTH</option>
			                <option value="4">Insurance</option>
			                <option value="5">Tax</option>
			                <option value="6">Credit Card</option>
			                <option value="7">Loan Account</option>
		              	</select>
                  	</td>
              	</tr>
              	<tr>
              		<td><span id="errName" class="error"></span></td>
              		<td><span id="errRegisterNum" class="error"></span></td>
              		<td><span id="errVendorType" class="error"></span></td>
              	</tr>
              	<tr>
              	    <td><label for ="address">Address</label></td>
              	    <td><label for ="country">Country</label></td>
              	    <td><label for ="state">State</label></td>
              	</tr>
              	<tr>
                  	<td><input type="text" id="address" name="address"></td>
                  	<td>
                  		<select id ="country" name="country">
                  			<option value="-" disabled selected>--Country--</option>
		                    <option value="India">India</option>
                  		</select>
                  	</td>
                   	<td><select id="state" name="state" >
		                    <option value="-" disabled selected>--State--</option>
		                    <option value="TamilNadu">TamilNadu</option>
		                    <option value="Karnataka">Karnataka</option>
		                    <option value="Kerala">Kerala</option>
		                    <option value="Andhra Pradesh">Andhra Pradesh</option>
		                    <option value="Maharashtra">Maharashtra</option>
		                    <option value="Delhi">Delhi</option>
                   	    </select>
                    </td>
              	</tr>
              	<tr>
                  	<td colspan="2"><span id="errAddress" class="error"></span></td>
                  	<td><span id="errState" class="error"></span></td>
              	</tr>
              	<tr>
              	  	<td><label for ="email">Email Address</label></td>
              	   	<td><label for ="contact">Contact Number</label></td>
              	   	<td><label for ="website">Web site</label></td>
              	</tr>
              	<tr>
              	   	<td><input type="email" id="email" name="email"></td>
                   	<td><input type="text"  id="contact" name="contact"></td>
                   	<td><input type="text"  id="website" name="website"></td>
               	</tr>
               	<tr>
               		<td><span id="errEmail" class="error"></span></td>
                   	<td><span id="errContact" class="error"></span></td>
                   	<td><span id="errWebsite" class="error"></span></td>
               	</tr>
              	<tr>
              	   	<td><label for ="issuedDate">Certificate Issued Date</label></td>
              	   	<td><label for ="validityDate">Certificate Validity Date</label></td>
              	   	<td><label for ="year">Year of Establishment</label></td>
              	</tr>
              	<tr>
                   	<td><input type="date" id="issuedDate" name="issuedDate"></td>
                   	<td><input type="date" id="validityDate" name="validityDate"></td>
                   	<td><input type="text" id="year" name="year" ></td>
              	</tr>
              	<tr>
              	   	<td><span id="errIssuedDate" class="error"></span></td>
              	   	<td><span id="errValidityDate" class="error"></span>
                    <td><span id="errYear" class="error"></span></td>
              	</tr>
              	<tr>
              	   	<td><label for ="payment">Payment Gateway</label></td>
              	   	<td><label for ="userName">Username</label></td>
              	   	<td><label for ="password">Password</label></td>
              	</tr>
              	<tr>
                   	<td>
                   		<select id="payment" name="payment" >
		                    <option value="-" disabled selected>--Payment Mode--</option>
			                <option value="Credit Card">Credit Card</option>
			                <option value="Debit Card">Debit Card</option>
				            <option value="Google Pay">Google Pay</option>
				            <option value="Paytm">Paytm</option>
				            <option value="e-Wallet">e-Wallet</option>
				            <option value="NetBanking">NetBanking</option>
                   	    </select>
                   	</td>
                   	<td><input type="text" id="userName" name="userName" ></td>
                   	<td><input type="password" id="password" name="password" ></td>
              	</tr>
              	<tr>
                  	<td><span id="errPayment" class="error"></span></td>
					<td><span id ="errUserName" class="error"></span></td>
                    <td><span id ="errPassword" class="error"></span></td>
              	</tr>
              	<tr>
                   	<td><input class = "submit" type="submit" value="Register" name="action"> </td>
                   	<td><input class = "submit" type="reset" value="Reset"> </td>
              	</tr>
           </table>
        </form>
     </div>
</body>
</html>