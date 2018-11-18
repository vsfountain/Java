//when web page loads all HTML elements
window.onload = function() {
	console.log('in getsw1');
	getSW();
	getReimburse();
}
//a promis is a placehoder for a future value
//once the value has returned all subscribers
//are notified of the returned value.
function getSW() {
	console.log('in getsw');
	// getting field value
	let uName = document.getElementById('user').value;
	

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log('Ready state: ' + xhttp.readyState);


			let sw = JSON.parse(xhttp.responseText);
			console.log(sw);
			setValues(sw);
		}
	};
	/*
	READY STATE 
		0: not initialized
		1: server connection establised
		2: request recived
		3: processing request
		4: complete, request finised, and repsonse is ready
	*/ 
	//create a connection (http method, url, boolean async or not value)
	xhttp.open("get", '/ReimburseSys/getUser', true);
	//this begins the request process
	xhttp.send(); //optional string argument
				//use with http methods other than GET
	
	//console.log(xhttp);
	
	
}

function getReimburse(){
	console.log('inReimburse');
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log('Ready state: ' + xhttp.readyState);


			let sw = JSON.parse(xhttp.responseText);
			console.log(sw);
		}
	};
	xhttp.open("get", '/ReimburseSys/getReimburse', true);
	xhttp.send();
}


function setValues(sw){

	document.getElementById("user").innerHTML = "Hello " + sw.firstName + " " + sw.lastname;
}