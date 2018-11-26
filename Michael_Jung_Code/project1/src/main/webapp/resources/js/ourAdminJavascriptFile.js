/**
 * 
 */
var obj;

function loadRecords() {
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			document.getElementsByTagName("tbody")[1].removeChild(document.getElementsByTagName("tbody")[1].childNodes[0]);
			document.getElementsByTagName("tbody")[1].removeChild(document.getElementsByTagName("tbody")[1].childNodes[0]);
			
			
			/*document.getElementById("1").setAttribute("style", "padding-bottom:29px;padding-top:0;padding-left:0;padding-right:0");*/
			document.getElementById("2").setAttribute("style", "padding-bottom:29px;padding-top:0;padding-left:0;padding-right:0");
			document.getElementById("3").setAttribute("style", "padding-bottom:29px;padding-top:0;padding-left:0;padding-right:0");
			
			
			
			console.log(document.getElementsByTagName("tbody")[1].childNodes);
			var arr = JSON.parse(this.responseText);
			if(arr.length != 0) {
				document.getElementById("1").setAttribute("style", "padding-bottom:29px;padding-top:0;padding-left:0;padding-right:0");
			}
			obj = arr;
			loadRecordsA(arr);
			
		}
		
	}
	
	
	
	
	xhttp.open("GET", "http://localhost:9001/Project1/adminHomeLandingPage/reimbursements.json.servletThree", true);
	xhttp.send();
	
	
	
}






function loadRecordsA(arr) {
	arr.sort(function(a, b) {
		return b.reimbursementId - (a.reimbursementId);
	});
	var options = { year: 'numeric', month: 'long', day: 'numeric', hour:'numeric', minute:'numeric', formatMatcher:'basic' };
	var table = document.getElementsByTagName("tbody")[0];
	if(arr.length == 0) {
		var row = document.createElement("tr");
		var value = document.createElement("td");
		value.setAttribute("colspan", "9");
		value.setAttribute("style", "text-align:center;");
		var valuee = document.createElement("i");
		valuee.setAttribute("style", "font-size:12px;opacity:.5;");
		valuee.textContent = "You have no available Reimbursements";
		value.appendChild(valuee);
		row.appendChild(value);
		table.appendChild(row);
		
	}
	
	
	for(var i = 0; i<arr.length; i++) {
		console.log(arr);
		var row = document.createElement("tr");
		for(var j = 0; j < 9; j++) {
			var value = document.createElement("td");
			if(j == 0) {
				value = document.createElement("th");
				value.setAttribute("scope","row");
				value.textContent = arr[i].reimbursementId;
			} else if(j == 1) {
				value.textContent = arr[i].reimbursementType;
			} else if (j == 2) {
				value.textContent = Number(arr[i].reimbursementAmount).toFixed(2);
			} else if (j == 3) {
				value.textContent = arr[i].ersReimbursementUser.username;
			} else if (j == 4) {
				value.textContent = new Date(arr[i].reimbursementSubmittedDate).toLocaleDateString("en-US", options);
			} else if (j == 5) {
				value.textContent = arr[i].reimbursementDescription;
			} else if (j == 6) {
				if(arr[i].reimbursementStatus == "Pending") {
					var approveButton = document.createElement("button");
					approveButton.setAttribute("type", "submit");
					approveButton.setAttribute("class", "btn btn-outline-primary");
					approveButton.textContent = "Approve";
					var approveButtonForm = document.createElement("form");
					approveButtonForm.setAttribute("method", "POST");
					approveButtonForm.setAttribute("action", "approve.servletTwo");
					approveButtonForm.appendChild(approveButton);
					value.appendChild(approveButtonForm);
					var approveButtonValue = document.createElement("input");
					approveButtonValue.setAttribute("name", "recordId");
					approveButtonValue.setAttribute("value", arr[i].reimbursementId);
					approveButtonValue.setAttribute("type", "hidden");
					approveButtonForm.appendChild(approveButtonValue);
					value.appendChild(document.createElement("br"));
					var declineButton = document.createElement("button");
					declineButton.setAttribute("type", "submit");
					declineButton.setAttribute("class", "btn btn-outline-primary");
					declineButton.textContent = "Decline";
					var declineButtonForm = document.createElement("form");
					declineButtonForm.setAttribute("method", "POST");
					declineButtonForm.setAttribute("action", "decline.servletTwo");
					declineButtonForm.appendChild(declineButton);
					value.appendChild(declineButtonForm);
					var declineButtonValue = document.createElement("input");
					declineButtonValue.setAttribute("name", "recordId");
					declineButtonValue.setAttribute("value", arr[i].reimbursementId);
					declineButtonValue.setAttribute("type", "hidden");
					declineButtonForm.appendChild(declineButtonValue);
				} else {
					value.textContent = arr[i].reimbursementStatus;
				}
			} else if (j == 7) {
				value.textContent = arr[i].reimbursementResolver ? arr[i].reimbursementResolver.username : null;
			} else if (j == 8) {
				value.textContent = arr[i].reimbursementResolvedDate ? new Date(arr[i].reimbursementResolvedDate).toLocaleDateString("en-US", options) : null;
			} 
			row.appendChild(value);
			
		}
		table.appendChild(row);
		
	}
	
}

loadRecords();



function filterStatusEvent() {
	
	var filterElements = document.getElementsByName("statusFilter");
	for(var i = 0; i< filterElements.length; i++) {
		
		filterElements[i].addEventListener("change", function(){
			performFilter(filterElements);
			
		});
		
		
	}
	
	
	
}


function performFilter(filterElements) {
	/*console.log('asldk');*/
	for(var j = 0; j<filterElements.length; j++) {
		
		if(filterElements[j].checked) {
			
			performFilterF(filterElements[j].value);
			
		}
		
		
	}
	
	
}

function performFilterF(value) {
	
	if(value == 'All') {
		var records = document.getElementsByTagName("tr");
		console.log(records);
		for(var i = 2; i<records.length; i++) {
			var recor = records[i];
			/*recor.style.display = '';*/
			console.log(recor.style.display);
			if(recor.style.display == "none") {
				/*recor.style.display = "visible";*/
				recor.style.display = '';
			}
		}
	}else if(value == 'Pending'){
	
		var records = document.getElementsByTagName("tr");
		for(var i = 3; i<records.length; i++) {
			var recor = records[i];
			if(recor.childNodes[6].childNodes.length == 3) {
				if(recor.style.display == "none") {
					/*recor.style.display = "visible";*/
					recor.style.display = '';
				}
			} else {
				recor.style.display = "none";
			}
			/*console.log(records[i].childNodes[6]);*/
			/*var recor = records[i][];*/


		}
	} else {
		var records = document.getElementsByTagName("tr");
		console.log(records);
		for(var i = 3; i<records.length; i++) {
			var recor = records[i];
			console.log(recor);
			if(recor.childNodes[6].textContent == value) {
				if(recor.style.display == "none") {
					/*recor.style.display = "visible";*/
					recor.style.display = '';
				}
			} else {
				recor.style.display = "none";
			}
		}
	}
}

filterStatusEvent();

