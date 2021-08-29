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
           <a onclick=logout() id="login">Logout</a>
     </header>
    <div class="main" >
		<p id="order">We want you to have simplest and easiest payment experience.But we know you might have few questions.Use help to post your queries</p>
   		<div class="dropdown">
 	 		<button onclick="myFunction()" class="dropbtn" >How can i help you?</button>
 	 		<div id="myDropdown" class="dropdown-content">
   		 		<a href="help-report.jsp">Login issues</a>
   		 		<a href="help-report.jsp">Payment issues</a>
   		 		<a href="help-report.jsp">Bank Account</a>
    			<a href="help-report.jsp">password issues</a>
  			</div>
		</div>
	</div>
</body>
</html>