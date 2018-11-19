/**
 * 
 */
window.onload = function () {
	console.log('in adminScreen');
	getUser();
	getAllReimburse()
}

function getUser() {
	console.log('in getAdmin');

	let uName = document.getElementById('user').value;


	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('Ready state: ' + xhttp.readyState);


			let sw = JSON.parse(xhttp.responseText);
			console.log(sw);
			showUser(sw);
		}
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


			let sw = JSON.parse(xhttp.responseText);

			showAllReimburse(sw);
			console.log(sw);
		}
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
			if (resolverId == 0) {}
			resolverId = "";
			let newRow = document.createElement("TR");
			let newHTML = "<td>" + userId + "</td>" +
				"<td id=\"rbid"+count+"\">" + reimbursId + "</td>" +
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