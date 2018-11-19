function getUser() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let a = xhr.responseText;
			console.log(a);
			var userk = JSON.parse(a);
			console.log(userk);
			promiseUser(userk);
		}

	}

	xhr.open('GET',
			'http://localhost:8080/ExpenseReimbursementSystem/home/home.html',
			true);
	xhr.send();
}

function promiseUser(userk) {
	let user = userk;
	console.log("USER: " + user);

	let usernameSpan = document.getElementById('username-id');
	console.log('usernamespan: ' + usernameSpan.innerHTML);
	usernameSpan.innerHTML = user.firstName + " " + user.lastName;
}

function loadTable() {
	let table = document.getElementById("reimb-table");
	var temp1;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let temp = xhr.responseText;
			// console.log(temp);
			temp1 = JSON.parse(temp);
			addTable(temp1, table);

		}
	}
	xhr
			.open(
					'GET',
					'http://localhost:8080/ExpenseReimbursementSystem/home/ownreimb.html',
					true);
	xhr.send();
}

function addTable(list, table) {
	for (i = 0; i < list.length; i++) {

		let checkbox = document.createElement("A");
		checkbox.type = "checkbox";
		let row = table.insertRow(i + 1);
		let cell0 = row.insertCell(0);
		let cell1 = row.insertCell(1);
		let cell2 = row.insertCell(2);
		let cell3 = row.insertCell(3);
		let cell4 = row.insertCell(4);
		let cell5 = row.insertCell(5);
		let cell6 = row.insertCell(6);
		let cell7 = row.insertCell(7);
		let cell8 = row.insertCell(8);
		let cell9 = row.insertCell(9);
		let cell10 = row.insertCell(10);

		cell0.innerHTML = list[i].id;
		cell1.innerHTML = list[i].author;
		cell2.innerHTML = list[i].amount;
		cell3.innerHTML = list[i].submitted;
		cell4.innerHTML = list[i].resolved;
		cell5.innerHTML = list[i].description;
		cell6.innerHTML = list[i].receipt;
		cell7.innerHTML = list[i].resolver;
		cell8.innerHTML = list[i].status;
		cell9.innerHTML = list[i].type;
		if (list[i].status == 'Pending') {
			cell10.innerHTML = '<input type="checkbox" name="selectedRow" value='
					+ list[i].id + '>';
		}
	}

}
