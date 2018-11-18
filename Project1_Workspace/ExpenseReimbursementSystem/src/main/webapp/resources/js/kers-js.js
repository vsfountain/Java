getUser();

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
	
	xhr.open('GET', 'MasterServlet', true);
	xhr.send();
}

function promiseUser(userk){
	let user = userk;
	console.log("USER: " + user);

	let usernameSpan = document.getElementById('username-id');
	console.log('usernamespan: ' + usernameSpan.innerHTML);
	usernameSpan.innerHTML = user.firstName + " " + user.lastName;
}
