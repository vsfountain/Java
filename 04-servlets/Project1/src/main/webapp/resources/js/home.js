/**
 * 
 */
//when page loads all HTML elements


//getAllReimbursements();
function getSW(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			let sw = JSON.parse(xhttp.responseText);
			setValues(sw);
			
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'user.json');
	//this begins the request process
	xhttp.send(); //optional string argument
				// used with http methods other than GET
}
	
function getAllReimbursements(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			let sw = JSON.parse(xhttp.responseText);
			for(let i = 0; i < sw.length; i++){
				let pendingAccounts = document.createElement("TR");
					
					let pendingId = document.createElement("TD");
					pendingId.innerHTML = sw[i].reim_id;
					pendingAccounts.appendChild(pendingId);
					
					let pendingAmount = document.createElement("TD");
					pendingAmount.innerHTML = "$" + sw[i].reim_amount;	
					pendingAccounts.appendChild(pendingAmount);
				
					let pendingDescr= document.createElement("TD");
					pendingDescr.innerHTML = sw[i].reim_description;
					pendingAccounts.appendChild(pendingDescr);
				  
					let pendingAuthor = document.createElement("TD");
				    pendingAuthor.innerHTML = sw[i].Reim_author_name;
				    pendingAccounts.appendChild(pendingAuthor);
				    
				    let pendingStatus= document.createElement("TD");
					if(sw[i].reim_status==1){
						pendingStatus.innerHTML = "Pending";
						pendingAccounts.style.fontcolor = "red";
					}
					if(sw[i].reim_status==2){
						pendingStatus.innerHTML = "Approved";
						pendingAccounts.style.backgroundColor = "hsla(120, 100%,80%, 0.5)";}
					if(sw[i].reim_status==3){
						pendingStatus.innerHTML = "Denied";
						pendingAccounts.style.backgroundColor = "hsla(0, 100%, 80%,0.5)";}
				
					pendingAccounts.appendChild(pendingStatus);
				  
					let pendingType=document.createElement("TD");
					if(sw[i].reim_type_id==1){
						pendingType.innerHTML = "Lodging";}
					if(sw[i].reim_type_id==2){
						pendingType.innerHTML = "Travel";}
					if(sw[i].reim_type_id==3){
						pendingType.innerHTML = "Food";
						pendingType.id = "p-3 mb-2 bg-danger text-white"}
					if(sw[i].reim_type_id==4){
						pendingType.innerHTML = "Other";}
					pendingAccounts.appendChild(pendingType);
					
					let submitDate = document.createElement("TD");
					submitDate.innerHTML = sw[i].reim_submitted;
					pendingAccounts.appendChild(submitDate);
					
					let resolveDate = document.createElement("TD");
					if(sw[i].reim_resolved){
					resolveDate.innerHTML = sw[i].reim_resolved;
					pendingAccounts.appendChild(resolveDate);
					}
					if(!(sw[i].reim_resolved)){

						resolveDate.innerHTML = "  ";
						pendingAccounts.appendChild(resolveDate);
					}
					
					let resolver = document.createElement("TD");
					if(sw[i].reim_resolver==55){
						resolver.innerHTML = sw[i].reim_resolver;
						resolver.innerHTML = "Resolved by: " + "Trevin Chester";
					
					pendingAccounts.appendChild(resolver);
					}
				
				document.getElementById("reimbursements").appendChild(pendingAccounts);
				
			}
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'reimbursement.json');
	//this begins the request process
	xhttp.send(); //optional string argument
				// used with http methods other than GET

}

function welcomeMessage(name, lastName){
	let message = "Access Granted: ";
	return message + name + " " + lastName;
	
}

function returnMessage(){
	let mess = setTimeout(welcomeMessage, 5000);
	return mess;
}

function setValues(sw){
	document.getElementById("welcome").innerHTML = welcomeMessage(sw.userFirstName, sw.userLastName);
	document.getElementById("ManagerId").innerHTML = "Employee ID : " + sw.userId;
	document.getElementById("ManagerUserName").innerHTML = "User Name: " + sw.userName;
	document.getElementById("ManagerEmail").innerHTML = "Email Address: " + sw.userEmail
	if(sw.userRoleId == 2){
		getAllReimbursements();
		//console.log("this is where we are");
	}
	else if(sw.userRoleId == 1){
		getAllReimbursements();
	}
}



