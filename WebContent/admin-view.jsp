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
        <a href="LogOutController" id="login">Logout</a>
    </header>
    <div class = "content">
        <h1>Action</h1>
        <table id="view-tab">
        	<tr>
               	<td><label for ="vendorName">Vendor Name</label></td>
               	<td><label for ="regNum">Register Number</label></td>
               	<td><label for ="contact">Contact</label></td>
               	<td><label for ="website">Website</label></td>
               	<td><label for ="validity">Validity Date</label></td>
               	<td><label for ="payment">Payment Type</label></td>
                <td><label for ="approval">Approval</label></td>
        	</tr>
        	<tr>
        		<td colspan="7"><p class="err">${errMsg}</p></td>
        	</tr>
            <c:forEach items="${vendorList}" var="vendor">
            <tr>
                <td>${vendor.name}</td>
                <td>${vendor.registerNumber}</td>
                <td>${vendor.contact}</td>
                <td>${vendor.website}</td> 
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
									value="${vendor.validityDate}" /></td>
                <td>${vendor.paymentType}</td>
	      		<td><a href ="UserController?id=${vendor.vendorId}&&status=Approve">Approve</a></td>
	      		<td><a href ="UserController?id=${vendor.vendorId}&&status=Deny">Deny</a></td>
			</tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
