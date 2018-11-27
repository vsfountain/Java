function getUser() {
	console.log('in getsw');

	
	


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

function getReimburse() {
	console.log('inReimburse');
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('Ready state: ' + xhttp.readyState);


			let sw = JSON.parse(xhttp.responseText);

			showReimburse(sw);
			console.log(sw);
		}
	};
	xhttp.open("get", '/ReimburseSys/getReimburse', true);
	xhttp.send();
}


function showUser(sw) {

	document.getElementById("user").innerHTML = "Hello " + sw.firstName + " " + sw.lastname;
}

function showReimburse(json) {
	let table = document.getElementById("reimburseTable");
	let body = document.createElement("TBODY")
	console.log("Making Body", body);
	body.id = "body"
	for (let index in json) {
		//console.log(json[index]);
		let id = json[index].id;
		let tsObj = json[index].timeSubmitted;;
		let timeSubmitted = tsObj.monthValue + "/" + tsObj.dayOfMonth + "/" + tsObj.year;
		let trObj = json[index].timeResolved;
		let ammount = json[index].ammount;
		let type = json[index].type;
		let status = json[index].status
		let recipit = json[index].recipit;
		let desc = json[index].description;
		if (!recipit) {
			recipit = '';
		}
		let timeResolved = ''
		if (!trObj) {
			timeResolved = '';
		} else {
			timeResolved = trObj.monthValue + "/" + trObj.dayOfMonth + "/" + trObj.year;;
		}
		//console.log(desc, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
		if (!desc) {
			desc = '';
		}
		let newRow = document.createElement("TR");
		let newHTML = "<td>" + id + "</td>" +
			"<td>" + timeSubmitted + "</td>" +
			"<td>" + timeResolved + "</td>" +
			"<td>" + ammount + "</td>" +
			"<td>" + type + "</td>" +
			"<td id=\"Status\">" + status + "</td>" +
			"<td>" + recipit + "</td>" +
			"<td>" + desc + "</td>";
		//console.log(newHTML);
		//console.log(newRow);
		newRow.innerHTML = newHTML
		body.appendChild(newRow);
	}
	table.appendChild(body);
}

function filter() {
	let input = document.getElementById("filterForm");
	let filter = input.getElementsByTagName("input");
	console.log("THE FILTER", filter)
	let filterBy;
	for (var i = 0; i < filter.length; i++) {
		if (filter[i].checked)
			filterBy = filter[i].value;
	}
	console.log(filter);
	let table = document.getElementById("reimburseTable");
	console.log("The table",table);
	let tr = table.getElementsByTagName("tr");

	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[5];
		console.log("thedata !",filterBy );
		if (td) {
			if (filterBy == "All" || td.innerHTML == filterBy) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}


console.log('in getsw1');
getUser();
getReimburse();