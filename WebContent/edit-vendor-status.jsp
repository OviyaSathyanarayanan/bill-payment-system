<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
     	<h1>Edit Vendor Status</h1>
     	<h2>Vendor Details Saved Successfully</h2>
     	<table id="view-tab">
           		<tr>
                   <td><label for="email">Email</label></td>
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
                	<td><label for="validityDate">Certificate validity Date</label></td>
                    <td>${vendor.validityDate}</td>
                </tr>
                <tr>
                	<td><label for="payment">Payment Gateway </label></td>
                    <td>${vendor.paymentType}</td>
                </tr>      
                <tr>
                	<td><label for="password">Password</label></td>
                    <td>${vendor.password}</td>
                </tr>
         </table>
     </div>
</body>
</html>