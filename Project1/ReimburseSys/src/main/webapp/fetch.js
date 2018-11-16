//when web page loads all HTML elements
window.onload = function() {
	console.log('in getsw')
	document.getElementById("theButton").addEventListener('click', getSW);
}
//a promis is a placehoder for a future value
//once the value has returned all subscribers
//are notified of the returned value.
function getSW() {
	console.log('in getsw')
	// getting field value
	let uName = document.getElementById('field1').value;
	let pWord = document.getElementById('field2').value;

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log('Ready state: ' + xhttp.readyState);


			let sw = JSON.parse(xhttp.responseText)
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
	xhttp.open("get", 'http://localhost:8080/ReimbursSys/login.json', true);
	//this begins the request process
	xhttp.send(); //optional string argument
				//use with http methods other than GET
	
	//console.log(xhttp);
	
	
}


function setValues(sw){

	document.getElementById("deleteThisLater").innerHTML = sw;
}