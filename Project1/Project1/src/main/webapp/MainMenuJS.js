window.onload = function(){
	//getting field value
	let req = document.getElementById("reimbursementRequest").value;
	//this object allows us to make requests and get back data
	//in short, this is our API caller (Application program interface, allowing programs to interact with one another)
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange= function(){
		//console.log('ready state is changing! weee~~~~~~~!!!');
		
		//200s is good okay, 400 is problem on client side, 500 is problem on server side
		if(xhttp.readyState == 4 && xhttp.status==200){
			//parse changes a JSON into a javascript object
			//JSON.stringify() does the opposite
			let reimResponse = JSON.parse(xhttp.responseText);
			addToPage(reimResponse);
		}
	}
	//create a connection
	//(http method, url, boolean asynch or not)
	//xhttp.open("GET", 'http://localhost:9005/Project1/MainMenu.html#two'
	xhttp.open('GET', 'home.json', true);
	
	//this begins the request process
	xhttp.send(); //optional string argument
				//used with http methods other than GET
	let xhttpp = new XMLHttpRequest();
	xhttpp.onreadystatechange= function(){
		
		if(xhttpp.readyState == 4 && xhttpp.status==200){
			let reimName = JSON.parse(xhttpp.responseText);
			console.log("WE MADE IT");
			addToMainHomePage(reimName);
		}
	}
	
	xhttpp.open('GET', 'name.json', true);
	xhttpp.send();
	//console.log(xhttp);
}

function addToPage(reimResponse){
	for(let i = 0; i < reimResponse.length; i++){
		let reimRequests = document.createElement("TR");
		let reimbIDTD = document.createElement("TD");
		let reimbAmountTD = document.createElement("TD");
		let reimbDescriptionTD = document.createElement("TD");
		let reimbAuthorTD = document.createElement("TD");
		let reimbStatusTD = document.createElement("TD");
		let reimbTypeTD = document.createElement("TD");
		let reimbSubmittedTD = document.createElement("TD");
		let reimbResolvedTD = document.createElement("TD");
		reimbIDTD.innerHTML = reimResponse[i].reimbID;
		reimRequests.appendChild(reimbIDTD);
		reimbAmountTD.innerHTML = reimResponse[i].reimbAmount;
		reimRequests.appendChild(reimbAmountTD);
		reimbDescriptionTD.innerHTML = reimResponse[i].reimbDescription;
		reimRequests.appendChild(reimbDescriptionTD);
		reimbAuthorTD.innerHTML = reimResponse[i].reimbAuthor;
		reimRequests.appendChild(reimbAuthorTD);
		reimbStatusTD.innerHTML = reimResponse[i].reimbStatusID;
		reimRequests.appendChild(reimbStatusTD);
		reimbTypeTD.innerHTML = reimResponse[i].reimbTypeID;
		reimRequests.appendChild(reimbTypeTD);
		reimbSubmittedTD.innerHTML = reimResponse[i].reimbSubmitted;
		reimRequests.appendChild(reimbSubmittedTD);
		if(reimResponse[i].reimbResolved == "null"){
			reimbResolvedTD.innerHTML = "Not yet Resolved";
		}
		else {
			reimbResolvedTD.innerHTML = reimResponse[i].reimbResolved;
		}
		reimRequests.appendChild(reimbResolvedTD); 
		document.getElementById("reimbursements").appendChild(reimRequests);
	}
	
}

function addToMainHomePage(users_response){
	document.getElementById("usersName").innerHTML = "Welcome " + users_response;
}