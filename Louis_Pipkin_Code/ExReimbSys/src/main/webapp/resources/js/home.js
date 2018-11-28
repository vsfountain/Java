getUserInfo();
//getUserReimbs();

function getUserInfo() {

	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status==200){
			let user = JSON.parse(xhttp.responseText);
			console.log(user);
			//
			showUserInfo(user);
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'userHome.json');
	
	xhttp.send();
	
	//console.log(xhttp);
}

function getUserReimbs() {

	//let usId = document.getElementById('disp-name').value;
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			//let reimbs = JSON.parse(xhttp.responseText);
			console.log(xhttp.responseText);
			let reimbs = JSON.parse(xhttp.responseText);
			//console.log("in remibs js logic");
			//console.log(reimbs);
			//let tmparr = [reimbs]
			//createReimbTable(reimbs);
			populateReimbTable(reimbs);
		}
	}
	
	//create a connection
	//(http method, url, boolean asynch or not)
	xhttp.open("GET", 'reimbHome.json');
	
	xhttp.send();
	
	//console.log(xhttp);
}

function setValues(user){
	console.log('in set values func');
	//console.log(user);
	//console.log(user['firstName']);
	document.getElementById("disp-name").innerText = user['firstName'];
	document.getElementById("title-name").innerText = user['role'] + ': ' + user['firstName'];
	let uri = window.location.pathname;
	console.log('uri: '+uri);
	if (uri === '/ExReimbSys/resources/html/login.serf') {
		console.log('in here')
		if (user['role'] === 'Admin') {
			console.log('and here')
			//resources/html/viewUsers.html
			document.getElementById('all-reimb').href = '../../resources/html/viewAllReimb.html';
			document.getElementById('view-users').href = '../../resources/html/viewUsers.html';
		} else {
			
		}
	}
	getUserReimbs();
}

function showUserInfo(user) {
	document.getElementById("disp-name").innerText = user['firstName'];
	document.getElementById("title-name").innerText = user['role'] + ': ' + user['firstName'];
	
	console.log('in showUserInfo');
	console.log(user);
	document.getElementById('row-username').innerHTML = user['username'];
	document.getElementById('row-role').innerHTML = user['role'];
	document.getElementById('row-firstname').innerHTML = user['firstName'];
	document.getElementById('row-lastname').innerHTML = user['lastName'];
	document.getElementById('row-email').innerHTML = user['email'];
	
	//need to set nav links dynamically for after logout
	let uri = window.location.pathname;
	console.log('uri: '+uri);
	if (uri === '/ExReimbSys/resources/html/login.serf' ||
		uri === '/ExReimbSys/resources/html/adminHome.html' ||
		uri == '/ExReimbSys/resources/html/userHome.html') {
		console.log('in here')
		if (user['role'] === 'Admin') {
			console.log('and here')
			document.getElementById('all-reimb').href = '../../resources/html/viewAllReimb.html';
			document.getElementById('view-users').href = '../../resources/html/viewUsers.html';
		} else {
			document.getElementById('my-reimb').href = '../../resources/html/viewMyReimb.html';
			document.getElementById('sub-reimb').href = '../../resources/html/subReimb.html';
		}
	}
}
