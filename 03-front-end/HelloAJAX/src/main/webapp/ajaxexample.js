
//when page loads all HTML elements
window.onload = function(){
	document.getElementById("swSubmit")
		.addEventListener('click', getSW);
}


function getSW(){
	
	//getting field value
	let swId = document.getElementById('swId').value;
	
	//this object allows us to make requests and get back data
	//in short, this is our API caller
	let xhttp = new XMLHttpRequest();
	
	/*
	 * READY STATE
	 * 		state 0: not initialized
	 * 		state 1: server connection established
	 * 		state 2: request received
	 * 		state 3: processing request
	 * 		state 4: complete, request finished
	 * 				and response is ready
	 */
	xhttp.onreadystatechange = function(){
		//console.log('ready state is changing! weee~~~!!!')
		
		if(xhttp.readyState == 4 && xhttp.status==200){
			//console.log('ready state:'+ xhttp.readyState);
			//console.log(xhttp.responseText);
			//parse changes a JSON into a javascript object
			//JSON.stringify() does the opposite
			let sw = JSON.parse(xhttp.responseText);
			//console.log(sw);
			setValues(sw);
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'https://swapi.co/api/people/'
			+ swId);
	//this begins the request process
	xhttp.send(); //optional string argument
				// used with http methods other than GET
	
	//console.log(xhttp);
}

function setValues(sw){
	document.getElementById("swName").innerHTML = sw.name;
}














