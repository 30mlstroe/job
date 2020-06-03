(function facebookRead() {
	axios.post("/readFaceBook")
			.then(resData => {
				data = resData.data;
				var text = "";
				document.getElementById('total').innerHTML = "Total of "+data.length+" results";
				for(var i = 0; i < data.length; i++){
					text = text + 
					"<div class=\"item-jobpost\">"+
	                "<div class=\"row\">"+
	                "<div class=\"col-md-5\">" +
	                    "<h5>"+
	                        data[i].title+
	                    "</h5><br>"+
	                    "<ul class=\"list-inline\">"+
	                    "</ul>"+
	                "</div>"+
	                "<div class=\"col-md-5 jobpost-location\" style=\"float:left;\">"+
	                    "<span>"+data[i].date+"</span>"+
	                "</div>"+
	                "<div class=\"col-md-2 jobpost-apply-btn\">"+
	                    "<a href=\""+data[i].url+"\" class=\"btn btn-primary btn-block btn-outline btn-sm\">Apply Now <i class=\"md-long-arrow-right m-l-10\"></i></a>"+
	                "</div>"+
	                "</div>"+
	                "</div>";
				}
				document.getElementById('body').innerHTML = text;
			})
		.catch(error => {
			console.log("비정상 응답", error);
		});
	}());