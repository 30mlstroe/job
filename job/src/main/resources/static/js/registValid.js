$('#save')
		.click(
				function() {
					var form = $("#regist").serializeArray();
					var json_str = JSON.stringify(form);
					console.log(form);
					console.log(typeof (form));
					var isValid = true;

					var idAndPasswordRE = /^[a-zA-Z0-9]{4,12}$/;
					var emailRE = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
					var phoneChecked = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-([0-9]{3,4})-([0-9]{4})$/;

					var id = document.getElementById("userId");
					var pw = document.getElementById("userPassword");
					var email = document.getElementById("userEmail");

					if (!check(idAndPasswordRE, id,
							"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
						isValid = false;
					}
					if (!check(idAndPasswordRE, pw,
							"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
						isValid = false;
					}
					if (regist.userPassword.value != regist.checkPassword.value) {
						alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
						regist.checkPassword.value = "";
						regist.checkPassword.focus();
						isValid = false;
					}
					if (email.value == "") {
						alert("이메일을 입력해 주세요");
						email.focus();
						isValid = false;
					}
					if (!check(emailRE, email, "적합하지 않은 이메일 형식입니다.")) {
						isValid = false;
					}
					if (regist.userName.value == "") {
						alert("이름을 입력해 주세요");
						join.name.focus();
						isValid = false;
					}
					if (isValid) {
						$.ajax({
							type : "POST",
							dataType : 'text',
							contentType : "application/json",
							data : json_str,
							url : "/sharpleRegister",
							cache : false,
							timeout : 600000,
							success : function(result) {
								if(result == 'ID'){
									alert("ID가 중복되었습니다.")
								}else if(result == 'Succeeded'){
									alert("회원가입 되었습니다.");
									window.location.href = "sharple.html";
								}else{
									window.location.href = "404-page-one.html";
								}
							},
							error : function(xhr, status) {
								alert(xhr + " : " + status);
							}
						}).fail(function() {
							alert("오류 : 다시 시도해 주세요");
						});
					}

				});

function check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
	return false;
};