/*(function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status==200){
			let user = JSON.parse(xhttp.responseText);
			console.log(user);
			document.getElementById("disp-name").innerText = user['firstName'];
			populateUserTable(user);
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'userHome.json');
	
	xhttp.send();
	
	//console.log(xhttp);
})();

function populateUserTable(user) {
	let utbody = document.getElementById('user-table-body');
	//let rtbody = document.getElementById('reimb-table').getElementsByTagName('tbody');
	
	for (let reimb in reimbs) {
		
		let newRow = rtbody.insertRow(-1);
		for (let data in reimb) {
			let newCell = newRow.insertCell(-1);
			let newText = document.createTextNode('example');
			newCell.appendChild(newText);
		}
		
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
		
		let sub = new Date(reimbs[reimb].submitted);
		let res = new Date(reimbs[reimb].resolved);
		
		cell0.innerHTML = reimbs[reimb].reimbId;
		cell1.innerHTML = reimbs[reimb].author;
		cell2.innerHTML = reimbs[reimb].status;
		cell3.innerHTML = sub;
		cell4.innerHTML = reimbs[reimb].type;
		cell5.innerHTML = reimbs[reimb].amount;
		cell6.innerHTML = reimbs[reimb].description;
		cell7.innerHTML = reimbs[reimb].receipt;
//		cell8.innerHTML = res;
		if (reimbs[reimb].resolved) {
			cell8.innerHTML = res;
		}
		cell9.innerHTML = reimbs[reimb].resolver;
	}
}*/