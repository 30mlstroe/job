(function weightRead() {
	axios.post("/readWeight")
			.then(resData => {
				data = resData.data;
				console.log(data);
			})
		.catch(error => {
			console.log("비정상 응답", error);
		});
	}());