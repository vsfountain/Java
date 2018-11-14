/*
 *	Hw2 Part 2
 *	Javascript DOM Manipulation problems
 *
 */

/*
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
 */ 
function getUSA() {
	let elem = document.querySelector("span[data-customAttr='USA']");
	console.log(elem.innerText);
}

/*
 * 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
 */
function getPeopleInSales() {
	let trParent = document.querySelectorAll("tr");
	for (let i=0; i<trParent.length; i++) {
		if (trParent[i].innerText.includes('Sales')) {
			//splitting the innertext string by whitespace
			let tmp = trParent[i].innerText.split(/(\s+)/);
			console.log(tmp[0]);
		}
	}
}

/*
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 */
function getAnchorChildren() {
	let children = document.querySelectorAll('span');
	for (let i=0; i<children.length; i++) {
		if (children[i].parentElement.nodeName === 'A') {
			//console.log(children[i].innerHTML);
			console.log(children[i].innerText);
		}
	}
}

/*
 * 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 */
function getHobbies() {
	//get the HTML array of child elements of skills
	let skills = document.querySelector("select[name='skills']").children;
	for (let i=0; i<skills.length; i++) {
		if (skills[i].selected === true) {
			console.log(skills[i].textContent)
		}
	}
}

/*
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 */
function getCustomAttribute() {
	let vals = document.querySelectorAll("[data-customAttr]");
	let attrs;

	for (let i=0; i<vals.length; i++) {
		attrs = vals[i].attributes;
		console.log(i+". "+vals[i].nodeName+" data-customAttr: "+attrs["data-customattr"].value);
	}
}

/*
 * 6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 * 	<input id="num1" class="nums" type="text"/>
 * 	<input id="num2" class="nums" type="text"/>
 *  <h3>Sum: <span id="sum"></span></h3>
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element 
 */
let n1 = document.getElementById("num1");
let n2 = document.getElementById("num2");

n1.onchange = function(){sumNums()}
n2.onchange = function(){sumNums()}

function sumNums() {
	let sum = document.getElementById('sum');
	
	if (Number.isNaN(parseInt(n1.value)) || Number.isNaN(parseInt(n2.value))) {
		sum.innerText = "Cannot add";
	} else {
		sum.innerHTML = parseInt(n1.value) + parseInt(n2.value);
	}
	
}

/*
 * 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 * 	"Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 */
let skillSel = document.querySelector("select[name='skills']")
skillSel.onchange = function(){alertUserSkills()};

function alertUserSkills() {
	alert("Are you sure "+ skillSel.value +" is one of your skills?")
}

/*
 * 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * 	"So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 */
let colors = document.querySelector("select[name='colors']");
colors.onchange = function(){alertUserColors()};
let old = colors.value;

function alertUserColors() {
	alert("So you like " + colors.value + " more than " + old + " now?");
	old = colors.value;
	colors.style.background = colors.value;
}

/*
 * 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 * 	Hide the name if shown.
 * 	Show the name if hidden.
 */
(function(){
	let emps = document.getElementsByClassName("empName");
	for (let i=0; i<emps.length; i++) {
		emps[i].addEventListener('mouseover', showHide);
		emps[i].style.opacity = "1"
	}
})();

function showHide() {
	emp = event.target;
	if (emp.style.opacity === "1") {
		emp.style.opacity = "0";
	} else {
		emp.style.opacity = "1";
	}
}

/*
 * 10. Current Time
 * Regarding this element:
 * 	<h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 */
(function setCurrentTime() {
	let el = document.getElementById('currentTime');
	let dt = new Date();
	let hh = dt.getHours();
	let mm = dt.getMinutes();
	let ss = dt.getSeconds();
	let tt = "AM";
	if (hh>12) {
		hh -= 12;
		tt = "PM";
	}
	if (mm < 10) {
		mm = "0" + mm;
	}
	if (ss < 10) {
		ss = "0" + ss;
	}
	el.innerHTML = hh + ":" + mm + ":" + ss + " " + tt;
})();

/*
 * 11. Delay
 * Regarding this element:
 * 	<p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 */
(function(){
	let el = document.getElementById('helloWorld');
	el.addEventListener('click', function(){
		window.setTimeout(function(){
			let letters = '0123456789ABCDEF';
			let color = '#';
			for (let i=0; i<6; i++) {
				color += letters[Math.floor(Math.random() * 16)];
			}
			console.log("changing color: "+color)
			el.style.color = color;
		}, 3000)
	})
})();


/*window.setTimout(function waitForColor() {
	el = event.target;
	let letters = '0123456789ABCDEF';
	let color = '#';
	for (let i=0; i<6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	}
	console.log("changing color: "+color)
	el.style.color = color;
}, 3000);
*/
/*
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. Use recursion.
 * On each node, call func(node).
 */
function walkTheDOM(node, func) {
	func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

/*(walkTheDOM(document.body, function (node){
    console.log(node.innerText);
}))();*/
