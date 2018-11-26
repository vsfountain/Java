//when page loads all HTML elements 
window.onload = function() {
	showReimbursements();
	getName();
	

}

function getName() {

	// getting name span
	let uId = document.getElementById('user');

	
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {

			let user = JSON.parse(xhttp.responseText);
			uId.innerHTML = " " + user.firstName + " " + user.lastName;
		}
	}

	
	xhttp.open("GET", 'http://localhost:9007/project1/info.user');

	// this begins the request process
	xhttp.send();

}

function showReimbursements() {

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let response = JSON.parse(xhttp.responseText);
			populateTable(response);

		}
	}

	xhttp.open("POST", 'http://localhost:9007/project1/show.reimb');
	xhttp.send();

}

function populateTable(json) {
	let reimbsTable = document.querySelector("#reimb-table > tbody");
	while (reimbsTable.firstChild) {
		reimbsTable.removeChild(reimbsTable.firstChild);
	}
	json.forEach((row) =>{
		let tr = document.createElement("tr");
		
		let author = document.createElement("td");
		author.textContent = row.reimbId;
		tr.appendChild(author);
		
		let type = document.createElement("td");
		switch(row.reimbTypeId){
		case 1:
			type.textContent = "Lodging";
			break;
		case 2:
			type.textContent = "Travel";
			break;
		case 3:
			type.textContent = "Food";
			break;
		default:
			type.textContent = "Other";
		}
		tr.appendChild(type);
		
		let desc = document.createElement("td");
		desc.textContent = row.reimDescription;
		tr.appendChild(desc);
		
		let amount = document.createElement("td");
		amount.textContent = "$"+row.reimbAmount;
		tr.appendChild(amount);
		
		let dateCreated = document.createElement("td");
		dateCreated.textContent = row.reimbSubmitted;
		tr.appendChild(dateCreated);
		
		let dateResolved = document.createElement("td");
		if(row.reimbResolved=="null"){
			dateResolved.textContent="";
		}
		else{
		dateResolved.textContent = row.reimbResolved;
		}
		tr.appendChild(dateResolved);		
		
		let status = document.createElement("td");
		switch(row.reimbStatusId){
		case 1:
			status.textContent = "Pending";
			break;
		case 2:
			status.textContent = "Approved";
			break;
		default:
			status.textContent = "Denied";
		}
		
		tr.appendChild(status);
		reimbsTable.appendChild(tr);
	})
}

function filterTable(){
	let filter = document.getElementById("filters").value;
	let table, tr, td, i;
	  table = document.getElementById("reimb-table");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[6];
	    if (td) {
	      if (td.textContent === filter || filter==="All") {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	
}
