
//when page loads all HTML elements 
window.onload = function(){
	getName();
	
}


function getName(){
	
	//getting field value
	let swId = document.getElementById('user');
	
	//this object allows us to make requests and get data back
	//in short this is our API caller
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		//console.log('ready state is changing! weee~~~!')
		
		if(xhttp.readyState == 4 && xhttp.status==200){
			//console.log('ready state: ' + xhttp.readyState);
			
			//parse changes a JSON into a javascript object
			//JSON.stringify() does the opposite
			//console.log(xhttp.responseText);
			let sw = JSON.parse(xhttp.responseText);
			console.log();
			swId.innerHTML = " "+sw.firstName;
			//setValues(sw);
		}
	}
	
	
	//create a connection
	//(http method, url, and boolean asynch or not)
	xhttp.open("GET", 'http://localhost:9007/project1/info.reimb');
	
	//this begins the request process
	xhttp.send(); //optional string argument
				//used with http methods other than GET
	
	//console.log(xhttp);
	
}

function setValues(sw){
	document.getElementById("swName").innerHTML = sw.name;
}




















