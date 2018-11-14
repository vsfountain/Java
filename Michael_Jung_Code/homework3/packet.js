/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */


function fib(n) {
	if(i == 0) {
		return 0;
	}
	if(i == 1) {
		return 1;
	}
	
	var a = 0;
	var b = 1;
	var c = 0;
	for(var i = 2; i < n + 1; i++) {
		c = a + b;
		a = b;
		b = c;
	}
	return b;
}




/**
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */

function bubbleSort(numArray) {
	
	
	var loop = true;
	var index = 0;
	var index2 = 1;
	var size = numArray.length;
	
	var num1;
	var num2;
	var swapOccur = true;
	while(loop) {
		
		num1 = numArray[index];
		num2 = numArray[index2];
		
		if(num1 > num2) {
			
			numArray[index2] = num1;
			numArray[index] = num2;
			swapOccur = false;
		}
		
		index++;
		index2++;
		
		if(swapOccur) {
			loop = false;
		}
		
		
		if(index == size - 1) {
			index = 0;
			index2 = 1;
			swapOccur = true;
		}
	
		
		
		
	}
	
}



/**
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */

function reverseStr(someStr) {
	
	var index;
	for(var i = someStr.length; i > -1 ; i--) {
		someStr += someStr.charAt(i);
		
		
	}
	someStr = someStr.substring(someStr.length/2, someStr.length);
	return someStr;
	
	
	
}



/**
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum
 */

function factorial(someNum) {
	
	if(someNum == 1) {
		return 1;
	}
	if(someNum == 0) {
		return 0;
	}
	return someNum * factorial(someNum - 1); 
	
	
	
}


/**
 * 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */


function substring(someStr, length, offset) {
	
	if(length instanceof string) {
		alert('Length cannot be of type string');
		return;
	}
	if(offset instanceof string) {
		alert('Offset cannot be of type string');
		return;
	}
	if(length instanceof array) {
		alert('Length cannot be of type array');
		return;
	}
	if(offset instanceof array) {
		alert('Offset cannot be of type array');
		return;
	}
	if(length instanceof object) {
		alert('Length cannot be of type object');
		return;
	}
	if(offset instanceof object) {
		alert('Offset cannot be of type object');
		return;
	}
	
	if(offset + length > someStr.size) {
		
		
		
	}
	return someStr.substring(offset, length);
	
	
}


/**
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator
 */

function isEven(someNum) {
	var isEven = true;
	//var odd = false;
	
	for( var i = 0; i < someNum; i++) {
		ifEven = false;
	}
	return isEven;
	
	
}


/**
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(someStr) {
	
	var isPalindrome = true;
	for(var i = 0; i<someStr.length/2; i++) {
		if(someStr.charAt(i) == someStr.charAt(someStr.length-(i+1))) {
			
		} else {
			isPalindrome = false;
		}
		
	}
	return isPalindrome;
	
	
}


/**
 * 8. Shapes
 * Define function: printShape(shape, height, character)
 * shape is a String and is either "Square", "Triangle", "Diamond".
 * height is a Number and is the height of the shape. Assume the number is odd.
 * character is a String that represents the contents of the shape. Assume this String contains just
 * one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 * Example for printShape("Square", 3, "%");
 * %%%
 * %%%
 * %%%
 * Example for printShape("Triangle", 3, "$");
 * $
 * $$
 * $$$
 * Example for printShape("Diamond", 5, "*");
 *   *
 *  ***
 * *****
 *  ***
 *   *
 */


function printShape(shape, height, character) {
	
	switch(shape) {
	case "Square":
		for(var i = 0; i<height; i++) {
			var outputLine = "";
			for(var j = 0; j<height; j++) {
				outputLine += outputLine + character;
			}
			console.log(outputLine);
		}
		
		
		break;
	case "Triangle":
		for(var i = 1; i<height + 1; i++) {
			var outputLine = "";
			for(var j = 0; j<i; j++) {
				outputLine += outputLine + character;
			}
			console.log(outputLine);
			
		}
		
		break;
	case "Diamond":
		
		
		
		
		break;
	}
	
}




/**
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value
 */


function traverseObject(someObj) {
	
	var propValue;
	for(var propName in someObj) {
		console.log(propName, someObj[propName]);
		
	}
	
}


/**
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
 */

function deleteElement(someArr) {
	
	console.log(someArr.length);
	someArry[2] = null;
	console.log(someArr.length);
	
}

/**
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */


function spliceElement(someArr) {
	
	console.log(someArr.length);
	someArry.splice(2, 1);
	console.log(someArry.length);
	
}


/**
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 * 			var john = new Person("John", 30);
 */


function Person(name, age) {
	var john = new Person("John", 30);
	var person = new Person(name, age);
}

/**
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 * 			var john = getPerson("John", 30);
 */

function getPerson(name, age) {
	
	var john = getPerson("John", 30);
	
}

/**
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
 */

function getUSA() {
	console.log("|--------1---------|");
	var h1 = document.querySelector("h1");
	var span = h1.childNodes[1];
	console.log(span);


}
getUSA();

/**
 * 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
 */

function getPeopleInSales() {
	console.log("|--------2---------|");
	
	var allTdTags = document.getElementsByTagName("td");
	
	console.log(allTdTags);
	
	var tdElement;
	var tdElementString;
	for(var i = 0; i<allTdTags.length; i++) {
		
		tdElement = allTdTags[i];
		tdElementString = tdElement.textContent;
		if(tdElementString == "Sales") {
			console.log(allTdTags[i-1].textContent);
		}
		
	}
	
	
	
	
}
getPeopleInSales();



/**
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 */
function getAnchorChildren() {
	console.log("|--------3---------|");
	var allAnchorElements = document.getElementsByTagName("a");
	//console.log(allAnchorElements);
	for(var i = 0; i<allAnchorElements.length; i++) {
		
		if(allAnchorElements[i].hasChildNodes()) {
			var allChildSpanElements = allAnchorElements[i].getElementsByTagName("span");
			//console.log(allChildSpanElements);
			for(var j = 0; j<allAnchorElements[i].getElementsByTagName("span").length; j++) {
				//console.log('a');
				console.log(allChildSpanElements[j].textContent);
			}
			
			
			
		}
		
		
	}
	
}

getAnchorChildren();


/**
 * 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 */

function getHobbies() {
	console.log("|--------4---------|");
	var skillsSelect = document.getElementsByName("skills");
	console.log(skillsSelect[0].childNodes.length);
	var skillsOptions = skillsSelect[0].getElementsByTagName("option");
	console.log(skillsOptions);
	for(var i = 0; i < skillsOptions.length; i++) {
		console.log(skillsOptions[i].value + " " + skillsOptions[i].textContent);
		
	}
	
	
}

getHobbies();


/**
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 */


function getCustomAttribute() {
	console.log("|--------5---------|");
	var dataCustomAttributes = document.querySelectorAll('[data-customAttr]');
	console.log(dataCustomAttributes);
	for(var i = 0; i<dataCustomAttributes.length; i++) {
		
		console.log(dataCustomAttributes[i].getAttribute("data-customAttr") + " " + dataCustomAttributes[i].tagName);
	}
	
}

getCustomAttribute();


/**
 * 6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 * 			<input id="num1" class="nums" type="text"/>
 * 			<input id="num2" class="nums" type="text"/>
 * 			<h3>Sum: <span id="sum"></span></h3>
 * 
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
 */

function sumEvent() {
	var num1Element = document.getElementById("num1");
	/*console.log(num1Element);*/
	/*console.log('a');*/
	num1Element.addEventListener("input", function() {
		calculateSum();
		/*var num1Element = document.getElementById("num1");
		console.log(num1Element);*/
	});
	var num2Element = document.getElementById("num2");
	/*console.log('aa');*/
	num2Element.addEventListener("input", function() {
		calculateSum();
		/*console.log(aaa);*/
	});
	
}

function calculateSum() {
	/*console.log('aaa');*/
	var num1Element = document.getElementById("num1");
	/*console.log(num1Element);*/
	var num1ElementValue = num1Element.value;
	var sumElement = document.getElementById("sum");
	if(isNaN(parseInt(num1ElementValue))) {
		sumElement.textContent = "Cannot add";
		return;
	}
	var num2Element = document.getElementById("num2");
	var num2ElementValue = num2Element.value;
	/*console.log(num2ElementValue);*/
	if(isNaN(parseInt(num2ElementValue))) {
		sumElement.textContent = "Cannot add";
		return;
	}
	
	var num3Element = parseInt(num1ElementValue) + parseInt(num2ElementValue);
	sumElement.textContent = num3Element;
	
}
 

sumEvent();





/**
 * 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 * 		   "Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 */

function skillEvent() {
	
	
	var selectSkillsElement = document.getElementsByName("skills");
	selectSkillsElement[0].addEventListener("change", function() {
		
		var selectedSkillElement = selectSkillsElement[0].options[selectSkillsElement[0].selectedIndex];
		alert('Are you sure ' + selectedSkillElement.textContent + " is one of your skills?");
		
	});
}

skillEvent();



/**
 * 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * 		   "So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 */

function favoriteColorEvent() {
	
	var oldValue;
	
	var favoriteColorElements = document.getElementsByName("favoriteColor");
	for(var i = 0; i<favoriteColorElements.length; i++) {
		
		
		favoriteColorElements[i].addEventListener("change", function() {
			
			for(var j = 0; j<favoriteColorElements.length; j++) {
				if(favoriteColorElements[j].checked) {
					var color = favoriteColorElements[j].value;
					
					alert('So you like ' + color + ' more than ' + oldValue + ' now?');
					oldValue = color;
					
					/*for(var k = 0; k<favoriteColorElements.length; k++) {
						console.log(favoriteColorElements[k].nextElementSibling);
						favoriteColorElements[k].nextElementSibling.style.color = color;
					}*/
					document.body.style.backgroundColor = color;
					
				}
				
				
			}
			
		});
	}
	
	
	
}

favoriteColorEvent();


/**
 * 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name;
 * 		   Hide the name if shown.
 * 		   Show the name if hidden.
 */


function showHideEvent() {
	var employeeNames = document.getElementsByClassName("empName");
	/*console.log(employeeNames);*/
	for(var i = 0; i<employeeNames.length; i++) {
		employeeNames[i].addEventListener("mouseover", function(){
			/*console.log(employeeNames[i]);*/
			var mouseHoveredElement = event.target;
			/*console.log(mouseHoveredElement.style.color);*/
			/*var currentStatus = employeeNames[i].style.color;*/
			/*var currentStatus = mouseHoveredElement.style.color;*/
			var currentStatus = mouseHoveredElement.style.color;
			if(currentStatus == "transparent") {
				/*employeeNames[i].style.color = black;*/
				/*currentStatus.style.color = 'black';*/
				mouseHoveredElement.style.color = 'black';
			} else {
				/*employeeNames[i].style.color = transparent;*/
				/*currentStatus.style.color = 'transparent';*/
				mouseHoveredElement.style.color = 'transparent';
			}
			
			
			
		});
	}
	
	
}

showHideEvent();


/**
 * 10. Current Time
 * Regarding this element:
 * 		   <h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 */

function currentTime() {
	
	var currentTimeElement = document.getElementById("currentTime");
	var date = new Date();
	var amPm;
	var hour;
	if(date.getHours() > 11) {
		amPm = 'PM';
		hour = date.getHours() - 12;
	} else {
		amPm = 'AM';
		hour = date.getHours();
	}
	var currentTimeString = hour + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + amPm;
	currentTimeElement.textContent = currentTimeString;
}

setInterval(currentTime, 1000);


/**
 * 11. Delay
 * Regarding this element:
 * 		   <p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 */

function delay() {
	
	var clickElement = document.getElementById("helloWorld");
	clickElement.addEventListener("click", function() {
		setTimeout(function() {
			var number = Math.floor(Math.random() * 5) + 1;
			var color;
			if(number == 1) {
				color = 'green';
			} else if (number == 2) {
				color = 'purple';
			} else if (number == 3) {
				color = 'blue';
			} else if (number == 4) {
				color = 'red';
			} else if (number == 5) {
				color = 'yellow';
			}
			
			clickElement.style.color = color;
			
			
		}, 3000);
	});
	
	
}

delay();


/**
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. Use recursion.
 * On each node, call func(node).
 */

function walkTheDOM(node, nodeFunc) {
	var childNodes = node.childNodes;
	if(childNodes.length == 0) {
		nodeFunc(node);
	}
	for(var i = 0; i<childNodes.length; i++){
		walkTheDOM(childNodes[i], nodeFunc/*, nodeFunc(childNodes[i])*/);
	}
	nodeFunc(node);
	
}

function nodeFunc(node) {
	console.log(node);
}

walkTheDOM(document.body, nodeFunc/*, nodeFunc(document.body)*/);














