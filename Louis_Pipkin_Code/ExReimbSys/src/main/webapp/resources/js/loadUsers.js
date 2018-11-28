(function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status==200){
			let user = JSON.parse(xhttp.responseText);
			console.log(user);
			//
			setValues(user);
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'userHome.json');
	
	xhttp.send();
	
	//console.log(xhttp);
})();

function setValues(user){
	console.log('in setvalues');
	console.log(user);
	//console.log(user['firstName']);
	if (user) {
		document.getElementById("disp-name").innerText = user['firstName'];
		document.getElementById("title-name").innerText = user['role'] + ': ' + user['firstName'];
	} else {
		document.getElementById("disp-name").innerText = 'NULL';
		document.getElementById("title-name").innerText = 'NULL' + ': ' + 'NULL';

	}
	getAllUsers();
}

function getAllUsers() {

	//let usId = document.getElementById('disp-name').value;
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			//let reimbs = JSON.parse(xhttp.responseText);
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			console.log("in users js logic");
			console.log(users);
			//let tmparr = [reimbs]
			//createReimbTable(reimbs);
			populateUserTable(users);
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'getUsers.json');
	
	xhttp.send();
	
	//console.log(xhttp);
}

function populateUserTable(users) {
	let utbody = document.getElementById('user-table-body');

	for (let user in users) {
		
		let newRow = utbody.insertRow(-1);

		
		let cell0 = newRow.insertCell(0);	// User ID
		let cell1 = newRow.insertCell(1);	// Username
		let cell2 = newRow.insertCell(2);	// Role
		let cell3 = newRow.insertCell(3);	// FirstName
		let cell4 = newRow.insertCell(4);	// LastName
		let cell5 = newRow.insertCell(5);	// Email
		
		cell0.innerHTML = users[user].usersId;
		cell1.innerHTML = users[user].username;
		cell2.innerHTML = users[user].role;
		cell3.innerHTML = users[user].firstName;
		cell4.innerHTML = users[user].lastName;
		cell5.innerHTML = users[user].email;

	}
}