//when page loads all HTML elements
window.onload = function(){
	document.getElementById("swSubmit")
		.addEventListener('click', getSW);
}

//a promise is a placeholder for a future value
//	once the value has returned all subscribers
//	are notified of the returned value.
function getSW(){
	//getting field value
	let swId = document.getElementById('swId').value;
	
	fetch('https://swapi.co/api/people/'+ swId)
		.then(
			function(response){
				console.log(response);
				return response.json();
			} ,
			function(){
				console.log('what is u doin?')
			}
		)
		.then(
			function(myJson){
				console.log(JSON.stringify(myJson));
				setValues(myJson);
				}
		).catch(function(){console.log('what else is u doin?')})
		//.catch() works the same as the second argument
		//	of a .then()
		//.catch()
}

function setValues(sw){
	document.getElementById("swName").innerHTML = sw.name;
}











