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

(function getReimbTable() {
	var xhr = new XMLHttpRequest();
	let myData;
	xhr.open('POST', "/MyERSProject/getAllReimbursements.json", true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var data = xhr.responseText;
			myData = JSON.parse(data);
			console.log("Reimbursements: "+myData);
			populateReimbTable(myData);
		}
		//populateReimbTable(myData);
	}
	
	xhr.send();
	console.log(xhr)
}());

function myFunction() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("status");
	  console.log(input);
	  filter = input.value.toUpperCase();
	  console.log(filter);
	  table = document.getElementById("reimbursements");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[7];
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


/*function approveAndDeny() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value;
	  table = document.getElementById("reimbursements");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      if (td.innerHTML.indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}*/

function setValues(sw){
	//document.getElementById("swName").innerHTML = sw.name;
//	swId.innerHTML = sw;
	//getReimbursements();
}

function selectStatus(reimbId){
	console.log("in select status")
	input = document.getElementById("chooser");
	filter = input.value;
	console.log("inside selectStatus: "+filter);
	console.log("REIMB ID: "+reimbId);
	params = '?statusId='+filter+'&reimbId='+reimbId;
	var xhr3 = new XMLHttpRequest();
	xhr3.open('POST', "/MyERSProject/updateReimbursement.json"+params, true);
	xhr3.onreadystatechange = function() {
		if(xhr3.readyState == 4 && xhr3.status==200){
			console.log("response received")
			location.assign("manager.html");
        }
	}
	xhr3.send();
	console.log(xhr3)
}


function populateReimbTable(reimbs) {
	console.log(reimbs);
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
			cell8.innerHTML = res;
		}*/
		//cell7.innerHTML = reimbs[reimb].resolver;
		
		
		if(reimbs[reimb].status==0) {				
			cell9.innerHTML =  
				`<form>
				<div class="form-group">
					<select name="chooser" id="chooser"class="form-control" oninput="selectStatus(`+cell0.innerHTML+`)" data-placeholder="update">
						<option value=0>Pending</option>
						<option value=1>Approved</option>
						<option value=2>Denied</option>
					</select>
				</div>
				</form>`;
			
					
	}
}
}




