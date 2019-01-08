
function a() {

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("HELLO");
			console.log(xhttp);

			let sw = JSON.parse(xhttp.responseText);

			setValues(sw);

			sortTableAddEvent();

		}
	}
	// server connectivity data
	xhttp.open("POST", 'viewReimbursement.json', true);

	xhttp.send();

}

function setValues(sw) {
	console.log("HI");
	for (let i = 0; i < sw.length; i++) {
		let currTR = document.createElement("TR");
		let currID = document.createElement("TD");
		let currAmount = document.createElement("TD");
		let currSubmitted = document.createElement("TD");
		let currResolved = document.createElement("TD");
		let currDescription = document.createElement("TD");
		let currAuthor = document.createElement("TD");
		let currResolver = document.createElement("TD");
		let currStatusId = document.createElement("TD");
		let currTypeId = document.createElement("TD");
		currID.innerHTML = sw[i].remb_Id;
		currTR.appendChild(currID);
		currAmount.innerHTML = sw[i].remb_Amount;
		currTR.appendChild(currAmount);
		currSubmitted.innerHTML = sw[i].remb_Submitted;
		currTR.appendChild(currSubmitted);
		currResolved.innerHTML = sw[i].remb_Resolved;
		currTR.appendChild(currResolved);
		currDescription.innerHTML = sw[i].remb_Description;
		currTR.appendChild(currDescription);
		currAuthor.innerHTML = sw[i].remb_Author;
		currTR.appendChild(currAuthor);
		currResolver.innerHTML = sw[i].remb_Resolver;
		currTR.appendChild(currResolver);

		if (sw[i].remb_Status_Id == '3') {
			var td = document.createElement("td");
			var approveForm = document.createElement("Form");
			approveForm.setAttribute('method', 'post');
			approveForm.setAttribute('action',
					'updateapprovedReimbursement.ERSServlet');
			approveForm.setAttribute('reimburseId', sw[i].remb_Id);
			var inputId = document.createElement("input");
			inputId.setAttribute('name', 'reimburseId');
			inputId.setAttribute('value', sw[i].remb_Id);
			inputId.setAttribute('type', 'hidden');
			var sub = document.createElement("Button");
			sub.setAttribute('type', 'submit');
			sub.textContent = 'Approve';
			approveForm.appendChild(inputId);
			approveForm.appendChild(sub);
			/*currStatusId.innerHTML = currTR;*/
			currStatusId.appendChild(approveForm);
			/*currTR.appendChild(approveForm);*/
			currTR.appendChild(currStatusId);
			console.log(approveForm);

			var declineForm = document.createElement("Form");
			declineForm.setAttribute('method', 'post');
			declineForm.setAttribute('action',
					'updatedeclinedReimbursement.ERSServlet');
			declineForm.setAttribute('reimburseId', sw[i].remb_Id);
			var inputIda = document.createElement("input");
			inputIda.setAttribute('name', 'reimburseId');
			inputIda.setAttribute('value', sw[i].remb_Id);
			inputIda.setAttribute('type', 'hidden');
			var sub = document.createElement("Button");
			sub.setAttribute('type', 'submit');
			sub.textContent = 'Declined';
			declineForm.appendChild(inputIda);
			declineForm.appendChild(sub);
			/*currStatusId.innerHTML = currTR;*/
			currStatusId.appendChild(declineForm);
			/*currTR.appendChild(approveForm);*/
			/*currTR.appendChild(currStatusId);*/
			console.log(approveForm);

		} else {
			currStatusId.innerHTML = sw[i].remb_Status_Id;
			currTR.appendChild(currStatusId);
		}

		currTypeId.innerHTML = sw[i].remb_Type_Id;
		currTR.appendChild(currTypeId);
		document.getElementById("reimbursements").appendChild(currTR);
	}
}

function sortTableAddEvent() {

	statusFilters = document.getElementsByName("statusFilter");
	for (var i = 0; i < statusFilters.length; i++) {
		console.log('a');
		statusFilters[i].addEventListener("click", function() {
			sortTable();
		});
		console.log('a');
	}

}
function sortTable() {

	var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	table = document.getElementById("reimbursements");
	switching = true;
	//Set the sorting direction to ascending:
	dir = "asc";
	/*Make a loop that will continue until
	no switching has been done:*/
	while (switching) {
		//start by saying: no switching is done:
		switching = false;
		rows = table.rows;
		/*rows = table.getElementsByTagName("tr");*/
		console.log(rows);
		console.log(rows.length);
		/*Loop through all table rows (except the
		first, which contains table headers):*/
		var selected = document.getElementsByName("statusFilter");
		var selectedF;
		for (var i = 0; i < selected.length; i++) {
			if (selected[i].checked == true) {
				selectedF = selected[i].value;
			}
		}

		for (let i = 0; i < rows.length; i++) {
			console.log('a');
			console.log(rows[i]);
			console.log(selectedF);

			if (selectedF == "All") {
				rows[i].style.visibility = 'visible';
			} else if (selectedF == "Approved") {
				console.log(rows[i].getElementsByTagName("td")[7]);
				if (rows[i].getElementsByTagName("td")[7].textContent == "1") {
					console.log('1');
					rows[i].style.visibility = 'visible';
				} else {
					rows[i].style.visibility = 'hidden';
				}
			} else if (selectedF == "Declined") {
				console.log(rows[i].getElementsByTagName("td")[7]);
				if (rows[i].getElementsByTagName("td")[7].textContent == "2") {
					console.log('2');
					rows[i].style.visibility = 'visible';
				} else {
					rows[i].style.visibility = 'hidden';
				}
			} else if (selectedF == "Pending") {
				console.log(rows[i][7]);
				console.log(rows[i].getElementsByTagName("td")[7]);
				console
						.log(rows[i].getElementsByTagName("td")[7].childNodes[0].childNodes[0]);
				if (rows[i].getElementsByTagName("td")[7].textContent != "2"
						&& rows[i].getElementsByTagName("td")[7].textContent != "1") {
					console.log('3');
					rows[i].style.visibility = 'visible';
				} else {
					rows[i].style.visibility = 'hidden';
				}
			}

		}

	}
}
// calling the function created
a();
