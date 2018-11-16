//when web page loads all HTML elements
window.onload = function() {
	document.getElementById("theButton").addEventListener('click', getSW);
}
//a promis is a placehoder for a future value
//once the value has returned all subscribers
//are notified of the returned value.
function getSW() {

	// getting field value
	let uName = document.getElementById('username').value;
	let pWord = document.getElementById('password').value;

	fetch( swId)
	.then(function(response) {
		console.log(response);
		return response.json();
	}, function() {
		console.log('wat')
	})
	.then(function(myJson) {

		console.log(JSON.stringify(myJson));
		setValues(myJson)
	}).catch(function(){console.log('y u do this')});
	
	// .catch() works the same as the second argument of a .then()
	// .catch()

}

function setValues(sw) {

	document.getElementById("swName").innerHTML = sw.name;
}