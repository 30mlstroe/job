function createUser() {
	axios.post("http://localhost:8000/createtworknet").then(resData => {
		data = resData.data;
		console.log(data[3].detail.length);
		document.getElementById("test") = data[3].detail.length;
	}).catch(error => {
		console.log("비정상 응답", error);
	});
};

function faceBookScraping() {
	axios.post("http://localhost:8000/faceBookScraping").then(resData => {
		data = resData.data;
		console.log(data);
		document.getElementById("test") = data;
	}).catch(error => {
		console.log("비정상 응답", error);
	});
};

function blogScraping() {
	axios.post("http://localhost:8000/blogScraping").then(resData => {
		data = resData.data;
		console.log(data);
		document.getElementById("test") = data;
	}).catch(error => {
		console.log("비정상 응답", error);
	});
};