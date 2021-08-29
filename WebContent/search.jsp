<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer page</title>
<script type="text/javascript" src="js/script.js"></script>
<link href="style/fpstyle.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
	 <header>
           <img id="logo" src="images/logo.png"> 
           <a onclick=logout() id="login">Logout</a>
           <a href="help.jsp" id = "login">Help</a>
     </header>
     <div class="content">
          <form action="SearchController" method="get">
              <h1>Customer Page</h1>
              <div class=search-box>
				   <input type="search" id="myInput" placeholder="Search for vendors or category.." name="search">
				   <input type="submit" value="search" class="submit" name="action">
				   <div class ="scrolldetail">
	                   <table id="view-tab">
	                   		<tr>
								<td colspan="3"><h2 class="err">${errMsg}</h2></td>
							</tr>
	                   		<tr id ="head">
								<td>Name</td><td>Website</td><td>Email</td><td>Contact Number</td>
							</tr>
						 	<c:forEach items="${vendorList}" var="vendor">
								<tr>
							    	<td>${vendor.name}</td>
							    	<td>${vendor.website}</td>
							    	<td>${vendor.email}</td>
							    	<td>${vendor.contact}</td>
							    	<td><a href="BillController?vendorId=${vendor.vendorId}&&action=paybill">Pay bill</a></td>
								</tr>	 
							</c:forEach>
					   </table> 
				   </div>                 
              </div>
              <input type="hidden" name="userId" value="${customer.userId}">
          </form>
     </div>
</body>
</html>
