
// This is to ensure that the forward facing screen is not abusable by anyone
function welcome(){
	ajaxLogout();
	document.title  = "Welcome!";
	document.getElementById('genius').innerHTML=`
	<a class="dropdown-item; nav-link" onclick =''
		style="color: #000; text-align: center; font-weight: bold"
		disabled>NEW </a>`;
	document.getElementById('neutron').innerHTML=`
	<a class="dropdown-item; nav-link" onclick=""
		style="color: #000; text-align: center; font-weight: bold"
		disabled>MY </a>`;
	document.getElementById('jimmy').innerHTML=`
	<a class="dropdown-item; nav-link" onclick=""
		style="color: #000; text-align: center; font-weight: bold"
		disabled>ALL </a>`;

	document.getElementById('cosmo').innerHTML = `
		<a class="nav-link"
						onclick="" id='johnny'>Home </a>`;
	
	document.getElementById('mary').innerHTML = `Ryker Industries`;
	document.getElementById('blingbling').innerHTML = `<br>`;
	document.getElementById('susan').innerHTML = `<h1 id = "dexter">
				Welcome to Ryker Industries! <br>
			</h1>
			<div id="dukey"></div>`;
	let dukey = document.getElementById('dukey');
	dukey.innerHTML = `
		<button class="btn btn-primary bn-lg" onclick="dispLogin()" type="button" style ='width: 120px; height: 60px; font-size:28pxe'>Login</button>`;
}

let JSONjohnny;
let jamesonAD;
let JSONrosie;
let asAdmin = false;

//This is to display a sort of loading screen
function openModal() {
    document.getElementById('deedee').style.display = 'block';
    document.getElementById('fade').style.display = 'block';
}
//This is to stop display of the loading screen
function closeModal() {
document.getElementById('deedee').style.display = 'none';
document.getElementById('fade').style.display = 'none';
}

//This is the AJAX caller that submits the login info to the servlet, enables the loading screen, and calls for the login manager
function ajaxLogin(){
	let username = document.forms["loginForm"]["username"].value;
	let password = document.forms["loginForm"]["password"].value;
	params = 'username='+username+'&password='+password;
	let susan = document.getElementById('susan');
	susan.innerHTML = `<div id='content'><div id="fade"></div><div id = 'deedee'><img id="loader" src="RykerSign.png" /></div></div>`;
	openModal();
	console.log(params);
	jamesonAD = '';
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	let a = xhttp.responseText;
			JSONjohnny = JSON.parse(a);
			console.log(JSONjohnny);
			if (JSONjohnny.username != undefined){
				document.getElementById('blingbling').innerHTML = `Login Successful!`;
			} else {
				document.getElementById('blingbling').innerHTML = `Bad Login`;
			}
			loginManager();
	    }
	};
	//Calls MasterServletJSON
	xhttp.open('POST', 'http://localhost:10054/RykerERS/json/login.ryker?'+params, true);
	xhttp.send();
}

// The login manager determines where the user who logged in should go based on their role.
function loginManager(){
	if (JSONjohnny.username != undefined){
		document.title  = "Employee Home!";
		document.getElementById('genius').innerHTML=`
			<a class="dropdown-item; nav-link" onclick ='displayNewReimbForm()'
			style="color: #000; text-align: center; font-weight: bold"
			disabled>NEW </a>`;
		document.getElementById('neutron').innerHTML=`
			<a class="dropdown-item; nav-link" onclick="employeeView()"
			style="color: #000; text-align: center; font-weight: bold"
			disabled>MY </a>`;
		document.getElementById('cosmo').innerHTML = `
			<a class="nav-link"
							onclick="displayHome()" id='johnny'>Home </a>`;
		if (JSONjohnny.role == "Admin") {
			document.title  = "Admin Home!";
			document.getElementById('jimmy').innerHTML=`
				<a class="dropdown-item; nav-link" onclick="adminView()"
				style="color: #000; text-align: center; font-weight: bold"
				disabled>ALL </a>`;
		}
		asAdmin = false;
		setTimeout(displayHome, 1000);
		//setTimeout(closeModal, 1000);
	} else {
		let susan = document.getElementById('susan');
		susan.innerHTML = `
			<h1>Login Unsuccessful. Please try again!</h1>`;
		setTimeout(welcome, 1000);
	}
}



function employeeView(){
	ajaxGetAll('employeeReimb.ryker');
}

function adminView(){
	ajaxGetAll('adminReimb.ryker');
}



function displayHome(){
	document.getElementById('johnny').innerHTML = `${JSONjohnny.role.toUpperCase()} Home`;
	document.getElementById('mary').innerHTML = `${JSONjohnny.firstName.toUpperCase()} ${JSONjohnny.lastName.toUpperCase()}`;
	document.getElementById('susan').innerHTML = `
		<h1>Welcome ${JSONjohnny.firstName} ${JSONjohnny.lastName}</h1>
		<br><br>
		<div class = "container" style= "border: 4px solid crimson; padding: 10px">
		<h3>Username:  ${JSONjohnny.username} </h3>
		<br><br>
		<h3>Role:  ${JSONjohnny.role} </h3>
		<br><br>
		<h3>Email:  ${JSONjohnny.email.toLowerCase()} </h3>
		</div>`;
}

function allowLoginSubmit(){
	let betty =document.getElementById('jerry');
	let a = document.forms["loginForm"]["username"].value;
	let b = document.forms["loginForm"]["password"].value;
	
	// This is to make sure the employee inputs all of the required information
	// before they can submit
	if (a != "" & b != "") {
		betty.disabled = false;
	} else {
		betty.disabled = true;
	}
}

function dispLogin(){
	document.title  = "Login!";
	document.getElementById('blingbling').innerHTML = `<br>`;
	let jimmy = document.getElementById('jimmy');
	let dukey = document.getElementById('dukey');
	dukey.innerHTML = `
		<h4>Please Login below with your employee credentials.</h4>
			<div class="container">
				<div class="row" style="margin: 25px;"></div>
				<div class="row">
					<div class="col-3"></div>
					<div class="col-6" style="border: 4px solid crimson; padding: 10px">
						<form class="needs-validation" method="post" name = "loginForm">
							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="exampleInputEmail1" style="text-align: left">Username</label> <input
										type="text" class="form-control" id="loginUsername"
										name="username" placeholder="Username" required autofocus>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="exampleInputPassword1" style="text-align: left">Password</label> <input
										type="password" class="form-control" id="loginPassword"
										name="password" placeholder="Password" required>
								</div>
							</div>
							<button id ="jerry" class="btn btn-primary" disabled>Submit</button>
						</form>
					</div>
					<div class="col-3"></div>
				</div>
			</div>
		</div>`
	document.getElementById('loginUsername').addEventListener('keyup', allowLoginSubmit);
	document.getElementById('loginPassword').addEventListener('keyup', allowLoginSubmit);
	document.getElementById('jerry').addEventListener('click', ajaxLogin);
}



function ajaxGetAll(ending) {
	if (ending === 'employeeReimb.ryker'){
		asAdmin = false;
	} else if (ending === 'adminReimb.ryker' && JSONjohnny.role === 'Admin'){
		asAdmin = true;
	}
	
	
	var oReq = new XMLHttpRequest();
	oReq.open("GET", "/myfile.png", true);
	oReq.responseType = "blob";

	oReq.onload = function(oEvent) {
	  var blob = oReq.response;
	  // ...
	};

	oReq.send();
	
	
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('AJAX - IN ADMIN GET ALL: '+xhttp.responseText);
			JSONrosie = JSON.parse(xhttp.responseText);
			if (JSONrosie.length >= 1){
				displayRosie();
			} else {
				console.log('error: reimbursement request failed')
			}
			
			var b = new Blob([JSON.stringify({"test": "toast"})], {type : "application/json"}),
			fr = new FileReader();

			fr.onload = function() {
			console.log(JSON.parse(this.result))
			};

			fr.readAsText(b);
			
			
			
			
		}
	}
	
	//Calls MasterServletJSON
	xhttp.open('POST', 'http://localhost:10054/RykerERS/json/'+ending, true);
	xhttp.send();
}


function ajaxApproveDeny(reimb_id, decision){
	let params = 'reimbid='+reimb_id+'&decision='+decision;
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('AJAX - IN APPROVE DENY: '+xhttp.responseText);
			document.getElementById('blingbling').innerHTML = `${xhttp.responseText}`;
			ajaxGetAll('adminReimb.ryker');
		}
	}
	//Calls MasterServletAction
	xhttp.open('POST', 'http://localhost:10054/RykerERS/action/updatereimbs.ryker'+'?'+params, true);
	xhttp.send();
}
	

function displayRosie(){
	let tableText;
	if (JSONjohnny.role == 'Admin' && asAdmin){
		tableText = 'ALL REIMBURSEMENTS';
	} else {
		tableText = 'YOUR REIMBURSEMENTS';
	}
	let BB = document.getElementById('blingbling');
	document.title  = tableText;
	BB.innerHTML = ``;
	let html = `<h1>${tableText}</h1><form method="POST" name = "adminApprove">
			<div class = "container" style="height:500px; max-width:90%; overflow-y:auto; border:4px solid crimson">
			<table class=" table table-hover table-responsive-sm">
			<thead>
				<tr style="opacity:1.0">
					<th scope="col" colspan='1'>ID#</th>
					<th scope="col" colspan='1'><span>Amount</span><br>
					<span>Type</span></th>
					<th scope="col" colspan='1'>Author</th>
					<th scope="col" colspan='3'><span>Submitted</span><br>
					<span>Resolved</span></th>
					<th scope="col" colspan='3' width='30%'>Description</th>
					<th scope="col" colspan='1'>Status</th>
					<th scope="col" colspan='1'>Resolver</th>
					<th scope="col" colspan='1'>Receipt</th>
				</tr>
			</thead>
			<tbody id = "reimbursement">`;
		let rosieDate;
		for (let i = 0; i < JSONrosie.length; i++) {
			if (JSONrosie[i].reimb_status == 'pending'){
				html+="<tr class='bg-active'>";
			} else if (JSONrosie[i].reimb_status == 'approved'){
				html+="<tr class='bg-success'>";
			} else {
				html+="<tr class='bg-danger'>";
			}
			if (JSONrosie[i].reimb_status === 'pending'){
				JSONrosie[i].reimb_resolved = '';
				JSONrosie[i].reimb_resolver = '';
			} else {
				JSONrosie[i].reimb_resolved = JSONrosie[i].reimb_resolved.split('.',1)[0];
			}
			if (JSONrosie[i].reimb_description == null){
				JSONrosie[i].reimb_description = '';
			}
		    html+="<td colspan='1'>"+JSONrosie[i].reimb_id+"</td>";
		    html+="<td colspan='1'><span>$"+JSONrosie[i].reimb_amount+"</span><br>";
		    html+="<span>"+JSONrosie[i].reimb_type+"</span></td>";
		    html+="<td colspan='1'>"+JSONrosie[i].reimb_author.toUpperCase()+"</td>";
		    html+="<td colspan='3'><span>"+JSONrosie[i].reimb_submitted.split('.',1)[0]+"</span><br>";
		    html+="<span>"+JSONrosie[i].reimb_resolved+"</span></td>";
		    html+="<td colspan='3' width='30%'>"+JSONrosie[i].reimb_description+"</td>";
		    if(JSONjohnny.role == 'Admin' && asAdmin && JSONrosie[i].reimb_status === 'pending'){
		    	html +=`<td colspan='1' width='8%'><span>PENDING</span><br>
		    	<input class="btn btn-success btn-sm" value="Approve" name="submit" onclick="ajaxApproveDeny(${JSONrosie[i].reimb_id}, 'Approve')">
				<input class="btn btn-danger btn-sm" value="Deny" name="submit" onclick="ajaxApproveDeny(${JSONrosie[i].reimb_id}, 'Deny')"></td>`
		    } else{ 
		    	if (JSONrosie[i].reimb_status.toUpperCase() === "DENY"){
		    		html+="<td colspan='1'>DENIED</td>"; 
		    	} else if (JSONrosie[i].reimb_status.toUpperCase() === "APPROVED"){
		    		html+="<td colspan='1'>APPROVED</td>"; 
		    	} else {
		    		html+="<td colspan='1'>PENDING</td>"; 
		    	}
		    }
		    html+="<td colspan='1'>"+JSONrosie[i].reimb_resolver+"</td>";
		    html+="<td colspan='1'>"+''+"</td>";
		    html+="</tr>";
		}
		html+="</tbody></table></div></form>";
		document.getElementById("susan").innerHTML = html;
		
	}


function ajaxAddNewReimb(event) {
	uploadFile(event);
	/*let description = document.forms["newReimbForm"]["description"].value;
	let type = document.forms["newReimbForm"]["type"].value;
	let amount = document.forms["newReimbForm"]["amount"].value;
	let susan = document.getElementById('susan');
	susan.innerHTML = `<div id='content'><div id="fade"></div><div id = 'deedee'><img id="loader" src="RykerSign.png" /></div></div>`;
	openModal();
	params = 'description='+description+'&type='+type + '&amount='+amount;
	console.log(params);
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('AJAX - IN ADD NEW REIMB: '+xhttp.responseText);
			document.getElementById('blingbling').innerHTML = `${xhttp.responseText}`;
			displayHome();
		}
	}
	//Calls MasterServletAction
	xhttp.open('POST', 'http://localhost:10054/RykerERS/action/addreimb.ryker'+'?'+params, true);
	xhttp.send();*/
}


function displayNewReimbForm() {
	let susan = document.getElementById('susan');
	susan.innerHTML = `
	<h1>New Reimbursement</h1>
	<div class = 'container'style="border: 4px solid crimson; padding: 10px">
	<form id="newReimbForm" class="needs-validation" name="newReimbForm" action = 'action/addreimb.ryker' method="POST" enctype="multipart/form-data">
	<div class="form-group row">
		<label for="description" class="col-form-label; col-sm-2"
			style='text-align: left'>Description</label>
			<div class="col-sm-10">
			<textarea class="form-control" id="reimbDesc" maxlength="250"
			rows="3" name="description" placeholder="For what are you needing to be reimbursed for?" required></textarea>
		</div>
	</div>
	<div class="form-group row">
		<label for="ReimbType" class="col-sm-2 col-form-label" style='text-align: left'>Reimbursement
			TYPE</label>
		<fieldset class="form-group">
			<div class="col-sm-10">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="type"
						id="type1" value="Lodging"> <label
						class="form-check-label" for="type1">Lodging</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="type"
						id="type2" value="Travel"> <label
						class="form-check-label" for="type2">Travel</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="type"
						id="type3" value="Food"> <label
						class="form-check-label" for="type3">Foods</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="type"
						id="type4" value="Other" checked> <label
						class="form-check-label" for="type4">Other</label>
				</div>
			</div>
		</fieldset>
	</div>

	<div class="form-group row">
		<label for="amount" class="col-form-label; col-sm-2"
			style='text-align: left'>Amount (USD)</label>
		<div class="input-group-prepend">
			<div class="input-group-text">$</div>
			<input type="number" min="0.00" step="0.01" max="100000"
				data-number-to-fixed="2" class="form-control currency" id="amount"
				name="amount" placeholder="00.00" required/>
		</div>
	</div>

	<div class="form-group row">
		<label for="receipt" class="col-form-label; col-sm-2">Receipt(Optional)</label>
		<div class="col-sm-10">
			<input type="file" class="form-control file" id="receipt"
				name="receipt"/>			
				<!-- 	<web-app> .... <context-param> <description>c:\apache-tomcat-5.5.29\webapps\data\
			</description> <param-name>file-upload</param-name> <param-value>
			c:\apache-tomcat-5.5.29\webapps\data\ </param-value> </context-param> .... </web-app> -->
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="affirm" required/>
				<label class="form-check-label" for="affirm"> I affirm
					that the above information is complete and correct. </label>
			</div>
		</div>
		<div class="col-sm-2">
			<button id="newReimbSubmit" style="align: right"
				name='boo' class="btn btn-primary" type="submit">Submit</button>
		</div>
	</div>
</form>
</div>
`;

	document.getElementById("newReimbForm").addEventListener('submit', function (event) {
		event.preventDefault();
	    
		// These variables are used to store the form data
		file = {
				dom    : document.getElementById("receipt"),
				binary : null
		};

		// Use the FileReader API to access file content
		var reader = new FileReader();

		// Because FileReader is asynchronous, store its result when it finishes to read the file
		reader.addEventListener("load", function () {
			file.binary = reader.result;
		});

		// At page load, if a file is already selected, read it.
		if(file.dom.files[0]) {
			reader.readAsBinaryString(file.dom.files[0]);
		}

		// If not, read the file once the user selects it.
		file.dom.addEventListener("change", function () {
			if(reader.readyState === FileReader.LOADING) {
				reader.abort();
			}

			reader.readAsBinaryString(file.dom.files[0]);
		});
	    sendData();
	});
}
function sendData() {
	description = document.forms["newReimbForm"]["description"].value;
	type = document.forms["newReimbForm"]["type"].value;
	amount = document.forms["newReimbForm"]["amount"].value;
	// If there is a selected file, wait it is read
	// If there is not, delay the execution of the function
	if (!file.binary && file.dom.files.length > 0) {
		setTimeout(sendData, 10);
		return;
	}

	// To construct our multipart form data request,We need an XMLHttpRequest instance
	var XHR = new XMLHttpRequest();

	// We need a separator to define each part of the request
	var boundary = "blob";

	// Store our body request in a string.
	var data = "";

	// So, if the user has selected a file
	if (file.dom.files[0]) {
		// Start a new part in our body's request
		data += "--" + boundary + "\r\n";

		// Describe it as form data
		data += 'content-disposition: form-data; '
			// Define the name of the form data
			+ 'name="'         + file.dom.name          + '"; '
			// Provide the real name of the file
			+ 'filename="'     + file.dom.files[0].name + '"\r\n';
		// And the MIME type of the file
		data += 'Content-Type: ' + file.dom.files[0].type + '\r\n';

		// There's a blank line between the metadata and the data
		data += '\r\n';

		// Append the binary data to our body's request
		data += file.binary + '\r\n';
	}

	// Text data is simpler
	// Start a new part in our body's request
	data += "--" + boundary + "\r\n";

	// Say it's form data, and name it
	data += 'content-disposition: form-data; name="description" \r\n';
	data += '\r\n';
	// There's a blank line between the metadata and the data
	data += description + "\r\n";
	
	data += "--" + boundary + "\r\n";
	data += 'content-disposition: form-data; name="type" \r\n';
	data += '\r\n';
	// There's a blank line between the metadata and the data

	data += type + "\r\n";
	
	data += "--" + boundary + "\r\n";
	data += 'content-disposition: form-data; name="amount" \r\n';
	data += '\r\n';
	data += amount + "\r\n";

	// Once we are done, "close" the body's request
	data += "--" + boundary + "--";

	// Define what happens on successful data submission
	XHR.addEventListener('load', function(event) {
		console.log('AJAX - IN ADD NEW REIMB: '+XHR.responseText);
		document.getElementById('blingbling').innerHTML = `${XHR.responseText}`;
		displayHome();
		//alert('Yeah! Data sent and response loaded.');
	});

	// Define what happens in case of error
	XHR.addEventListener('error', function(event) {
		console.log('AJAX - IN ADD NEW REIMB: '+XHR.responseText);
		document.getElementById('blingbling').innerHTML = `${XHR.responseText}`;
		JSONjohnny = {};
		displayHome();
		//alert('Oops! Something went wrong.');
	});

	// Set up our request
	XHR.open('POST', 'http://localhost:10054/RykerERS/action/addreimb.ryker');

	// Add the required HTTP header to handle a multipart form data POST request
	XHR.setRequestHeader('Content-Type','multipart/form-data; boundary=' + boundary);

	// And finally, send our data.
	XHR.send(data);
}

	function ArrayBufferToString(buffer) {
	    return BinaryToString(String.fromCharCode.apply(null, Array.prototype.slice.apply(new Uint8Array(buffer))));
	}

	function StringToArrayBuffer(string) {
	    return StringToUint8Array(string).buffer;
	}

	function BinaryToString(binary) {
	    var error;

	    try {
	        return decodeURIComponent(escape(binary));
	    } catch (_error) {
	        error = _error;
	        if (error instanceof URIError) {
	            return binary;
	        } else {
	            throw error;
	        }
	    }
	}

	function StringToBinary(string) {
	    var chars, code, i, isUCS2, len, _i;

	    len = string.length;
	    chars = [];
	    isUCS2 = false;
	    for (i = _i = 0; 0 <= len ? _i < len : _i > len; i = 0 <= len ? ++_i : --_i) {
	        code = String.prototype.charCodeAt.call(string, i);
	        if (code > 255) {
	            isUCS2 = true;
	            chars = null;
	            break;
	        } else {
	            chars.push(code);
	        }
	    }
	    if (isUCS2 === true) {
	        return unescape(encodeURIComponent(string));
	    } else {
	        return String.fromCharCode.apply(null, Array.prototype.slice.apply(chars));
	    }
	}

	function StringToUint8Array(string) {
	    var binary, binLen, buffer, chars, i, _i;
	    binary = StringToBinary(string);
	    binLen = binary.length;
	    buffer = new ArrayBuffer(binLen);
	    chars  = new Uint8Array(buffer);
	    for (i = _i = 0; 0 <= binLen ? _i < binLen : _i > binLen; i = 0 <= binLen ? ++_i : --_i) {
	        chars[i] = String.prototype.charCodeAt.call(binary, i);
	    }
	    return chars;
	}

function allowSubmit() {
	let betty = document.getElementById('affirm');
	let boo = document.getElementById("newReimbSubmit");
	let a = document.forms["newReimbForm"]["description"].value;
	let b = document.forms["newReimbForm"]["amount"].value;
	console.log('a ', a, ' b ', b, ' boo ', boo.disabled,
			' betty ', betty.checked);
	// This is to make sure the employee inputs all of the requiered information before they can submit
	if (a != "" & b != "" & betty.checked) {
		boo.disabled = false;
	} else {
		boo.disabled = true;
	}
}

function ajaxLogout() {
	JSONjohnny = null;
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log('AJAX - IN LOGOUT: '+xhttp.responseText);
		}
	}
	//Calls MasterServletAction
	xhttp.open('POST', 'http://localhost:10054/RykerERS/action/logout.ryker', true);
	xhttp.send();
}