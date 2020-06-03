(function addBtn() {
	document.getElementById('btnAddCareer').innerHTML = "<a href='javascript:void(0);' onclick='career_1();'><i class='md-plus m-r-5'></i>Experience add</a>";
	}());
function career_1() {
	text = '';
	text = text +
	"<div class='card bg-grey lighten-4'>"+
                            "<div class='card-body'>"+
                                "<div class='row'>"+
                                   "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<input type='text' id='careerCompany1' class='form-control' name='careerCompany1' placeholder='회사명'>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<div class='input-group'>"+
                                        "<span class='input-group-addon'>"+
                                            "<i class='md-link'>"+"</i>"+
                                        "</span>"+
                                                "<input type='text' id='careerPar1' class='form-control' name='careerPart1' placeholder='부서명'>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>직책명</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='careerPosition1' class='form-control' name='careerPosition1' placeholder='직전 직책명'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                  "<div class='col-md-6'>"+
                                        "<p>입사일 (기입방법  : 20110502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='startWorkMonth1' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='startWorkMonth1' placeholder='입사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>퇴사일 (기입방법  : 20180502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='exitWorkMonth1' maxlength='8' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" class='form-control' name='exitWorkMonth1' placeholder='퇴사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>"+
                            "</div>"+
                         "</div>";
		document.getElementById('career_1').innerHTML = text;
		document.getElementById('btnAddCareer').innerHTML = "<a href='javascript:void(0);' onclick='career_2();'><i class='md-plus m-r-5'></i>Experience add</a>";
};
function career_2() {
	text = '';
	text = text +
	"<div class='card bg-grey lighten-4'>"+
                            "<div class='card-body'>"+
                                "<div class='row'>"+
                                   "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<input type='text' id='careerCompany2' class='form-control' name='careerCompany2' placeholder='회사명'>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<div class='input-group'>"+
                                        "<span class='input-group-addon'>"+
                                            "<i class='md-link'>"+"</i>"+
                                        "</span>"+
                                                "<input type='text' id='careerPart2' class='form-control' name='careerPart2' placeholder='부서명'>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>직책명</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='careerPosition2' class='form-control' name='careerPosition2' placeholder='직전 직책명'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                  "<div class='col-md-6'>"+
                                        "<p>입사일 (기입방법  : 20110502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='startWorkMonth2' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='startWorkMonth2' placeholder='입사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>퇴사일 (기입방법  : 20180502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='exitWorkMonth2' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='exitWorkMonth2' placeholder='퇴사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>"+
                            "</div>"+
                         "</div>";
		document.getElementById('career_2').innerHTML = text;
		document.getElementById('btnAddCareer').innerHTML = "<a href='javascript:void(0);' onclick='career_3();'><i class='md-plus m-r-5'></i>Experience add</a>";
};
function career_3() {
	text = '';
	text = text +
	"<div class='card bg-grey lighten-4'>"+
                            "<div class='card-body'>"+
                                "<div class='row'>"+
                                   "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<input type='text' id='careerCompany3'  class='form-control' name='careerCompany3' placeholder='회사명'>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<div class='input-group'>"+
                                        "<span class='input-group-addon'>"+
                                            "<i class='md-link'>"+"</i>"+
                                        "</span>"+
                                                "<input type='text' id='careerPart3' class='form-control' name='careerPart3' placeholder='부서명'>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>직책명</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='careerPosition3' class='form-control' name='careerPosition3' placeholder='직전 직책명'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                  "<div class='col-md-6'>"+
                                        "<p>입사일 (기입방법  : 20110502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='startWorkMonth3' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='startWorkMonth3' placeholder='입사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>퇴사일 (기입방법  : 20180502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='exitWorkMonth3' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='exitWorkMonth3' placeholder='퇴사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>"+
                            "</div>"+
                         "</div>";
		document.getElementById('career_3').innerHTML = text;
		document.getElementById('btnAddCareer').innerHTML = "<a href='javascript:void(0);' onclick='career_4();'><i class='md-plus m-r-5'></i>Experience add</a>";
};
function career_4() {
	text = '';
	text = text +
	"<div class='card bg-grey lighten-4'>"+
                            "<div class='card-body'>"+
                                "<div class='row'>"+
                                   "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<input type='text' id='careerCompany4' class='form-control' name='careerCompany4' placeholder='회사명'>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<div class='form-group'>"+
                                            "<div class='input-group'>"+
                                        "<span class='input-group-addon'>"+
                                            "<i class='md-link'>"+"</i>"+
                                        "</span>"+
                                                "<input type='text' id='careerPart4' class='form-control' name='careerPart' placeholder='부서명'>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>직책명</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='careerPosition4' class='form-control' name='careerPosition4' placeholder='직전 직책명'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                  "<div class='col-md-6'>"+
                                        "<p>입사일 (기입방법  : 20110502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='startWorkMonth4' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='startWorkMonth4' placeholder='입사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='col-md-6'>"+
                                        "<p>퇴사일 (기입방법  : 20180502)</p>"+
                                        "<div class='row'>"+
                                            "<div class='col-md-6'>"+
                                                "<div class='form-group'>"+
                                                    "<input type='text' id='exitWorkMonth4' onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" maxlength='8' class='form-control' name='exitWorkMonth4' placeholder='퇴사일'>"+
                                                "</div>"+
                                            "</div>"+
                                        "</div>"+
                                    "</div>"+
                                "</div>"+
                            "</div>"+
                         "</div>";
		document.getElementById('career_4').innerHTML = text;
		document.getElementById('btnAddCareer').innerHTML = null;
};