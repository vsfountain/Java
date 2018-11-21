/**
 * 
 */

console.log('in adminScreen');
getUser();
getAllReimburse();




function getUser() {
	console.log('in getAdmin');

	let uName = document.getElementById('user').value;


	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('Ready state: 22' + xhttp.readyState);


			let sw = JSON.parse(xhttp.responseText);



			showUser(sw);
		}
		console.log(xhttp.readyState, xhttp.status)
	};


	xhttp.open("get", '/ReimburseSys/getUser', true);

	xhttp.send();
}

function getAllReimburse() {
	console.log('inReimburse');
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('Ready state: ' + xhttp.readyState);

			console.log("JSON BEING CALLED", xhttp.responseText)
			let sw = JSON.parse(xhttp.responseText);

			showAllReimburse(sw);
			console.log(sw);
		}
		console.log(xhttp.readyState, xhttp.status)
	};
	xhttp.open("get", '/ReimburseSys/getAll', true);
	xhttp.send();
}



function showAllReimburse(json) {
	let table = document.getElementById("reimburseTable");
	let count = 0;
	for (let index in json) {
		console.log(json[index]);
		let userId = json[index].id;
		let reimbursements = json[index].reiburse;
		let usersName = json[index].firstName + " " + json[index].lastname;
		for (let reimburse in reimbursements) {
			let reimbursId = reimbursements[reimburse].id;
			let resolverId = reimbursements[reimburse].resolver.id
			let tsObj = reimbursements[reimburse].timeSubmitted;
			let timeSubmitted = tsObj.monthValue + "/" + tsObj.dayOfMonth + "/" + tsObj.year;
			let trObj = reimbursements[reimburse].timeResolved;
			let ammount = reimbursements[reimburse].ammount;
			let type = reimbursements[reimburse].type;
			let status = reimbursements[reimburse].status
			let recipit = reimbursements[reimburse].recipit;
			let desc = reimbursements[reimburse].description;
			if (!recipit) {
				recipit = '';
			}
			let timeResolved = ''
			if (!trObj) {
				timeResolved = '';
			} else {
				timeResolved = trObj.monthValue + "/" + trObj.dayOfMonth + "/" + trObj.year;
			}
			//console.log(desc, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
			if (!desc) {
				desc = '';
			}
			if (resolverId == 0) {
				resolverId = "";
			}
			let buttons = '';
			if (status == 'Pending') {
				buttons = "<td><div class=\"btn-group\" role=\"group\">" +
					"<button id=\"btnGroupDrop1\" type=\"button\" class=\"btn btn-secondary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">" +
					"Options" +
					"</button>" +
					"<div class=\"dropdown-menu\" aria-labelledby=\"btnGroupDrop1\">" +
					"<a class=\"dropdown-item\" onclick=\"approve(" + reimbursId + ")\">Approve</a>" +
					"<a class=\"dropdown-item\" onclick=\"deny(" + reimbursId + ")\">Deny</a>" +
					"</div>" +
					"</div></td>"
			} else {
				buttons = "<td></td>"
			}
			let newRow = document.createElement("TR");
			let newHTML =
				buttons +
				"<td>" + userId + "</td>" +
				"<td id=\"rbid" + count + "\">" + reimbursId + "</td>" +
				"<td>" + timeSubmitted + "</td>" +
				"<td>" + usersName + "</td>" +
				"<td>" + ammount + "</td>" +
				"<td>" + type + "</td>" +
				"<td>" + status + "</td>" +
				"<td>" + recipit + "</td>" +
				"<td>" + desc + "</td>" +
				"<td>" + resolverId + "</td>" +
				"<td>" + timeResolved + "</td>";
			count = count + 1;
			//console.log(newHTML);
			//console.log(newRow);
			newRow.innerHTML = newHTML
			table.appendChild(newRow);
		}


	}
}

function showUser(sw) {

	document.getElementById("user").innerHTML = "Hello " + sw.firstName + " " + sw.lastname;
}

function approve(columnId) {
	console.log("Approve: ", columnId);
	let params = "requestId=" + columnId;
	xhttp = new XMLHttpRequest();
	xhttp.open("POST", '/ReimburseSys/approve', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('Ready state: ' + xhttp.readyState);


		}
	};

	xhttp.send(params);
	location.reload(true)
}

function deny(columnId) {
	console.log("Deny: ", columnId);
	let params = "requestId=" + columnId;
	xhttp = new XMLHttpRequest();
	xhttp.open("POST", '/ReimburseSys/deny', true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('Ready state: ' + xhttp.readyState);


		}
	};

	xhttp.send(params);
	location.reload(true)
}