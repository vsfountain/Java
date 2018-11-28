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

function setValues(user) {
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
	
	//document.getElementById('sub-button').onclick = submitReimb();
	//document.getElementById('sub-form').onsubmit = submitReimb();
}

function submitReimb() {
	sform = document.getElementById("sub-form");
	console.log('in submitReimb');
	let amount = document.getElementById('amount').value;
	console.log(amount);
	let type = document.getElementById('category').value;
	console.log(type);
	let desc = document.getElementById('descrip').value;
	console.log(desc);
	
	
//	let xhttp = new XMLHttpRequest();
//	
//	xhttp.onreadystatechange = function(){
//		
//		if(xhttp.readyState == 4 && xhttp.status==200){
//			let user = JSON.parse(xhttp.responseText);
//			console.log(user);
//			document.getElementById("disp-name").innerText = user['firstName'];
//			populateUserTable(user);
//		}
//	}
//	
//	//create a connection
//	//(http method, url, boolean asynch or not)
//	xhttp.open("POST", 'subReimb.json');
//	
//	xhttp.send();
	
	
}