window.onload = function(){
	//getting field value
	//this object allows us to make requests and get back data
	//in short, this is our API caller (Application program interface, allowing programs to interact with one another)
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange= function(){
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
	xhttp.open('GET', 'managerReimbRequests.json', true);
	
	//this begins the request process
	xhttp.send(); //optional string argument
				//used with http methods other than GET
	let xhttpp = new XMLHttpRequest();
	xhttpp.onreadystatechange= function(){
		
		if(xhttpp.readyState == 4 && xhttpp.status==200){
			let reimName = JSON.parse(xhttpp.responseText);
			addToMainHomePage(reimName);
		}
	}
	
	xhttpp.open('GET', 'name.json', true);
	xhttpp.send();
}

function addToPage(reimResponse){
	for(let i = 0; i < reimResponse.length; i++){
		let reimbursementRequests = document.createElement("TR");
		let reimbID = document.createElement("TD");
		let reimbAmount = document.createElement("TD");
		let reimbDescription = document.createElement("TD");
		let reimbAuthor = document.createElement("TD");
		let reimbStatus = document.createElement("TD");
		let reimbType = document.createElement("TD");
		let reimbSubmittedDate = document.createElement("TD");
		let reimbApprove = document.createElement("BUTTON");
		let reimbDeny = document.createElement("BUTTON");
		let inputReimbID = document.createElement("INPUT");
		inputReimbID.setAttribute("name", "reimbID");
		inputReimbID.readOnly=true;
		reimbApprove.setAttribute("class", "btn btn-success");
		reimbDeny.setAttribute("class", "btn btn-danger");
		reimbApprove.setAttribute("type", "submit");
		reimbDeny.setAttribute("type", "submit");
		let approveString = "approve(";
		let denyString = "deny(";
		let approved = approveString.concat(i);
		let denied = denyString.concat(i);
		let totalApproved = approved.concat(")");
		let totalDenied = denied.concat(")");
		reimbApprove.setAttribute("onclick", totalApproved);
		reimbDeny.setAttribute("onclick", totalDenied);
		reimbApprove.innerHTML = "<b>Approve</b>";
		reimbDeny.innerHTML = "<b>Deny</b>";
		
		inputReimbID.value = reimResponse[i].reimbID;
		reimbID.appendChild(inputReimbID);
		reimbursementRequests.appendChild(reimbID);
		
		reimbAmount.innerHTML = reimResponse[i].reimbAmount;
		reimbursementRequests.appendChild(reimbAmount);
		reimbDescription.innerHTML = reimResponse[i].reimbDescription;
		reimbursementRequests.appendChild(reimbDescription);
		reimbAuthor.innerHTML = reimResponse[i].reimbAuthor;
		reimbursementRequests.appendChild(reimbAuthor);
		reimbStatus.innerHTML = reimResponse[i].reimbStatusID;
		reimbursementRequests.appendChild(reimbStatus);
		reimbType.innerHTML = reimResponse[i].reimbTypeID;
		reimbursementRequests.appendChild(reimbType);
		reimbSubmittedDate.innerHTML = reimResponse[i].reimbSubmitted;
		reimbursementRequests.appendChild(reimbSubmittedDate);

		reimbursementRequests.appendChild(reimbApprove);
		reimbursementRequests.appendChild(reimbDeny);
		reimbursementRequests.setAttribute("id", i);
		
		
		document.getElementById("reimbursements").appendChild(reimbursementRequests);
	}
	
}

function approve(i){
	let currString = "approveReimbursement_" + i + ".helloRevature";
	document.getElementById("changeAction").setAttribute("action", currString);
}

function deny(i){
	let currString = "denyReimbursement_" + i + ".helloRevature";
	document.getElementById("changeAction").setAttribute("action", currString);
}

function addToMainHomePage(users_response){
	document.getElementById("usersName").innerHTML = "Welcome " + users_response;
}