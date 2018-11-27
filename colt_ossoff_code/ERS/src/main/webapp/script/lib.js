
function userLogin() {
	console.log("in userLogin()");
	var prom = new Promise(function(resolve, reject) {
		let params = 'username=' + document.getElementById('exampleInputEmail1').value + '&password=' + document.getElementById('password').value;
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'login.ers');
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xhr.onload = function() {
			// This is called even on 404 etc
			// so check the status
			if (xhr.status == 200) {
				// Resolve the promise with the response text
				resolve(xhr.response);
			} else {
				// Otherwise reject with the status text
				// which will hopefully be a meaningful error
				reject(Error(xhr.statusText));
			}
		};
		// Handle network errors
		xhr.onerror = function() {
			reject(Error("Network Error"));
		};
		xhr.send(params);
	});

	prom.then(function(response) {
		let obj = JSON.parse(response);
		console.log(obj);
		sessionUser = obj;
		toAccordion(obj);
	}, function(error) {
		document.getElementById('user').innerHTML = 'Sorry we failed. TT';
		console.log(params);
	});
}

function allReimbs(){
	console.log("in ajax()");
	var prom = new Promise(function(resolve, reject) {
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'allreimb.json');
		xhr.onload = function() {
			// This is called even on 404 etc
			// so check the status
			if (xhr.status == 200) {
				// Resolve the promise with the response text
				resolve(xhr.response);
			} else {
				// Otherwise reject with the status text
				// which will hopefully be a meaningful error
				reject(Error(xhr.statusText));
			}
		};
		// Handle network errors
		xhr.onerror = function() {
			reject(Error("Network Error"));
		};
		xhr.send();
	});

	prom.then(function(response) {
		let obj = JSON.parse(response);
		console.log(obj);
	}, function(error) {
		document.getElementById('user').innerHTML = 'Sorry we failed. TT';
		console.log(error);
	});
}

function userReimbs(id){
	console.log("in ajax()");
	var prom = new Promise(function(resolve, reject) {
		var xhr = new XMLHttpRequest();
		xhr.open('POST', 'userreimb.json');
		xhr.onload = function() {
			// This is called even on 404 etc
			// so check the status
			if (xhr.status == 200) {
				// Resolve the promise with the response text
				resolve(xhr.response);
			} else {
				// Otherwise reject with the status text
				// which will hopefully be a meaningful error
				reject(Error(xhr.statusText));
			}
		};
		// Handle network errors
		xhr.onerror = function() {
			reject(Error("Network Error"));
		};
		xhr.send();
	});

	prom.then(function(response) {
		let obj = JSON.parse(response);
		console.log(obj);
		document.getElementById('user').innerHTML = response;
	}, function(error) {
		document.getElementById('user').innerHTML = 'Sorry we failed. TT';
		console.log(error);
	});
}

function reimbItem(reimb,role){
	let buttons = '';
	if(role == 'Admin' && reimb.status == 'Pending')
		buttons = '<td><button id="app-' + reimb.id + '" type="button" class="btn btn-success btn-sm">Approve</button><button id="den-' + reimb.id + '" type="button" class="btn btn-danger btn-sm">Deny</button></td>';
	
	let level = 'table-light';
	if (reimb.status == 'Approved')
		level = 'table-success';
	else if (reimb.status == 'Denied')
		level = 'table-danger';
	
	let block = '<tr class="' + level + '"><td>$' + 
	reimb.amount.toFixed(2) + 
	'<br><b>' + 
	reimb.type + 
	'</b></td><td>' + 
	reimb.author + 
	'</td><td>' + 
	reimb.submitted + '<br>' + reimb.resolved + 
	'</td><td>' + reimb.description + '</td>' + buttons + '</tr>';
	
	return block;
}

/*function createForm(){
	var strVar="";
	strVar += "<div  class=\"card\"> <div  class=\"card-header\" id=\"headingTwo\">  <h5  class=\"mb-0\"> <button  class=\"btn  btn-link collapsed\"  type=\"button\" data-toggle=\"collapse\"  data-target=\"#collapseTwo\"";
	strVar += "aria-expanded=\"false\"  aria-controls=\"collapseTwo\">   Create  New  Reimbursement  Ticket:   <\/button>  <\/h5>  <\/div>  <div   id=\"collapseTwo\"  class=\"collapse\"  aria-labelledby=\"headingTwo\"";
	strVar += "data-parent=\"#accordionExample\">  <div class=\"card-body\"  id=\"form_holder\">  <form action=\"\">  <div  class=\"form-group\">  <label for=\"amount\">Enter  Amount:  $<\/label> <input  type=\"number\"";
	strVar += "class=\"form-control\"  id=\"amount\"  placeholder=\"$0.00\"  min=\"0.01\"   max=\"5000\"  step=\"0.01\"  name=\"amount\">  <\/div>  <label  class=\"my-1   mr-2\"  for=\"type\">Expense  Type:<\/label>  <select";
	strVar += "class=\"custom-select   my-1    mr-sm-2\"   id=\"type\">    <option   selected>Choose...<\/option>   <option    value=\"FOOD\">Food<\/option>   <option    value=\"LODGING\">Lodging<\/option>   <option";
	strVar += "value=\"TRAVEL\">Travel<\/option> <option value=\"OTHER\">Other<\/option>  <\/select> <div class=\"input-group\"> <div  class=\"input-group-prepend\"> <span class=\"input-group-text\">Description<\/span>";
	strVar += "<\/div>  <textarea class=\"form-control\"  aria-label=\"With textarea\"  name=\"descr\"  maxlength=\"250\"><\/textarea> <\/div>  <div class=\"form-group\">  <label  for=\"receipt\">Upload a  Copy of  Your";
	strVar += "Receipt:<\/label> <input type=\"file\"  class=\"form-control-file\" id=\"receipt\" name=\"receipt\"> <\/div>  <button type=\"submit\" class=\"btn btn-primary my-1\">Submit<\/button>  <\/form> <\/div> <\/div>";
	strVar += "<\/div>";
	return strVal;
}*/

function toAccordian(user){
	document.getElementById('content').class += '-10';
	document.getElementById('login').style.display = 'none';
	document.getElementById('accordionExample').style.display = 'block';
	//var strVar="";
	//strVar += "<div   class=\"accordion\"  id=\"accordionExample\">   <div  class=\"card\">   <div   class=\"card-header\"  id=\"headingOne\">   <h5   class=\"mb-0\">  <button   class=\"btn  btn-link\"   type=\"button\"";
	//strVar += "data-toggle=\"collapse\" data-target=\"#collapseOne\"  aria-expanded=\"true\" aria-controls=\"collapseOne\">  Account Details:  <\/button> <\/h5> <\/div>  <div id=\"collapseOne\"  class=\"collapse show\"";
	//strVar += "aria-labelledby=\"headingOne\" data-parent=\"#accordionExample\"> <div class=\"card-body\"> <table class=\"table\"> <thead>  <tr> <th scope=\"col\">First Name<\/th> <th scope=\"col\">Last Name<\/th> <th";
	//strVar += "scope=\"col\">Username<\/th>   <th   scope=\"col\">Email<\/th>   <th   scope=\"col\">Role<\/th>   <\/tr>   <\/thead>   <tbody>   <tr>   <td   id=\"fname\">Colt<\/td>   <td   id=\"lname\">Ossoff<\/td>   <td";
	//strVar += "id=\"uname\">coltossoff<\/td> <td  id=\"email\">coltossoff@gmail.com<\/td> <td id=\"role\">Employee<\/td> <\/tr>  <\/tbody> <\/table> <\/div>  <\/div> <\/div> <div class=\"card\">  <div class=\"card-header\"";
	//strVar += "id=\"headingThree\">    <h5   class=\"mb-0\">    <button   class=\"btn    btn-link   collapsed\"    type=\"button\"   data-toggle=\"collapse\"    data-target=\"#collapseThree\"   aria-expanded=\"false\"";
	//strVar += "aria-controls=\"collapseThree\"> Current Reimbursements: <\/button> <\/h5> <\/div>  <div id=\"collapseThree\" class=\"collapse\" aria-labelledby=\"headingThree\" data-parent=\"#accordionExample\"> <div";
	//strVar += "class=\"card-body\"> <table  class=\"table table-sm table-hover\">  <thead> <tr class=\"table-light\"> <th  scope=\"col\">Amount\/<br>Type<\/th> <th scope=\"col\">Name<\/th>  <th scope=\"col\">Dates<\/th>";
	//strVar += "<th scope=\"col\">Description<\/th>  <\/tr> <\/thead> <tbody id=\"reimb_list\">  <tr class=\"table-success\"> <td>$120.00<br><b>FOOD<\/b><\/td> <td>Colt  Ossoff<\/td> <td>11-20-2018<br>11-21-2018<\/td>";
	//strVar += "<td colspan=\"2\">This covers  the office party's catering.<\/td>  <\/tr> <tr class=\"table-danger\"> <td>$10.43<br><b>FOOD<\/b><\/td> <td>Clement  Dikoko<\/td> <td>10-31-2018<br>11-5-2018<\/td> <td";
	//strVar += "colspan=\"2\">Lunch<\/td> <\/tr> <tr class=\"table-light\"> <td>$10.43<br><b>LODGING<\/b><\/td> <td>Clement Dikoko<\/td> <td>10-5-2018<br><\/td>  <td>The hotel bills from the business trip our sales";
	//strVar += "team took  to our client's convention.'<\/td>  <td> <button type=\"button\" class=\"btn  btn-success btn-sm\">Approve<\/button> <button type=\"button\"  class=\"btn btn-danger btn-sm\">Deny<\/button>";
	//strVar += "<\/td> <\/tr> <\/tbody> <\/table> <\/div> <\/div> <\/div> <\/div>";
	document.getElementById('content').innerHTML = strVar;
	document.getElementById('fname').innerHTML = user.firstname;
	document.getElementById('lname').innerHTML = user.lastname;
	document.getElementById('uname').innerHTML = user.username;
	document.getElementById('email').innerHTML = user.email;
	document.getElementById('role').innerHTML = user.role;
	if (user.role == 'Employee'){
		document.getElementById('accordionExample').children[0].after(createForm());
		userReimbs(user.id);
	} else {
		allReimbs();
	}
}
