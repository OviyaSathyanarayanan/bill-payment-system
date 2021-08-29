<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>admin_view</title>
	<link href="style/fpstyle.css" rel="stylesheet">
	<script type="text/javascript" src="js/script.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
	 <header>
           <img id="logo" src="images/logo.png"> 
           <a onclick=logout() id="login">Logout</a>
     </header>
     <div class="vendor-info">
     	   <p class="err">${errMsg}</p>
           <p class="title" align="center">Vendor Details</p>
           <form action ="UserController" name="vendorForm" method="get">
           		<table id="user-tab">
                	<tr>
                		<td><label>Name of Vendor</label></td>
                    	<td>${vendor.name}</td>
                	</tr>
                	<tr>
                		<td><label>Registration Number</label></td>
                		<td>${vendor.registerNumber}</td>
                	</tr>     
                	<tr>
                		<td><label>Vendor Type</label></td>
                     	<td>${vendor.typeName}</td>
                    </tr>
                    <tr>
                    	<td><label for="address">Address</label></td>
                    	<td>${vendor.address}</td>
                    </tr>
                    <tr>
                    	<td><label for ="country">Country</label></td>
                   		<td>${vendor.country}</td>
                    </tr>
                    <tr>
                    	<td><label for ="state">State</label></td>
                   		<td>${vendor.state}</td>
                    </tr>
                    <tr>
                    	<td><label for="Email">Email</label></td>
                    	<td>${vendor.email}</td>
                    </tr>
                    <tr>
                    	<td><label for="contact">Contact Number</label></td>
                    	<td>${vendor.contact}</td>
                    </tr>
                    <tr>
                    	<td><label for="website">Web site</label></td>
                     	<td>${vendor.website}</td>
                    </tr>
                    <tr>
                    	<td><label for="certificateDate">Certificate Issued Date</label></td>
                        <td> ${vendor.certificateDate}</td>
                    </tr>
                    <tr>
                    	<td><label for="validityDate">Validity Date</label></td>
                        <td> ${vendor.validityDate}</td>
                    </tr>
                    <tr>
                    	<td><label for ="year">Year of Establishment</label></td>
                   		<td>${vendor.year}</td>
                   	</tr>
                    <tr>
                    	<td><label for="payment">Payment Gateway</label></td>
                        <td>${vendor.paymentType}</td>
                    </tr>
                    <tr><td><label for ="userName">Username</label></td><td>${vendor.userName}</td></tr>
                    <tr><td><label for ="password">Password</label></td><td>${vendor.password}</td></tr>    
                    <tr>
	      				<td id="edit"><a href = "UserController?userName=${vendor.userName}&&action=Edit">Edit</a></td>
	      			</tr>
                </table>
           </form>
     </div>
</body>
</html>


