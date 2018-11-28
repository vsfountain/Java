/**
 * 
 */
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

function getUserReimbursements(){
	//pass in an ID
	
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
					
					let Approve = document.createElement("TD");
					let ApprovedBtn = document.createElement("button");
					let DenyBtn = document.createElement("button");
					ApprovedBtn.className="btn btn-success";
					DenyBtn.className ="btn btn-danger";
					if(sw[i].reim_status == 1){
					ApprovedBtn.innerHTML = "Approve";
					ApprovedBtn.onclick =  function() 
						{
						console.log("we are in the onClick");
							let reim_id = sw[i].reim_id;
							let params = 'reim_id='+reim_id;
							console.log(params);
							let xhttp2 = new XMLHttpRequest();
							xhttp2.onreadystatechange = function(){
							if(xhttp2.readyState == 4 && xhttp2.status==200){
								console.log("response received")
								location.assign("managerhome.serv");
							}}
							xhttp2.open('GET', 'approve.serv?'+ params);
							//this begins the request process
							xhttp2.send();
		                
						}
					
					
					
					DenyBtn.innerHTML = "Deny";
					Approve.appendChild(ApprovedBtn);
					Approve.appendChild(DenyBtn);
					DenyBtn.onclick =  function() 
					{
					console.log("we are in the onClick");
						let reim_id = sw[i].reim_id;
						let params = 'reim_id='+reim_id;
						console.log(params);
						let xhttp3 = new XMLHttpRequest();
						xhttp3.onreadystatechange = function(){
						if(xhttp3.readyState == 4 && xhttp3.status==200){
							console.log("response received")
							location.assign("managerhome.serv");
						}}
						xhttp3.open('GET', 'deny.serv?'+ params);
						//this begins the request process
						xhttp3.send();
	                
					}
					pendingAccounts.appendChild(Approve)
					
					}
					
					if(sw[i].reim_status == 2){
						Approve.innerHTML = "Approval submitted";
						pendingAccounts.appendChild(Approve);
					
					}
					
					if(sw[i].reim_status == 3){
						Approve.innerHTML = "Rejection submitted";
						pendingAccounts.appendChild(Approve);
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
	return message + name + " " + lastName + "\n";
	
}

function returnMessage(){
	let mess = setTimeout(welcomeMessage, 5000);
	return mess;
}

function setValues(sw){
	document.getElementById("welcome").innerHTML = welcomeMessage(sw.userFirstName, sw.userLastName);
	document.getElementById("ManagerId").innerHTML = "Manager ID : " + sw.userId;
	document.getElementById("ManagerUserName").innerHTML = "User Name: " + sw.userName;
	document.getElementById("ManagerEmail").innerHTML = "Email Address: " + sw.userEmail
	
	console.log(sw);
	if(sw.userRoleId == 2){
		getAllReimbursements();
		//console.log("this is where we are");
	}
	else if(sw.userRoleId == 1){
		getAllReimbursements();
	}
}

//var collapse = document.getElementsByClassName("collapsible");
//var i;
//
//for (i = 0; i < collapse.length;i++){
//	collapse[i].addEventListener("click",
//	function(){
//		this.classList.toggle("active");
//		var content = this.nextElementSibling;
//		if(content.style.display === "block"){content.style.display = "none";}
//		else{content.style.display="block";}
//	});
//}

