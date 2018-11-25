window.onload = function() {
	getSW();
	getReimbTable();
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
			console.log(myUser);
			swId.innerHTML = myUser.firstName;
		}
	}
	
	xhttp.open('GET', 'http://localhost:11001/MyERSProject/me/manager.html');
	
	xhttp.send();

	console.log(xhttp);
}

$(function getReimbTable() {
	var xhr = new XMLHttpRequest();
	let myData;
	xhr.open('POST', "/MyERSProject/getAllReimbursements.json", true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var data = xhr.responseText;
			myData = JSON.parse(data);
			console.log("Reimbursements: "+myData);
		}
		populateReimbTable(myData);
	}
	
	xhr.send();
	console.log(xhr)
});

function myFunction() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("status");
	  filter = input.value;
	  table = document.getElementById("reimbursements");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[9];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}


function getReimbTableByStatus() {
	var xhr2 = new XMLHttpRequest();
	let myData;
	xhr2.open('POST', "/MyERSProject/getReimbursementsByStatus.json", true);
	xhr2.onreadystatechange = function() {
		if (xhr2.readyState == 4) {
			var data = xhr2.responseText;
			myData = JSON.parse(data);
			console.log("Reimbursements: "+myData);
		}
		populateReimbTable(myData);
	}
	
	xhr2.send();
	console.log(xhr2)
}

//making the list selection of reimbursement type work
var pStatus = document.getElementsByName('status');

for(let i = 0; i<pStatus.length; i++){
		pStatus[i].addEventListener('change', change);
}

function change(){
	for(let i=0; i<pStatus.length; i++){
		if(pStatus[i].selected == true){		
			getReimbsByStatus();
		}
	}
}

change();




/*
 * function getReimbursements() { //let swId = document.getElementById('role');
 * let xhttp = new XMLHttpRequest();
 * 
 * xhttp.onreadystatechange= function() { if(xhttp.readyState == 4){ let bubba =
 * xhttp.responseText; console.log("Response Text: "+bubba); let myReimbursement =
 * JSON.parse(bubba); populateReimbTable(myReimbursement); } }
 * 
 * xhttp.open('POST',
 * 'http://localhost:11001/MyERSProject/json/getAllReimbursements');
 * 
 * xhttp.send();
 * 
 * console.log(xhttp); }
 */


function setValues(sw){
	//document.getElementById("swName").innerHTML = sw.name;
//	swId.innerHTML = sw;
	//getReimbursements();
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
