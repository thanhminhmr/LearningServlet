// $('#txtUser').on('blur', function () {
//     var input = $('#txtUser').val();
//     var filter = /^([a-xA-Z0-9\_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
//     if (!filter.test(input)) {
//         $('#infUser').css({ "color": "#d41c1c" });
//         $('#txtUser').css({ "border-color": "#d41c1c" });
//     }
//     else {
//         $('#infUser').css({ "color": "#A2A2A2" });
//         $('#txtUser').css({ "border-color": "initial" });
//     }
// });

// $('#txtPassword').on('blur', function () {
//     var input = $('#txtPassword').val();
//     if (input.length == 0) {
//         $('#infPassword').css({ "color": "#d41c1c" });
//         $('#txtPassword').css({ "border-color": "#d41c1c" });
//     }
//     else {
//         $('#infPassword').css({ "color": "#A2A2A2" });
//         $('#txtPassword').css({ "border-color": "initial" });
//     }
// });

//validate form login
function checkUser() {
	var user = document.getElementById("txtUser").value;
	if (user.length == 0) {
		document.getElementById("txtUser").style.borderColor = "red";
		return false;
	} else {
		document.getElementById("txtUser").style.borderColor = "initial";
		return true;
	}
};

function checkPassword() {
	var password = document.getElementById("txtPassword").value;
	if (password.length == 0) {
		document.getElementById("txtPassword").style.borderColor = "red";
		return false;
	} else {
		document.getElementById("txtPassword").style.borderColor = "initial";
		return true;
	}
};

function checkInput(id) {
	var input = document.getElementById(id).value;
	if (input.length == 0) {
		document.getElementById(id).style.borderColor = "red";
		document.getElementById(id).focus();
		return false;
	} else {
		document.getElementById(id).style.borderColor = "initial";
	}
}

function checkEmail(id) {
	var input = document.getElementById(id).value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.test(input)) {
		document.getElementById(id).style.color = 'red';
		return false;
	} else {
		document.getElementById(id).style.color = 'initial';
		return true;
	}
}

function validateFormLogin() {
	var user = document.getElementById("txtUser").value;
	var password = document.getElementById("txtPassword").value;
	if (user.length == 0 || password.length == 0) {
		document.getElementById("msgBox").innerHTML = "Tài khoản và Mật khẩu không được để trống.";
		if (user.length == 0) {
			document.getElementById("txtUser").focus();
		} else {
			document.getElementById("txtPassword").focus();
		}
		return false;
	} else {
		document.getElementById("msgBox").innerHTML = "";
		return true;
	}
}

// validate form add new user
function checkCodeName() {
	var codeName = document.getElementById("code_name").value;
	var element = document.getElementsByClassName("code");
	for (var i = 0; i < element.length; i++) {
		if (codeName == "-1") {
			element[i].disabled = true;
		} else {
			element[i].disabled = false;
		}
	}
}

function validateFormAddUser() {
	var username = document.getElementById("username").value;
	var groupname = document.getElementById("group_name").value;
	var fullname = document.getElementById("fullname").value;
	var namekata = document.getElementById("namekata").value;
	// var gender = document.getElementsByName("gender");
	// var birthday = document.getElementById("birthday").value;
	var email = document.getElementById("email").value;
	var tel = document.getElementById("tel").value;
	var password = document.getElementById("password").value;
	var confirm = document.getElementById("confirm").value;
	var codename = document.getElementById("code_name").value;
	var startdate = document.getElementById("start_date").value;
	var enddate = document.getElementById("end_date").value;
	var poin = document.getElementById("poin").value;

	// username
	if (username.length == 0) {
		document.getElementById("username").style.borderColor = "red";
		document.getElementById("username").focus();
		return false;
	} else {
		document.getElementById("username").style.borderColor = "initial";
	}
	// groupname
	if (groupname == -1) {
		document.getElementById("group_name").style.borderColor = "red";
		document.getElementById("group_name").focus();
		return false;
	} else {
		document.getElementById("group_name").style.borderColor = "initial";
	}
	// fullname
	if (fullname.length == 0) {
		document.getElementById("fullname").style.borderColor = "red";
		document.getElementById("fullname").focus();
		return false;
	} else {
		document.getElementById("fullname").style.borderColor = "initial";
	}
	// name kata
	if (namekata.length == 0) {
		document.getElementById("namekata").style.borderColor = "red";
		document.getElementById("namekata").focus();
		return false;
	} else {
		document.getElementById("namekata").style.borderColor = "initial";
	}
	// email
	if (email.length == 0) {
		document.getElementById("email").style.borderColor = "red";
		document.getElementById("email").focus();
		return false;
	} else {
		if (!checkEmail("email")) {
			document.getElementById("email").style.borderColor = "red";
			document.getElementById("email").focus();
			return false;
		} else {
			document.getElementById("email").style.borderColor = "initial";
		}
	}
	// tel
	if (tel.length == 0) {
		document.getElementById("tel").style.borderColor = "red";
		document.getElementById("tel").focus();
		return false;
	} else {
		document.getElementById("tel").style.borderColor = "initial";
	}
	// password
	if (password.length == 0) {
		document.getElementById("password").style.borderColor = "red";
		document.getElementById("password").focus();
		return false;
	} else {
		document.getElementById("password").style.borderColor = "initial";
	}
	// confirm
	if (confirm.length == 0) {
		document.getElementById("confirm").style.borderColor = "red";
		document.getElementById("confirm").focus();
		return false;
	} else {
		document.getElementById("confirm").style.borderColor = "initial";
	}
	// code name
	if (!codename == -1) {
		// poin
		if (poin.length == 0) {
			document.getElementById("poin").style.borderColor = "red";
			document.getElementById("poin").focus();
			return false;
		} else {
			if (poin >= 80 && poin <= 180) {
				document.getElementById("poin").style.borderColor = "red";
				document.getElementById("poin").focus();
				return false;
			}
			document.getElementById("poin").style.borderColor = "initial";
		}
	} else {

	}

}

function sleep(milliseconds) {
	alert("Lưu thành công");
	var start = new Date().getTime();
	for (var i = 0; i < 1e7; i++) {
		if ((new Date().getTime() - start) > milliseconds) {
			break;
		}
	}
}

$(document).ready(function() {
	$('#btnSubmit').click(function() {
		alert(1);
		var dataForm = {};
		dataForm.name = $("#txtName").val();
		dataForm.email = $("#txtEmail").val();
		dataForm.group = $("#groupname").val();

		$.ajax({
			url : "home",
			type : "post",
			data : {
				txtName : $("#txtName").val(),
				txtEmail : $("#txtEmail").val(),
				groupname : $("#groupname").val()
			},
			success : function(result) {
				$("table#tbody tbody").html(result);
			},
			error : function(e) {
				console.log(e);
			}
		});
	});

});
