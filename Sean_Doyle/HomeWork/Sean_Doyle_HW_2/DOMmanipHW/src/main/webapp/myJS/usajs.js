/*USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA(){
	let temp = document.getElementsByTagName('h1')[0].children[1].innerHTML;
	console.log(temp);
}
console.log('Question 1');
getUSA();

/*Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/ 
function getPeopleInSales() {
	let temp = document.getElementsByTagName('tr');
	for (let i = 1; i < temp.length; i++){
		if (temp[i].children[1].innerText == 'Sales'){
			console.log(temp[i].children[0].innerHTML);
		}
	}
}
console.log('Question 2');
getPeopleInSales();

/*Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
function getAnchorChildren() {
	let temp = document.getElementsByTagName('a');
	let temp2;
	for (let i = 0; i < temp.length; i++){
		temp2 = temp[i].children;
		for (let j = 0; j < temp2.length; j++){
			if (temp2[j].nodeName == 'SPAN'){
				console.log(temp2[j].innerHTML);
				break;
			}
		}
	}
}
console.log('Question 3');
getAnchorChildren();

/*Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/

function getHobbies() {
	let e = document.getElementsByTagName('select');
	let s = e.skills.options[e.skills.selectedIndex].text;
	console.log(s);
}
document.getElementsByTagName('select').skills.addEventListener('change', getHobbies);//this works whenever you make a new selection
console.log('Question 4');
getHobbies();


/*Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute(){
	let elements = document.getElementsByTagName("*");
	let match = [];
	for (let i = 0; i <elements.length; i++) {
		if (elements[i].hasAttribute("data-customAttr")){
			match.push(elements[i]);
		}
	}
	for (let i = 0; i < match.length; i++){
		console.log(match[i].getAttribute("data-customAttr"), '    ', match[i].innerHTML);
	}
}
console.log('Question 5');
getCustomAttribute();


/*Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/

let inputnum1 = document.getElementById('num1');
let inputnum2 = document.getElementById('num2');
inputnum1.onchange = function(){doSum()};
inputnum2.onchange = function(){doSum()};
function doSum(){
	if (isNaN(parseInt(inputnum1.value))  || isNaN(parseInt(inputnum2.value))){
		document.getElementById('sum').innerHTML = 'Cannot Add';
	}else{
		let v1 = parseInt(inputnum1.value);
		let v2 = parseInt(inputnum2.value);
		document.getElementById('sum').innerHTML = (v1+v2);
	}
}
console.log('Question 6');

/*Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

function getSkills() {
	let e = document.getElementsByTagName('select');
	let s = e.skills.options[e.skills.selectedIndex].text;
	 alert('Are you sure you want to select ' + s + ' as one of your favorite skills?');
}
document.getElementsByTagName('select').skills.addEventListener('change', getSkills);
console.log('Question 7');

/*Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
function alertColor(e){
	let i = 0;
	for (; i < match.length; i++){
		if (match[i].checked){	
			alert('So you like '+ match[i].value + ' more than ' + ohno + ' now?');
			break;
		}
	}
	let body = document.querySelector('body');
	body.setAttribute("style", "background-color: "+match[i].value);
	ohno = match[i].value;
}
let elements = document.getElementById('firstForm').getElementsByTagName("*");
let match = [];
for (let i = 0; i < elements.length; i++) {
	if (elements[i].hasAttribute("name")) {
		if (elements[i].getAttribute("name") == 'favoriteColor') {
			match.push(elements[i]);
		}
	}
}
let ohno = 'white';
for (let j =0; j < match.length; j++){
	match[j].addEventListener('click', alertColor);
	let body = document.querySelector('body');
	body.setAttribute("style", "background-color: white");
}
console.log('Question 8');


/*Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
*/
let emps = document.getElementsByClassName("empName");
for (let i = 0; i < emps.length; i++){
	emps[i].style.opacity = 1;
	emps[i].addEventListener('mouseover', toggleVis);
}
function toggleVis(e){
	let emp = e.target;
	//console.log(emp);
	if (emp.style.opacity != 0){
		emp.style.opacity = 0;
	} else  {
		emp.style.opacity = 1;
	}
}
//THIS SHOULD WORK IDK WHY....
console.log('Question 9');

/*Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/


function getCurrentTime(){
	let date = new Date();
	let hrs = date.getHours();
	let mins = date.getMinutes();
	let secs = date.getSeconds();
	if (mins < 10){
		mins = "0"+mins;
	}
	if (secs < 10){
		secs = "0" + secs;
	}
	if (hrs % 12 == hrs){
		document.getElementById('currentTime').innerHTML= hrs + ':' +mins+ ':'+secs + ' AM';
	}else {
		document.getElementById('currentTime').innerHTML= hrs%12 + ':' +mins+ ':'+secs + ' PM';
	}
	setTimeout(getCurrentTime, 1000);//sets a future event for 1s in the future
}
console.log('Question 10');
getCurrentTime();


/*Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
function doin3(e){
	console.log("We will wait 3 seconds");
	setTimeout(textChange, 3000);
}
function textChange(){
	console.log("We have changed the text color after waiting 3 seconds");
	document.getElementById('helloWorld').style.color = getRandomColor();
}
let delay = document.getElementById('helloWorld');
delay.addEventListener('click', doin3);

function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}
console.log('Question 11');

/*Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/


function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

// Example usage: Process all Text nodes on the page
walkTheDOM(document.body, function (node) {console.log(node.innerText)});





