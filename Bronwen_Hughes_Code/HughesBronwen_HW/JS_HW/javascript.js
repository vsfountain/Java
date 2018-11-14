/**
 * 
 */
getUSA();

function getUSA() {
	let h1tag = document.getElementsByTagName("h1");
	for (i = 0; i < h1tag.length; i++) {
		if (h1tag[i].innerHTML.includes("USA")) {
			console.log(h1tag[i].textContent);
		}
	}
}

/*
 * 2. Sales Define function getPeopleInSales() Print the names of all the people
 * in the sales department.
 */

function getPeopleInSales() {
	let temp = document.getElementsByTagName("tr");

	for (i = 0; i < temp.length; i++) {
		if (temp[i].children[1].innerHTML == "Sales") {
			console.log(temp[i].children[0].innerHTML);
		}
	}
}

getPeopleInSales();

/*
 * 3. Click Here Define function getAnchorChildren() Find all anchor elements
 * with a <span> child. Print the contents of <span>
 */

function getAnchorChildren() {
	let anchor = document.getElementsByTagName('a');
	let children2;

	for (let i = 0; i < anchor.length; i++) {
		children2 = anchor[i].children;
		for (let j = 0; j < children2.length; j++) {
			if (children2[j].nodeName == 'SPAN') {
				console.log(children2[j].innerHTML);
				break;
			}
		}
	}
}

getAnchorChildren();

/*
 * 4. Hobbies Define function getHobbies() Find all checked options in the
 * 'skills' select element. Print the value and the contents.
 */

/*
 * function getHobbies(){ let selectItems =
 * document.getElementsByTagName("select").skills;
 * 
 * for(let i = 0; i < selectItems.length; i++){ let itemChildren =
 * selectItems[i].children; console.log("A"); console.log(itemChildren); for(j =
 * 0; j < itemChildren.length; j++){ console.log("B");
 * if(itemChildren[j].selected == true){ console.log(itemChildren[j].innerHTML);
 * console.log("C"); } } } }
 */

function getHobbies() {
	let items = document.getElementsByTagName("select").skills;

	for (i = 0; i < items.length; i++) {
		if (items[i].selected == true) {
			console.log(items[i].innerHTML);
		}

	}
}

let items = document.getElementsByTagName("select").skills;
items.addEventListener('change', getHobbies);

//items.soptions[items.selectedindex].text

/*
 * function getHobbies(){ let t = docuent.getElementsByName("skills")[0]; for(i =
 * 0; i < t.length; i++){ let t2 = t.childrn[i[.getAttribute(selected)]] if(t2 !=
 * null){ then } }
 *  }
 */

getHobbies();



/*
*5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

function getCustomAttribute(){
	let allItems = document.all;
	for(i = 0; i < allItems.length; i++){
		if(allItems[i].getAttribute('data-customattr')){
			console.log("Value: " + allItems[i].getAttribute('data-customattr') + " Contains: " + allItems[i].innerHTML);
		}
	}
}

getCustomAttribute();


/*
6. Sum Event
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

var num1 = document.getElementById('num1');
var num2 = document.getElementById('num2');

num1.onchange = function(){addTwo()};
num2.onchange = function(){addTwo()};

function addTwo(){
	let sum = document.getElementById('sum');
	if(isNaN(parseInt(num1.value)) || isNaN(parseInt(num2.value))){
		sum.innerHTML = "Cannot add";
	} else {
	sum.innerHTML = parseInt(num1.value) + parseInt(num2.value);
	}
}

/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

function alertHobbies() {
	let items = document.getElementsByTagName("select").skills;

	for (i = 0; i < items.length; i++) {
		if (items[i].selected == true) {
			window.alert("Are you sure " + items[i].innerHTML + " is one of your skills?");
		}

	}
}

//let items = document.getElementsByTagName("select").skills;
items.addEventListener('change', alertHobbies);


/*
 * 
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/

var colors = document.getElementsByName('favoriteColor');
var color = 'nothing';
var prevColor = null;
	
for(i = 0; i < colors.length; i++){
	colors[i].addEventListener('change', changeColor);
}

function changeColor(){
for(i=0; i < colors.length; i++){
		if(colors[i].checked == true){
			let prevColor = color;
			color = colors[i].value;
			window.alert("So you like " + color + " more than " + prevColor + "?");
			document.body.bgColor=color;
			
			//colors[i].style.backgroundColor = color;
		}
	}
}


/*
 * 9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
	*/

let employees = document.getElementsByClassName('empName');
let employee = null;
for(i = 0 ; i < employees.length; i++){
	employees[i].addEventListener('mouseover', toggleEmployeeVisibility);
	//employees[i].onmouseover = toggleEmployeeVisibility();
}

function toggleEmployeeVisibility(e){
		let temp = event.target; //style.visibility;
				
		if(temp.style.opacity == "" || temp.style.opacity == "1.0"){
			temp.style.opacity = "0.0";
		} else {
			temp.style.opacity = "1.0";
		}
	//}
}

/*
  10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/

function printTime(){
	let currentTime = new Date();
	let timeStr = currentTime.getHours() + ":" 
	+ currentTime.getMinutes() + ":"
	+ currentTime.getSeconds();
	let time = document.getElementById('currentTime').innerHTML = timeStr;
	setTimeout(printTime, 1000);
}

printTime();

/*
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/

function changeColor(){
	let helloworld = document.getElementById('helloWorld');
	let num1 = Math.floor(Math.random() * 256);
	let num2 = Math.floor(Math.random() * 256);
	let num3 = Math.floor(Math.random() * 256);
	helloworld.style.color = "rgb("+num1+","+num2+","+num3+")";
	console.log(helloworld.style.font);
	console.log(num1 + " " + num2 + " " + num3);
}

let helloworld = document.getElementById('helloWorld');
helloworld.onclick = function(){setTimeout(changeColor, 3000)};

/*
12. Walk the DOM
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



