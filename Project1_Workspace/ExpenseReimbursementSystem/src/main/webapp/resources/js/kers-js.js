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
	document.getElementById('tb-username').innerHTML = user.username;
	document.getElementById('tb-name').innerHTML = user.firstName + " " + user.lastName;
	document.getElementById('tb-email').innerHTML = user.email;
	document.getElementById('tb-role').innerHTML = user.role;
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
		cell6.innerHTML = '<a href="http://localhost:8080/ExpenseReimbursementSystem/image?id=' + list[i].id + '">...</a>';
		cell7.innerHTML = list[i].resolver;
		cell8.innerHTML = list[i].status;
		cell9.innerHTML = list[i].type;
		if (list[i].status == 'Pending') {
			cell10.innerHTML = '<input type="checkbox" name="selectedRow" value='
					+ list[i].id + '>';
		}
	}
}

/*
 * function sortTable(col) { console.log("SORTING " + col); var table =
 * document.getElementById("reimb-table"); var switching = true; // assume its
 * things need to be switched initially var direction = "asc"; // make the
 * direction ascending var shouldSwitch = false; var i = 0; var x = 0; var y =
 * 0; var rows = 0; var switchCount = 0;
 * 
 * while (switching) { console.log("WHILE SORTING"); switching = false; rows =
 * table.rows; console.log("rows: " + rows);
 * 
 * for (i = 1; i < (rows.length - 1); i++) { console.log("FOR LOOP: " + i);
 * shouldSwitch = false; x = rows[i].getElementsByTagName("TD")[col]; y = rows[i +
 * 1].getElementsByTagName("TD")[col];
 * 
 * if (direction == "asc") { if (x.innerHTML.toLowerCase() >
 * y.innerHTML.toUpperCase()) { console.log("DIRECTION ASC") shouldSwitch =
 * true; break; } } else if (direction == "desc") { if (x.innerHTML.toLowerCase <
 * y.innerHTML.toUpperCase()) { shouldSwitch = true; console.log("DIRECTION
 * DESC"); break; } } }
 * 
 * if (shouldSwitch) { console.log("should switch true: " + switchCount);
 * rows[i].parentNode.insertBefore(rows[i + 1], rows[i]); switching = true;
 * switchCount++; } else { if (switchCount == 0 && direction == "asc") {
 * direction = "desc"; switching = true; } } } }
 */

function sortTable(n) {
	var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	table = document.getElementById("reimb-table");
	switching = true;
	// Set the sorting direction to ascending:
	dir = "asc";
	/*
	 * Make a loop that will continue until no switching has been done:
	 */
	while (switching) {
		// Start by saying: no switching is done:
		switching = false;
		rows = table.rows;
		/*
		 * Loop through all table rows (except the first, which contains table
		 * headers):
		 */
		for (i = 1; i < (rows.length - 1); i++) {
			// Start by saying there should be no switching:
			shouldSwitch = false;
			/*
			 * Get the two elements you want to compare, one from current row
			 * and one from the next:
			 */
			x = rows[i].getElementsByTagName("TD")[n];
			y = rows[i + 1].getElementsByTagName("TD")[n];
			/*
			 * Check if the two rows should switch place, based on the
			 * direction, asc or desc:
			 */
			if (dir == "asc") {
				if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
					// If so, mark as a switch and break the loop:
					shouldSwitch = true;
					break;
				}
			} else if (dir == "desc") {
				if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
					// If so, mark as a switch and break the loop:
					shouldSwitch = true;
					break;
				}
			}
		}
		if (shouldSwitch) {
			/*
			 * If a switch has been marked, make the switch and mark that a
			 * switch has been done:
			 */
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			switching = true;
			// Each time a switch is done, increase this count by 1:
			switchcount++;
		} else {
			/*
			 * If no switching has been done AND the direction is "asc", set the
			 * direction to "desc" and run the while loop again.
			 */
			if (switchcount == 0 && dir == "asc") {
				dir = "desc";
				switching = true;
			}
		}
	}
}

function loadTableEmployee() {
	let table = document.getElementById("reimb-table");
	var temp1;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			let temp = xhr.responseText;
			
			temp1 = JSON.parse(temp);
			console.log(temp1);
			addTableEmployee(temp1, table);
		}
	}
	xhr
			.open(
					'GET',
					'http://localhost:8080/ExpenseReimbursementSystem/home/ownreimb.html',
					true);
	xhr.send();
}

function addTableEmployee(list, table) {
	for (i = 0; i < list.length; i++) {
		if (document.URL == 'http://localhost:8080/ExpenseReimbursementSystem/adminviewpending.html') {
			if (list[i].status == 'Pending') {
				let row = table.insertRow(table.rows.length);
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
				cell6.innerHTML = '<a href="http://localhost:8080/ExpenseReimbursementSystem/image?id=' + list[i].id + '">...</a>';
				cell7.innerHTML = list[i].resolver;
				cell8.innerHTML = list[i].status;
				cell9.innerHTML = list[i].type;
				if (list[i].status == 'Pending') {
					cell10.innerHTML = '<input type="checkbox" name="selectedRow" value='
							+ list[i].id + '>';
				}
			}
		} else {
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

			cell0.innerHTML = list[i].id;
			cell1.innerHTML = list[i].author;
			cell2.innerHTML = list[i].amount;
			cell3.innerHTML = list[i].submitted;
			cell4.innerHTML = list[i].resolved;
			cell5.innerHTML = list[i].description;
			cell6.innerHTML = '<a href="http://localhost:8080/ExpenseReimbursementSystem/image?id=' + list[i].id + '">...</a>';
			cell7.innerHTML = list[i].resolver;
			cell8.innerHTML = list[i].status;
			cell9.innerHTML = list[i].type;
			
		}
	}
}


function logout(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log("Logging out...");
			window.location.replace("index.html");
		}
	}
	xhr.open('POST', 'logout.kers', true);
	xhr.send();
}

/*
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
*/
