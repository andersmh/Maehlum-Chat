var fistNameRegEx = [ A - Za - z ];
var lastNameRegEx = [];
var emailRegEx = [];
var usernameRegEx = [];

function firstNameValidation() {

	var firstNameInput = document.getElementById("firstNameID").value;

	if(firstNameInput === "Anders"){
		document.getElementById("firstNameMessage").innerHTML = "Du skrev Anders";
	}
}

function lastNameValidation() {

	var lastNameInput = document.getElementById("lastNameID").value;

}

function emailValidation() {

	var emailInput = document.getElementById("emailID").value;

}

function usernameValidation() {

	var usernameInput = document.getElementById("usernameID").value;

}

function password1Validation() {

	var password1Input = document.getElementById("password1ID").value;
}

function password2Validation() {

	var password2Input = document.getElementById("password2ID").value;

}