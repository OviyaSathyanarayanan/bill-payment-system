<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Customer Registration</title>
<script type="text/javascript" src="js/script.js"></script>
<link href="style/fpstyle.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
</head>
<body>
	<header>
          <img src="images/logo.png" id="logo"> 
          <a href="login.jsp" id="login">Login</a>
    </header>
    <div class = "register">
		<p class="title" align="center">Customer Registration</p>
		<c:if test="${RegisterStatus==true}">
			<p class="sign" align="center">New User Registered Successfully</p>
     	</c:if>
        <p class="err">${errMsg}</p>
		<form name="customerForm" action="UserController" method ="post" onsubmit = "return validateCustomer()">
			<table id = "user-tab">
				<tr>
					<td><label for ="firstName">First Name</label></td>
                    <td>
                    	<input type="text" id="firstName" name="firstName">
                        <span id="errFirstName" class="error"></span>
                    </td>
                </tr>
                <tr>
                	<td><label for ="lastName">Last Name</label></td>
                    <td>
                    	<input type="text" id="lastName" name="lastName">
                        <span id="errLastName" class="error"></span>
                    </td>
                </tr>
                <tr>
                	<td><label for ="age"> Age </label></td>
                    <td>
                    	<input type="text" id="age" name="age">
                        <span id="errAge" class="error"></span>
                    </td>
                </tr>
                <tr>
                	<td><label for ="gender">Gender</label></td>
                    <td>
                    	<label for="male">Male</label>
                        <input type = "radio" id="male" name="gender" value="male" checked="checked">
                   		<label for="female">Female</label>
                   		<input type = "radio" id="female" name="gender" value="female">
                   	</td>
              	</tr>
              	<tr>
              		<td><label for ="contact">Contact Number</label></td>
                    <td>
                    	<input type="text" id="contact" name="contact">
                    	<span id="errContact" class="error"></span>
                    </td>
              	</tr>
              	<tr>
              		<td><label for ="pan">PAN</label></td>
                   	<td>
                   		<input type="text" id="pan" name="pan">
                   		<span id="errPan" class="error"></span>
                   	</td>
              	</tr>
              	<tr>
              		<td><label for ="aadhar">Aadhar Number</label></td>
                   	<td>
                   		<input type="text" id="aadhar" name="aadhar">
                   		<span id="errAadhar" class="error"></span>
                   	</td>
              	</tr>
              	<tr>
              		<td><label for ="userName">Username</label></td>
                   	<td>
                   		<input type="text" id="userName" name="userName">
                   		<span id="errUserName" class="error"></span>
                   	</td>
              	</tr>
              	<tr>
              		<td><label for ="password">Password</label></td>
                   	<td>
                   		<input type="password" id="password" name="password">
                   		<span id="errPassword" class="error"></span>
                   	</td>
              	</tr>
              	<tr>
                   	<td> <input class = "submit" type="submit" value="Register" name="action1"></td>
                   	<td><input class = "submit" type="reset" value="Reset"> </td>
              	</tr>
            </table>
		</form>
	</div>
</body>
</html>

