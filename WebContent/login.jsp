<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="style/fpstyle.css">
  <script type="text/javascript" src="js/script.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <title>Sign in</title>
</head>
<body>
	<header>
        <img id="logo" src="images/logo.png">
    </header>
	<div class="main">
		<h2 class="err">${errMsg}</h2>
    	<p class="sign" align="center">Sign in</p>
    	<form class="inputForm" name ="loginForm" action = "UserController" onsubmit="return checkUser()" method="post">
      		<table>
      			<tr>
      				<td colspan="2">
      					<input class="user" id="userName" name ="userName" type="text"  placeholder="Username">
      					<span id="errUserName" class="err"></span>
      				</td>
      			</tr>
	      		<tr>
	      			<td colspan="2">
	      				<input class="pass" id="password" name ="password" type="password"  placeholder="Password">
	      				<span id="errPassword" class="err"></span>
	      			</td>
	      		</tr>
	      		<tr>
	      			<td colspan="2">
	      				<select class="pass" id="type" name="type">
							<option value="" disabled selected>--Type--</option>
	                    	<option value="Admin">Admin</option>
	                    	<option value="Customer">Customer</option>
	                    	<option value="Vendor">Vendor</option>
           				</select>
           				<span id="errType" class="err"></span>
           			</td>
				</tr>
	      		<tr>
	      			<td><input class = "submit" type="submit" value="Login" name="action"></td>
	      		</tr>
	      		<tr><td><br><br></td></tr>
	      		<tr><td class="user"><a href = "customer-registration.jsp">User Register</a></td></tr>
    			<tr><td class="user"><a href = "vendor-registration.jsp">Vendor Register</a></td></tr>
      		</table>
        </form>         
    </div> 
</body>
</html>