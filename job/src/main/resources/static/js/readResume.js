(function readResume() {
	axios.post("/readResume").then(resData => {
		data = resData.data;
		if(data.length != 0) {
			var careerText = "";
			console.log(data);
			document.getElementById('title').innerHTML = data.title;
			document.getElementById('user_name').innerHTML = data.user_name + "님의 이력서";
			if(data.enter_type == 'E'){
				document.getElementById('enter_type').innerHTML = data.user_name + "님의 경력 사항";
				careerText = careerText + careerPatten(data.career_1) + careerPatten(data.career_2)+
				careerPatten(data.career_3) + careerPatten(data.career_4);
				document.getElementById('career').innerHTML = careerText;
			};
			document.getElementById('grade1_schoolName').innerHTML = data.grade1_schoolName;
			document.getElementById('grade1_schoolCity').innerHTML = "소재지 : "+data.grade1_schoolCity;
			document.getElementById('grade1_schoolEnd').innerHTML = "졸업여부 : "+data.grade1_schoolEnd;
			document.getElementById('grade_lastgrade').innerHTML = "학력 : "+data.grade_lastgrade;
			document.getElementById('grade1_endYear').innerHTML = "졸업 년도 : "+data.grade1_endYear;
			careerPatten(data.career_1);
		}
}).catch(error => {
	document.getElementById('error').innerHTML = "이력서를 작성하여 주세요";
	console.log("비정상 응답", error);
});
}());

function careerPatten(career) {
	var ex = career.split(',');
	var text = "";
	text = text + "<div class='content-row'>"+
	"<h5>회사이름 : "+ ex[2] +"</h5>"+
	"<ul>"+
		"<li> 근무 기간 : "+ex[0]+" ~ "+ex[1]+"</li>"+
		"<li> 근무한 팀 : "+ex[3]+"</li>"+
		"<li> 직책 : "+ex[3]+"</li>"+
	"</ul>"+
	"</div>"
	
	return text;
		
}