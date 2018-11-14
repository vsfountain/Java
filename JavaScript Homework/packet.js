//Part I
/*1. Fibonacci
* Define function: fib(n) 
* Return the nth number in the fibonacci sequence.
*/
function fib(n){
	
	let fibN = [1, 1];
	for(let i = 2; i <= n; i++){
		fibN[i]=fibN[i-1]+fibN[i-2];
	}
	return fibN[n-1];
};

/*2.
*Bubble Sort
*Define function: bubbleSort(numArray)
*Use the bubble sort algorithm to sort the array.
*Return the sorted array.
*/
function bubbleSort(numArray){
	for(let i = 0; i < numArray.length; i++){
		for(let j = i+1; j < numArray.length; j++){
			if(numArray[i]>numArray[j]){
				let placeHolder = numArray[i];
				numArray[i]=numArray[j];
				numArray[j]=placeHolder;
			}
		}
	}
	return numArray;
};

/*3.
Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr){
	let reversedString = [];
	let counter = 0;
	for(let i = someStr.length-1; i >= 0; i--){
		reversedString += someStr[i];
		counter = counter+1;
	}
	return reversedString;
};

/*4.
Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum){
	if(someNum>1){
		someNum = someNum*factorial(someNum-1);
		return someNum;
	}
	else{
		return someNum;
	}
}

/*5.
Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(someStr, length, offset){
	let subString = "";
	if(offset>someStr.length){
		alert("Start of substring exceeds the size of the string. Stop trying to break my code Trevin!");
	}
	else if(offset+length > someStr.length){
		alert("End of substring exceeds the size of the string. Stop trying to break my code Trevin!");
	}
	else{
		for(let i = offset; i <= (offset+length); i++){
			subString += someStr[i];
		}
		return subString;
	}
}

/*6.
Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum){
	let checker = 2;
	while(someNum>=0){
		if(someNum==0){
			checker=1;
			break;
		}
		else if(someNum==1){
			checker=0;
			break;
		}
		someNum -= 2;
	}
	if(checker==1){
		return true;
	}
	else{
		return false;
	}
}

/*7.
Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr){
	let reversedString = [];
	let counter = 0;
	for(let i = someStr.length-1; i >= 0; i--){
		reversedString += someStr[i];
		counter = counter+1;
	}
	if(reversedString==someStr){
		return true;
	}
	else{
		return false;
	}
}

/*8.
*Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
*/
function printShape(shape, height, character){
	switch(shape){
		case "Square":
			let getShape = "\n";
			for(let i = 0; i < height; i++){
				getShape += character + character + character + "\n";
			}
			console.log(getShape);
			break;
		case "Triangle":
			let getShapee = "\n";
			let counter = 1;
			let nextIter = 1;
			let currString = "";
			for(let i = 0; i < height; i++){
				while(counter>=1){
					currString += character;
					counter -= 1;
				}
				nextIter += 1;
				counter = nextIter;
				getShapee += currString + "\n";
				currString = "";
			}
			console.log(getShapee);
			break;
		case "Diamond":
			let getShapeee = "\n";
			let counterr = 1;
			let nextIterr = 1;
			let currStringg = "";
			for(let i = 0; i < height/2-1; i++){
				
				while(counterr>=1){
					currStringg += character;
					counterr -= 1;
				}
				nextIterr += 2;
				counterr = nextIterr;
				for(let a = (height-currStringg.length)/2; a > 0; a--){
					getShapeee += " ";
				}
				getShapeee += currStringg + "\n";
				currStringg = "";
			}
			while(counterr>=1){
				currStringg += character;
				counterr -= 1;
			}
			getShapeee+= currStringg + "\n";
			currStringg = "";
			counterr = nextIterr-2;
			nextIterr = nextIterr-2;
			for(let i = height/2-1; i >= 0; i--){
				while(counterr>=1){
					currStringg += character;
					counterr -= 1;
				}
				nextIterr -= 2;
				counterr = nextIterr;
				for(let a = (height-currStringg.length)/2; a > 0; a--){
					getShapeee += " ";
				}
				getShapeee+= currStringg + "\n";
				currStringg = "";
			}
			console.log(getShapeee);
			break;
	}
}

/*9.
*Object literal
*Define function traverseObject(someObj)
*Print every property and it's value.
*/
function traverseObject(someObj){
	  console.log(someObj);
}

/*10.
*Delete Element
*Define function deleteElement(someArr)
*Print length
*Delete the third element in the array.
*Print length
*The lengths should be the same.
*/
function deleteElement(someArr){
	console.log(someArr.length);
	 delete someArr[2];
	console.log(someArr.length);
}

/*11.
*Splice Element
*Define function spliceElement(someArr)
*Print length
*Splice the third element in the array.
*Print length
*The lengths should be one less than the original length.
*/
function spliceElement(someArr){
	console.log(someArr.length);
	someArr.splice(2,1);
	console.log(someArr.length);
}

/*12.
*Defining an object using a constructor
*Define a function Person(name, age)
*The following line should set a Person object to the variable john:
*var john = new Person("John", 30);
*/
function Person(name, age){
	this.name = name;
	this.age = age;
}

/*13.
*Defining an object using an object literal
*Define function getPerson(name, age)
*The following line should set a Person object to the variable john:
*var john = getPerson("John", 30);
*/
function getPerson(name, age){
	let temp = {'name': name,
				'age': age};
	return temp;
}

//Part II DOM
/*
*1. USA
*Define function getUSA()
*Find the html element that contains "USA".
*Print that element's contents.
*/
(function getUSA(){
	let varr = document.getElementsByTagName("h1")[0].textContent;
	console.log(varr);
})();
/*
*2. Sales
*Define function getPeopleInSales()
*Print the names of all the people in the sales department.
*/
(function getPeopleInSales(){
	for(let i = 1; i < document.getElementsByTagName("tr").length*2-1; i+=2){
		let varr;
		if(document.getElementsByTagName("td")[i].textContent=="Sales"){
			varr = document.getElementsByTagName("td")[i-1].textContent;
		}
		if(varr!=undefined){
			console.log(varr);
		}
	}
})();

/*
3. Click Here
*Define function getAnchorChildren()
*Find all anchor elements with a <span> child.
*Print the contents of <span>
*/
(function getAnchorChildren(){
	let varr = document.getElementsByTagName("span");
	for(let i = 0; i < varr.length; i++){
		if(varr[i].parentElement.nodeName=="A"){
			console.log(varr[i].textContent);
		}
	}
})();

/*
*4. Hobbies
*Define function getHobbies()
*Find all checked options in the 'skills' select element.
*Print the value and the contents.
*/
(function getHobbies(){
	for(let i = 0; i < document.getElementsByTagName("select").length; i++){
		let varr = document.getElementsByTagName("select")[i];
		if(varr.getAttribute("name")=="skills"){
			for(let j = 0; j < varr.length; j++){
				if(varr[j].hasAttribute("selected")){
					console.log(varr[j].innerHTML);
				}
			}
		}
	}
})();
/*
*5. Custom Attribute
*Define function getCustomAttribute()
*Find all elements with "data-customAttr" attribute
*Print the value of the attribute.
*Print the element that has the attribute.
*/
	(function getCustomAttribute(){
		let x = document.querySelectorAll("[data-customAttr]");
		for(let i = 0; i < x.length; i++){
			console.log(x[i].getAttribute("data-customAttr") + " " + x[i].tagName);
		}
	})();

/*
*6. Sum Event
*NOTE: Write unobtrusive Javascript
*Regarding these elements:
*	<input id="num1" class="nums" type="text"/>
*	<input id="num2" class="nums" type="text"/>
*	<h3>Sum: <span id="sum"></span></h3>
*
*Define onchange event handler.
*Add <input> element values.
*Put the sum in the <span> element.
*If values cannot be added, put "Cannot add" in the <span> element
*/
(function eventHandler(){
	document.getElementById("num1").onchange = function(){ getValues()};
	document.getElementById("num2").onchange = function(){ getValues()};
})();

function getValues(){
	let num1 = document.getElementById("num1").value;
	let num2 = document.getElementById("num2").value;
	let changeThisHtml = document.getElementById("sum");
	num1 = parseInt(num1);
	num2 = parseInt(num2);
	if(isNaN(num1) || isNaN(num2)){
		changeThisHtml.innerHTML = "Cannot add";
	}
	else{
		changeThisHtml.innerHTML = num1+num2;
	}
}
/*
*7. Skills Event
*NOTE: Write unobtrusive Javascript
*When user selects a skill, create an alert with a message similar to:
*	"Are you sure CSS is one of your skills?"
*NOTE: no alert should appear when user deselects a skill.
*/
(function skillsSelected(){
	for(let i = 0; i < document.getElementsByTagName("select").length; i++){
		let varr = document.getElementsByTagName("select")[i];
		if(varr.getAttribute("name")=="skills"){
			varr.onchange = function(){ popUpAlert(varr.value)};
		}
	}
})();

function popUpAlert(nameOfSkill){
	alert("Are you sure " + nameOfSkill + " is one of your skills?");
}
/*
*8. Favorite Color Event
*NOTE: Write unobtrusive Javascript
*NOTE: This is regarding the favoriteColor radio buttons.
*When a user selects a color, create an alert with a message similar to:
*	"So you like green more than blue now?"
*In this example, green is the new value and blue is the old value.
*Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
(function favColors(){
	let x = document.getElementsByName("favoriteColor");
	for(let i = 0; i < x.length; i++){
		x[i].onchange = function(){ getColors()};
	}
})();

let currColor = "";
let newColor = "";
let y = document.getElementsByName("favoriteColor");

function getColors(){
	let x = event.target;
	newColor = x.value;
	if(currColor!=""){
		alert("So you like " + newColor + " more than " + currColor + " now?");
	}
	else {
		alert("So you like " + newColor + " that's cool!");
	}
	currColor = newColor;
	for(let i = 0; i < y.length; i++){
		y[i].style.backgroundColor = newColor;
	}
	
}
/*
*9. Show/Hide Event
*NOTE: Write unobtrusive Javascript
*When user hovers over an employees name:
*	Hide the name if shown.
*	Show the name if hidden.
*/
(function showOrHideEmp(){
	let x = document.getElementsByClassName("empName");
	for(let i = 0; i < x.length; i++){
		console.log(x[i].innerHTML);
		x[i].addEventListener("mouseover",changeEmp);
		x[i].style.opacity="1";
	}
})();

function changeEmp(){
	let x = event.target;
	console.log("Hello");
	if(x.style.opacity=="0"){
		x.style.opacity = "1";
	}
	else{
		x.style.opacity = "0";
	}
}	

/*
*10. Current Time
*Regarding this element:
*	<h5 id="currentTime"></h5>
*Show the current time in this element in this format: 9:05:23 AM
*The time should be accurate to the second without having to reload the page.
*/
(function getTime(){
	let current = new Date();
	let time = current.getHours() + ":" + current.getMinutes() + ":" + current.getSeconds();
	document.getElementById("currentTime").innerHTML = time;
})();

/*
*11. Delay
*Regarding this element:
*	<p id="helloWorld">Hello, World!</p>
*Three seconds after a user clicks on this element, change the text to a random color.
*/
(function changeElement(){
	let getId = document.getElementById("helloWorld");
	getId.addEventListener("click", changeText);
})();

function changeText(){
	let getColor = "rgb(" + Math.floor(Math.random() * 256) +", "+ 
					Math.floor(Math.random() * 256) +", "+ 
					Math.floor(Math.random() * 256) + ")";
	setTimeout(function(){document.getElementById("helloWorld").style.color=getColor}, 3000);
}
/*
*12. Walk the DOM
*Define function walkTheDOM(node, func)
*This function should traverse every node in the DOM. Use recursion.
*On each node, call func(node).
*/
/*
(function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
})();*/