function checkUser() {
	var userName = document.forms["loginForm"]["userName"].value.trim();
	var password = document.forms["loginForm"]["password"].value.trim();
	var type = document.forms["loginForm"]["type"].value.trim();
	var isValid = true;

	if (userName == "") {
		document.getElementById("errUserName").innerText = "Username is mandatory";
		isValid = false;
	} else {
		document.getElementById("errUserName").innerText = "";
	}
	if (password == "") {
		document.getElementById("errPassword").innerText = "Cannot be empty";
		isValid = false;
	} else {
		document.getElementById("errPassword").innerText = "";
	}
	if (type == "") {
		document.getElementById("errType").innerText = "Cannot be empty";
		isValid = false;
	} else {
		document.getElementById("errType").innerText = "";
	}
	return isValid;
}

function validateVendor() {
	var name = document.forms["vendorForm"]["name"].value.trim();
	var registerNum = document.forms["vendorForm"]["registerNum"].value.trim();
	var vendorType = document.forms["vendorForm"]["vendorType"].value.trim();
	var address = document.forms["vendorForm"]["address"].value.trim();
	var state = document.forms["vendorForm"]["state"].value.trim();
	var email = document.forms["vendorForm"]["email"].value.trim();
	var contact = document.forms["vendorForm"]["contact"].value.trim();
	var website = document.forms["vendorForm"]["website"].value.trim();
	var issuedDate = document.forms["vendorForm"]["issuedDate"].value.trim();
	var validityDate = document.forms["vendorForm"]["validityDate"].value
			.trim();
	var year = document.forms["vendorForm"]["year"].value.trim();
	var payment = document.forms["vendorForm"]["payment"].value.trim();
	var userName = document.forms["vendorForm"]["userName"].value.trim();
	var password = document.forms["vendorForm"]["password"].value.trim();
	var num = /^[0-9]*\.?[0-9]*$/;
	var isValid = true;

	if (name == "") {
		document.getElementById("errName").innerText = "Name is required";
		isValid = false;
	} else {
		document.getElementById("errName").innerText = "";
	}
	if (registerNum == "") {
		document.getElementById("errRegisterNum").innerText = "Registration Number is required";
		isValid = false;
	} else {
		document.getElementById("errRegisterNum").innerText = "";
	}
	if (vendorType == "-") {
		document.getElementById("errVendorType").innerText = "Type is required";
		isValid = false;
	} else {
		document.getElementById("errVendorType").innerText = "";
	}
	if (address == "") {
		document.getElementById("errAddress").innerText = "Address is required";
		isValid = false;
	} else {
		document.getElementById("errAddress").innerText = "";
	}
	if (state == "-") {
		document.getElementById("errState").innerText = "State is required";
		isValid = false;
	} else {
		document.getElementById("errState").innerText = "";
	}
	if (email == "") {
		document.getElementById("errEmail").innerText = "Email is required";
		isValid = false;
	} else {
		document.getElementById("errEmail").innerText = "";
	}
	if (contact == "") {
		document.getElementById("errContact").innerText = "Contact is required";
		isValid = false;
	} else if (num.test(contact) == false) {
		document.getElementById("errContact").innerText = "Contact has to be a number";
		isValid = false;
	} else {
		document.getElementById("errContact").innerText = "";
	}
	if (website == "") {
		document.getElementById("errWebsite").innerText = "Website is required";
		isValid = false;
	} else {
		document.getElementById("errWebsite").innerText = "";
	}
	if (issuedDate == "") {
		document.getElementById("errIssuedDate").innerText = "Issue Date is required";
		isValid = false;
	} else {
		document.getElementById("errIssuedDate").innerText = "";
	}
	if (validityDate == "") {
		document.getElementById("errValidityDate").innerText = "Validity Date is required";
		isValid = false;
	} else {
		document.getElementById("errValidityDate").innerText = "";
	}
	if (year == "") {
		document.getElementById("errYear").innerText = "Year is required";
		isValid = false;
	} else if (num.test(year) == false) {
		document.getElementById("errYear").innerText = "Year has to be a number";
		isValid = false;
	} else {
		document.getElementById("errYear").innerText = "";
	}
	if (payment == "") {
		document.getElementById("errPayment").innerText = "Payment is required";
		isValid = false;
	} else {
		document.getElementById("errPayment").innerText = "";
	}
	if (userName == "") {
		document.getElementById("errUserName").innerText = "Username is mandatory";
		isValid = false;
	} else {
		document.getElementById("errUserName").innerText = "";
	}
	if (password == "") {
		document.getElementById("errPassword").innerText = "cannot be empty";
		isValid = false;
	} else if (password.length < 8) {
		document.getElementById("errPassword").innerText = "Must contain atleast 8 characters";
		isValid = false;
	} else {
		document.getElementById("errPassword").innerText = "";
	}
	return isValid;
}

function validateCustomer() {
	var firstName = document.forms["customerForm"]["firstName"].value.trim();
	var lastName = document.forms["customerForm"]["lastName"].value.trim();
	var age = document.forms["customerForm"]["age"].value.trim();
	var panNo = document.forms["customerForm"]["pan"].value.trim();
	var aadharNo = document.forms["customerForm"]["aadhar"].value.trim();
	var contactNo = document.forms["customerForm"]["contact"].value.trim();
	var userName = document.forms["customerForm"]["userName"].value.trim();
	var password = document.forms["customerForm"]["password"].value.trim();
	var num = /^[0-9]*\.?[0-9]*$/;
	var isValid = true;

	if (firstName == "") {
		document.getElementById("errFirstName").innerText = "FirstName is mandatory";
		isValid = false;
	} else {
		document.getElementById("errFirstName").innerText = "";
	}
	if (lastName == "") {
		document.getElementById("errLastName").innerText = "Last Name is mandatory";
		isValid = false;
	} else {
		document.getElementById("errLastName").innerText = "";
	}
	if (age == "") {
		document.getElementById("errAge").innerText = "Age is mandatory";
		isValid = false;
	} else if (num.test(age) == false) {
		document.getElementById("errAge").innerText = "Age has to be a number";
		isValid = false;
	} else {
		document.getElementById("errAge").innerText = "";
	}
	if (panNo == "") {
		document.getElementById("errPan").innerText = "Pan number is mandatory";
		isValid = false;
	} else {
		document.getElementById("errPan").innerText = "";
	}
	if (aadharNo == "") {
		document.getElementById("errAadhar").innerText = "Aadhar is mandatory";
		isValid = false;
	} else if (num.test(aadharNo) == false) {
		document.getElementById("errAadhar").innerText = "Aadhar has to be a number";
		isValid = false;
	} else {
		document.getElementById("errAadhar").innerText = "";
	}
	if (contactNo == "") {
		document.getElementById("errContact").innerText = "Contact number is mandatory";
		isValid = false;
	} else if (num.test(contactNo) == false) {
		document.getElementById("errContact").innerText = "Contact number has to be a number";
		isValid = false;
	} else {
		document.getElementById("errContact").innerText = "";
	}
	if (userName == "") {
		document.getElementById("errUserName").innerText = "Username is mandatory";
		isValid = false;
	} else {
		document.getElementById("errUserName").innerText = "";
	}
	if (password == "") {
		document.getElementById("errPassword").innerText = "cannot be empty";
		isValid = false;
	} else if (password.length < 8) {
		document.getElementById("errPassword").innerText = "Must contain atleast 8 characters";
		isValid = false;
	} else {
		document.getElementById("errPassword").innerText = "";
	}
	return isValid;

}

function validateCard() {
	var cardNumber = document.forms["cardForm"]["cardNum"].value.trim();
	var cvv = document.forms["cardForm"]["number"].value.trim();
	var validityDate = document.forms["cardForm"]["validityDate"].value.trim();
	var isValid = true;
	if (cardNumber == "") {
		document.getElementById("errCard").innerText = "Card Number is mandatory";
		isValid = false;
	} else if (isNaN(cardNumber) == true) {
		document.getElementById("errCard").innerText = "Card Number has to be a number only";
		isValid = false;
	} else {
		document.getElementById("errCard").innerText = "";
	}
	if (cvv == "") {
		document.getElementById("errNumber").innerText = "CVV is mandatory";
		isValid = false;
	} else if (isNaN(cvv) == true) {
		document.getElementById("errNumber").innerText = "CVV has to be a number";
		isValid = false;
	} else {
		document.getElementById("errNumber").innerText = "";
	}
	if (validityDate == "") {
		document.getElementById("errValidityDate").innerText = "Validity Date is mandatory";
		isValid = false;
	} else {
		document.getElementById("errValidityDate").innerText = "";
	}
	return isValid;
}
function validatePhone() {
	var upiId = document.forms["phoneForm"]["number"].value.trim();
	var isValid = true;
	if (upiId == "") {
		document.getElementById("errNumber").innerText = "Please provide UPI Id";
		isValid = false;
	} else if (isNaN(upiId) == true) {
		document.getElementById("errNumber").innerText = "UPI has to be a number only";
		isValid = false;
	} else {
		document.getElementById("errNumber").innerText = "";
	}
	return isValid;
}
function validateBank() {
	var accountNumber = document.forms["bankForm"]["accountNumber"].value
			.trim();
	var userId = document.forms["bankForm"]["userName"].value.trim();
	var password = document.forms["bankForm"]["password"].value.trim();
	var isValid = true;
	if (accountNumber == "") {
		document.getElementById("errNumber").innerText = "Account Number is mandatory";
		isValid = false;
	} else if (isNaN(accountNumber) == true) {
		document.getElementById("errNumber").innerText = "Account Number has to be a number only";
		isValid = false;
	} else {
		document.getElementById("errNumber").innerText = "";
	}
	if (userId == "") {
		document.getElementById("errUser").innerText = "UserId is mandatory";
		isValid = false;
	} else {
		document.getElementById("errUser").innerText = "";
	}
	if (password == "") {
		document.getElementById("errPassword").innerText = "Password is mandatory";
		isValid = false;
	} else {
		document.getElementById("errPassword").innerText = "";
	}
	return isValid;
}
function validatePayment() {
	var amount = document.forms["paymentForm"]["amount"].value.trim();
	var paymentType = document.forms["paymentForm"]["paymentType"].value.trim();
	var billDate = document.forms["paymentForm"]["billDate"].value.trim();
	var isValid = true;
	if (amount == "") {
		document.getElementById("errAmount").innerText = "Amount is required";
		isValid = false;
	} else if (isNaN(amount) == true) {
		document.getElementById("errAmount").innerText = "Amount has to be a number only";
		isValid = false;
	} else {
		document.getElementById("errAmount").innerText = "";
	}
	if (paymentType == "") {
		document.getElementById("errPaymentMode").innerText = "Paymentmode is required";
		isValid = false;
	} else {
		document.getElementById("errPaymentMode").innerText = "";
	}
	if (billDate == "") {
		document.getElementById("errBillDate").innerText = "Bill date is required";
		isValid = false;
	} else {
		document.getElementById("errBillDate").innerText = "";
	}
	return isValid;
}
function validateEdit() {
	var email = document.forms["vendorEditForm"]["email"].value.trim();
	var contact = document.forms["vendorEditForm"]["contact"].value.trim();
	var website = document.forms["vendorEditForm"]["website"].value.trim();
	var date = document.forms["vendorEditForm"]["validityDate"].value.trim();
	var payment = document.forms["vendorEditForm"]["payment"].value.trim();
	var password = document.forms["vendorEditForm"]["password"].value.trim();
	var isValid = true;
	if (email == "") {
		document.getElementById("errEmail").innerText = "Email Id is required";
		isValid = false;
	} else {
		document.getElementById("errEmail").innerText = "";
	}
	if (contact == "") {
		document.getElementById("errContact").innerText = "Contact Number is required";
		isValid = false;
	} else if (isNaN(contact) == true) {
		document.getElementById("errContact").innerText = "Contact Number has to be a number only";
		isValid = false;
	} else {
		document.getElementById("errContact").innerText = "";
	}
	if (website == "") {
		document.getElementById("errWebsite").innerText = "Website is required";
		isValid = false;
	} else {
		document.getElementById("errWebsite").innerText = "";
	}
	if (date == "") {
		document.getElementById("errValidityDate").innerText = "Validity Date is required";
		isValid = false;
	} else {
		document.getElementById("errValidityDate").innerText = "";
	}
	if (payment == "") {
		document.getElementById("errPayment").innerText = "Payment is required";
		isValid = false;
	} else {
		document.getElementById("errPayment").innerText = "";
	}
	if (password == "") {
		document.getElementById("errPassword").innerText = "Password is required";
		isValid = false;
	} else {
		document.getElementById("errPassword").innerText = "";
	}
	return isValid;
}
function myFunction() {
	document.getElementById("myDropdown").classList.toggle("show");
}
function logout() {
	window.open("LogOutController", "_self", "");
}

