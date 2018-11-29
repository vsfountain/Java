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
	xhttp.open('GET', 'managerHome.json', true);
	
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
		let pendingAccounts = document.createElement("TR");
		
		let pendingID = document.createElement("TD");
		let pendingUsername = document.createElement("TD");
		let pendingPassword = document.createElement("TD");
		let pendingFirstname = document.createElement("TD");
		let pendingLastname = document.createElement("TD");
		let pendingEmail = document.createElement("TD");
		let pendingRoleID = document.createElement("TD");
		
		let pendingApprove = document.createElement("BUTTON");
		let pendingDeny = document.createElement("BUTTON");
		
		let inputUsername = document.createElement("INPUT");
		let inputPassword = document.createElement("INPUT");
		let inputFirstname = document.createElement("INPUT");
		let inputLastname = document.createElement("INPUT");
		let inputEmail = document.createElement("INPUT");
		let inputRoleID = document.createElement("INPUT");
		inputUsername.setAttribute("name", "username");
		inputPassword.setAttribute("name", "password");
		inputFirstname.setAttribute("name", "firstname");
		inputLastname.setAttribute("name", "lastname");
		inputEmail.setAttribute("name", "email");
		inputRoleID.setAttribute("name", "role");
		inputUsername.readOnly=true;
		inputPassword.readOnly=true;
		inputFirstname.readOnly=true;
		inputLastname.readOnly=true;
		inputEmail.readOnly=true;
		inputRoleID.readOnly=true;
		inputUsername.value = reimResponse[i].ersUsername;
		inputPassword.value = reimResponse[i].ersPassword;
		inputFirstname.value = reimResponse[i].userFirstName;
		inputLastname.value = reimResponse[i].userLastName;
		inputEmail.value = reimResponse[i].userEmail;
		inputRoleID.value = reimResponse[i].userRoleID;
		pendingApprove.setAttribute("class", "btn btn-success");
		pendingDeny.setAttribute("class", "btn btn-danger");
		pendingApprove.setAttribute("type", "submit");
		pendingDeny.setAttribute("type", "submit");
		let approveString = "approve(";
		let denyString = "deny(";
		let approved = approveString.concat(i);
		let denied = denyString.concat(i);
		let totalApproved = approved.concat(")");
		let totalDenied = denied.concat(")");
		pendingApprove.setAttribute("onclick", totalApproved);
		pendingDeny.setAttribute("onclick", totalDenied);
		pendingApprove.innerHTML = "<b>Approve</b>";
		pendingDeny.innerHTML = "<b>Deny</b>";
		pendingID.innerHTML = reimResponse[i].ersUsersID;
		pendingAccounts.appendChild(pendingID);
		inputUsername.setAttribute("class", "userPendingAccount");
		pendingUsername.appendChild(inputUsername);
		pendingAccounts.appendChild(pendingUsername);
		inputPassword.setAttribute("class", "userPendingAccount");
		pendingPassword.appendChild(inputPassword);
		pendingAccounts.appendChild(pendingPassword);
		inputFirstname.setAttribute("class", "userPendingAccount");
		pendingFirstname.appendChild(inputFirstname);
		pendingAccounts.appendChild(pendingFirstname);
		inputLastname.setAttribute("class", "userPendingAccount");
		pendingLastname.appendChild(inputLastname);
		pendingAccounts.appendChild(pendingLastname);
		inputEmail.setAttribute("class", "userPendingAccount");
		pendingEmail.appendChild(inputEmail);
		pendingAccounts.appendChild(pendingEmail);
		inputRoleID.setAttribute("class", "userPendingAccount");
		pendingRoleID.appendChild(inputRoleID);
		pendingAccounts.appendChild(pendingRoleID);
		pendingAccounts.appendChild(pendingApprove);
		pendingAccounts.appendChild(pendingDeny);
		pendingAccounts.setAttribute("id", i);
		document.getElementById("reimbursements").appendChild(pendingAccounts);
	}
	
}

function approve(i){
	let currString = "approvePending_" + i + ".helloRevature";
	document.getElementById("changeAction").setAttribute("action", currString);
}

function deny(i){
	let currString = "denyPending_" + i + ".helloRevature";
	document.getElementById("changeAction").setAttribute("action", currString);
}

function addToMainHomePage(users_response){
	document.getElementById("usersName").innerHTML = "Welcome " + users_response;
}