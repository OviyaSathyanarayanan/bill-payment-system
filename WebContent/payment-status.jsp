<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="style/fpstyle.css">
  <script type="text/javascript" src="js/script.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta charset="ISO-8859-1">
  <title>Bill Payment</title>
</head>
<body>
	<%
	 	response.setHeader("Cache Control","no-cache,no-store,must-revalidate");
	 
	 	if(session.getAttribute("userId")==null){
	 	    response.sendRedirect("login.jsp");
	 	}
	 %>
	 <header>
           <img id="logo" src="images/logo.png"> 
           <a onclick=logout() id="login">Logout</a>
           <a href="help.jsp" id = "login">Help</a>
     </header>
    <div class="payment">
        <h2 class="err">${errMsg}</h2>
        <p class="sign" align="center">Payment Status</p>
        <h2>Payment made Successfully</h2>
    </div>
</body>
</html>

