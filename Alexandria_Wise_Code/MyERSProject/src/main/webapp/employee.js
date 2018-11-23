window.onload = function() {
	getSW();
}

function getSW() {
	let swId = document.getElementById('role');
	
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange= function() {
		
		if(xhttp.readyState == 4){
			let temp = xhttp.responseText;
			console.log("Response Text: " + temp);
			myUser = JSON.parse(temp);
			console.log("MyUser: " + myUser);
			swId.innerHTML = myUser.firstName;
			getMyReimbursements();

		}
	}
	
	xhttp.open('GET', 'http://localhost:11001/MyERSProject/me/employee.html');
	
	xhttp.send();

	console.log(xhttp);
}

function getMyReimbursements() {
	//let swId = document.getElementById('role');
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange= function() {
		if(xhttp.readyState == 4){
			let bubba = xhttp.responseText;
			console.log("Response Text: "+bubba);
			let myReimbursement = JSON.parse(bubba);
			populateReimbTable(myReimbursement);
		}
	}
	
	xhttp.open('POST', 'http://localhost:11001/MyERSProject/json/getReimbursementsById');
	
	xhttp.send();

	console.log(xhttp);
}


function setValues(sw){
	getMyReimbursements();
}



function populateReimbTable(reimbs) {
	let rtbody = document.getElementById('reimbursements');	
	for (let reimb in reimbs) {
		
		let newRow = rtbody.insertRow(-1);
		
		let cell0 = newRow.insertCell(0);	// #
		let cell1 = newRow.insertCell(1);	// Author
		let cell2 = newRow.insertCell(2);	// Status
		let cell3 = newRow.insertCell(3);	// Submitted
		let cell4 = newRow.insertCell(4);	// Type
		let cell5 = newRow.insertCell(5);	// Amount
		let cell6 = newRow.insertCell(6);	// Description
		let cell7 = newRow.insertCell(7);	// Receipt
		let cell8 = newRow.insertCell(8);	// Resolved
		let cell9 = newRow.insertCell(9);	// Resolver
		
		//let sub = new Date(reimbs[reimb].reqTme);
		//let res = new Date(reimbs[reimb].resTime);
		
		cell0.innerHTML = reimbs[reimb].rId;
		cell1.innerHTML = reimbs[reimb].amount;
		cell2.innerHTML = reimbs[reimb].reqTime;
		cell3.innerHTML = reimbs[reimb].resTime;
		cell4.innerHTML = reimbs[reimb].description;
		//cell5.innerHTML = ;
		cell6.innerHTML = reimbs[reimb].author;
		cell7.innerHTML = reimbs[reimb].resolver;
		cell8.innerHTML = reimbs[reimb].status;
		cell9.innerHTML = reimbs[reimb].type;
		if (reimbs[reimb].resolved) {
			cell8.innerHTML = res;
		}
		cell7.innerHTML = reimbs[reimb].resolver;
	}
}






