window.onload = function() {
	getSW();
	getReimbTable();
}
/*document.getElementById("newReimButton").addEventListener("click", function(event){
    event.preventDefault();
    addReimb();
});*/

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
		}
	}
	
	xhttp.open('GET', 'http://localhost:11001/MyERSProject/me/employee.html');
	
	xhttp.send();

	console.log(xhttp);
}

function getReimbTable() {
	var xhr = new XMLHttpRequest();
	let myData;
	xhr.open('POST', 'http://localhost:11001/MyERSProject/getReimbursementsById.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var data = xhr.responseText;
			console.log("DATA: "+data);
			myData = JSON.parse(data);
			console.log("Reimbursements: "+myData);
		}
		populateReimbTable(myData);
	}
	
	
	xhr.send();
	console.log(xhr)
}

/*function addReimb() {
	let amt = document.forms["newReimbForm"]["amount"].value;
	let type = document.forms["newReimbForm"]["type"].value;
	let desc = document.forms["newReimbForm"]["desc"].value;
	params = '?amount='+amt+'&type='+type+'&desc='+desc;
	console.log(params);
	var xx = new XMLHttpRequest();
	let myData;
	xx.open('POST', 'http://localhost:11001/MyERSProject/createReimbursement.json'+params, true);
	xx.onreadystatechange = function() {
		if (xx.readyState == 4 && xx.status ==200) {
			window.location.href = "employee.html";
			//getReimbTable();		
		}
	}	
	xx.send();
	console.log(xx);
}*/

/*function getMyReimbursements() {
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
}*/


function setValues(sw){
	//getMyReimbursements();
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
		
		cell5.innerHTML = reimbs[reimb].author;
		cell6.innerHTML = reimbs[reimb].resolver;
		if(reimbs[reimb].status==0){
			cell7.innerHTML = "Pending";
		}else if(reimbs[reimb].status==1){
			cell7.innerHTML = "Approved";
		}else {
			cell7.innerHTML = "Denied";
		}
		
		if(reimbs[reimb].type==0){
			cell8.innerHTML = "Lodging";
		} else if(reimbs[reimb].type==1){
			cell8.innerHTML = "Travel";
		}else if(reimbs[reimb].type==2){
			cell8.innerHTML = "Food";
		} else {
			cell8.innerHTML = "Other";
		}

		//cell7.innerHTML = reimbs[reimb].status;
		//cell8.innerHTML = reimbs[reimb].type;
		/*if (reimbs[reimb].resolved) {
			cell9.innerHTML = res;
		}*/
	}
}




/*window.onload = function() {
	getSW();
	getReimbTable();
}
document.getElementById("newReimButton").addEventListener("click", function(event){
    event.preventDefault();
    addReimb();
});

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
		}
	}
	
	xhttp.open('GET', 'http://localhost:11001/MyERSProject/me/employee.html');
	
	xhttp.send();

	console.log(xhttp);
}

function getReimbTable() {
	var xhr = new XMLHttpRequest();
	let myData;
	xhr.open('POST', 'http://localhost:11001/MyERSProject/getReimbursementsById.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var data = xhr.responseText;
			console.log("DATA: "+data);
			myData = JSON.parse(data);
			console.log("Reimbursements: "+myData);
		}
		populateReimbTable(myData);
	}
	
	
	xhr.send();
	console.log(xhr)
}

function addReimb() {
	let amt = document.forms["newReimbForm"]["amount"].value;
	let type = document.forms["newReimbForm"]["type"].value;
	let desc = document.forms["newReimbForm"]["desc"].value;
	params = '?amount='+amt+'&type='+type+'&desc='+desc;
	console.log(params);
	var xx = new XMLHttpRequest();
	let myData;
	xx.open('POST', 'http://localhost:11001/MyERSProject/createReimbursement.json'+params, true);
	xx.onreadystatechange = function() {
		if (xx.readyState == 4 && xx.status ==200) {
			window.location.href = "employee.html";
			//getReimbTable();		
		}
	}	
	xx.send();
	console.log(xx);
}




function setValues(sw){
	//getMyReimbursements();
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
		//let cell10 = newRow.insertCell(10);
		
		//let sub = new Date(reimbs[reimb].reqTme);
		//let res = new Date(reimbs[reimb].resTime);
		
		cell0.innerHTML = reimbs[reimb].rId;
		cell1.innerHTML = reimbs[reimb].amount;
		cell2.innerHTML = reimbs[reimb].reqTime;
		cell3.innerHTML = reimbs[reimb].resTime;
		cell4.innerHTML = reimbs[reimb].description;
		
		cell5.innerHTML = reimbs[reimb].author;
		cell6.innerHTML = reimbs[reimb].resolver;
		
		if(reimbs[reimb].status==0){
			cell7.innerHTML = "Pending"
		}else if(reimbs[reimb].status==1){
			cell7.innerHTML = "Approved"
		}else {
			cell7.innerHTML = "Denied"
		}
		
		if(reimbs[reimb].type==0){
			cell8.innerHTML = "Lodging";
		} else if(reimbs[reimb].type==1){
			cell8.innerHTML = "Travel";
		}else if(reimbs[reimb].type==2){
			cell8.innerHTML = "Food";
		} else {
			cell8.innerHTML = "Other";
		}
				
	}
}

*/



