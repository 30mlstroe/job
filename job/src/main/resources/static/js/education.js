(function recommendEducation() {
    //axios.post("http://192.168.10.84:8000/recommendEducation")
	axios.post("/recommendEducation").then(resData => {
    				data = resData.data;
    				console.log(data);
    				edu2 = data[0][0];
    				var text = "";
    				for(var i= 0 ; i < data[0].length;i++){
    					var edu = data[0][i];
    					console.log(edu);
    					text = text + 
    					"<div class=\"item-jobpost\">"+
                        "<div class=\"row\">"+
                        "<div class=\"col-md-5\">" +
                            "<h5>"+
                                "<a href=\"#\">"+edu.title+"</a>"+
                            "</h5><br>"+
                            "<ul class=\"list-inline\">"+
                           		"<li> 전화 : "+edu.telNo+"</li><br>"+
                                "<li>"+edu.subTitle+"</li><br>"+
                                "<li> 기간 : "+edu.traStartDate+" ~ "+edu.traEndDate+"</li>"+
                                "<li><label class=\"label bg-green lighten-1\">"+edu.superViser+"</label></li>"+
                                "<li><label class=\"label bg-green lighten-1\">"+edu.trainTarget+"</label></li>"+
                            "</ul>"+
                        "</div>"+
                        "<div class=\"col-md-5 jobpost-location\" style=\"float:left;\">"+
                            "<span>"+edu.address+"</span>"+
                        "</div>"+
                        "<div class=\"col-md-2 jobpost-apply-btn\">"+
                            "<a href=\""+edu.subTitleLink+"\" class=\"btn btn-primary btn-block btn-outline btn-sm\">Apply Now <i class=\"md-long-arrow-right m-l-10\"></i></a>"+
                        "</div>"+
                    "</div>"+
                "</div>";
    				};
    				document.getElementById('test').innerHTML = text;
    			})
    		.catch(error => {
    			console.log("비정상 응답", error);
    		});
    	}());