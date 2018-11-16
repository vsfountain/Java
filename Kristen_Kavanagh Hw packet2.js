
/**
  *@author Kristen Kavanagh
  *@version 11/14/2018 
 */

/**
 * 
 * 1. Fibonacci Define function: fib(n) Return the nth number in the fibonacci
 * sequence.
 */
function fib(n) {
	console.log("hellofib");

	var a = 0;
	var b = 1;
	var c;
	console.log("Enter 25");
	console.log(a+ ""+ b);
	for (var i =1; i <= n; i++) {
		c = a + b;
		a=b;
		b=c;
		console.log("" + c);
	}
}

fib(25);
fib(8);
/**
 * 2. Bubble Sort Define function: bubbleSort(numArray) Use the bubble sort
 * algorithm to sort the array. Return the sorted array.
 */
// array example
var hello = [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4];
var array2 = [1,5,4,2];
console.log('hello');
BubbleSort(hello);
BubbleSort(array2);

function BubbleSort(myBubble) {
	var  needNextPass = true;
	for (var k = 1; k < myBubble.length && needNextPass; k++) {
		
		needNextPass = false;
	}
	
	for (var i = 0; i < myBubble.length - 1; i++) {
		if (myBubble[i] > myBubble[i + 1]) {
			
			     var temp = myBubble[i];
	          myBubble[i] = myBubble[i + 1];
	          myBubble[i + 1] = temp;
	          
	          needNextPass = true;
	        }
	      }
	
	console.log(myBubble);
	
	    }


/**
 * 3. Reverse String Define function: reverseStr(someStr) Reverse and return the
 * String.
 */
function reverseStr(someStr){
		if (someStr.length ===1){
			return 	someStr; 
			}else{
				return someStr.charAr(someStr.length-1) +
				reverseStr(someStr.substr(0,someStr.length-1));
			}
}

	
/**
 * 4. Factorial Define function: factorial(someNum) Use recursion to compute and
 * return the factorial of someNum.
 */
function factorial(someNum){
	if(someNum==1){
		return1;
	}else {
		return someNum*factorial(--someNum);
	}
}

console.log("Factorial of  " + someNum + "  is:  " + factorial(--someNum));

/**
 * 5. Substring Define function substring(someStr, length, offset) Return the
 * substring contained between offset and (offset + length) inclusively. If
 * incorrect input is entered, use the alert function and describe why the input
 * was incorrect.
 */

function substring(someStr,length,offset) {
	if (someStr.length<length|| someStr.length<length){
		alert ('input exceeds the length of the param')
	}
let tmpStr ='';
for(i=offser; i<lenth;i++){
	tmpStr =tmpStr +someStr.charAt(i);
	}
return tmpStr;
}



/**
 * 6. Even Number Define function: isEven(someNum) Return true if even, false if
 * odd. Do not use % operator.
 */
function isEven(someNum){
	for (var i=1; i<=someNum; i++)
	isEven =! isEven;
	return isEven;
	// ((math.floor(someNum/2)*2)===someNum);
}
if (isEven(someNum))
	console.log ("Even")
	else 
		console.log ('Odd')
		
	
/**
 * 7. Palindrome Define function isPalindrome(someStr) Return true if someStr is
 * a palindrome, otherwise return false
 */
			
		function isPalindrome(someStr){
		if(someStr ==reverseStr (someStr)){
			return true;}
		else{
			return false;
		}
	}

/**
 * 8. Shapes Define function: printShape(shape, height, character) shape is a
 * String and is either "Square", "Triangle", "Diamond". height is a Number and
 * is the height of the shape. Assume the number is odd. character is a String
 * that represents the contents of the shape. Assume this String contains just
 * one character. Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape. Example for
 * printShape("Square", 3, "%"); %%% %%% %%% Example for printShape("Triangle",
 * 3, "$"); $ $$ $$$ Example for printShape("Diamond", 5, "*");
 *  ** **** **
 * 
 */
function printShape(shape, height, character){
	let outStr = " ";
	switch(shape) { 
	case 'Square':
		for (let i=0; i<height; i++){
			for (let j=0; j<height;  j++){
				outStr +=character;
			}
			outStr +="\n";
		}
		break;
	case 'Triangle':
		for (let i=0; i<height; i++){
			outStr += character;
					}"\n";
		outStr += character;
	}
	outStr += "\n";
}
	break;
	
	case 'Diamond':
		let mid = Math.ceil(height/2);
		let length = mid; 
		let n = mid-1;
		for (let i=0; i<height; i++){
			for (j = 0; j<length; j++){
				if (j<n){
					outStr += " ";
				}else{
					outStr += character;
				}
			}
			if (i < mid -1) {
				n--;
				length++;
			}else{
				n++;
				length--;
							}
			outStr +="\n";
			}
				break;
				
				default:
					
					outStr = "invalid input";
							}
							console.log (outStr);
							}
							
/**
 * 9. Object literal *Define function traverseObject(someObj) Print every
 * property and it's value.
 */
	function traverseObject(someObj){
		for (var value in someObj){
			console.log(someObj[value]);
		}
	}						

/**
 * 10. Delete Element Define function deleteElement(someArr) 
 * Print length Delete
 * the third element in the array. 
 * Print length The lengths should be the same.
 */
	function deleteElement(someArr){
		console.log(someArr.length);
		someArry [2] = null;
		console.log(someArr.length);
	}
1/**
	 * 1. Splice Element Define function spliceElement(someArr) 
	 * Print length
	 * Splice the third element in the array. 
	 * Print length The lengths should be
	 * one less than the original length.
	 */
function spliceElement (someArr){
	let tmpArr =[];
	console.log(someArr.length);
	for (let i=0; i<someArr.length; i++){
		if(i !== 2 ){
			tmpArr.push(someArr[i]);
		}
		}
someArr = tmpArr;
console.log(someArr.length);
console.log(someArr);
}

12. /**
	 * Defining an object using a constructor Define a function Person(name,
	 * age) 
	 * The following line should set a Person object to the variable john:
	 * var john = new Person("John", 30);
	 */
function Person (name, age){
var john = new Person("John", 30);
var person = new Person (name,age);
}

/**
 * 13. Defining an object using an object literal Define function
 * getPerson(name, age) The following line should set a Person object to the
 * variable john: var john = getPerson("John", 30);
 */
function getPerson(name,age){
	var john = getPerson("John",30);
}


/**
 * PART II
 * 
 * Part II will focus on Javascript's ability to manipulate the DOM. Use the
 * provided index.html Put your Javascript in the provided <script> element at
 * the bottom of the page. Please put the question itself as a comment above
 * each answer.
 * 
 * NOTE: Part II will be done twice: once with Javascript and once with jQuery.
 * They should be done separately. Copy the index.html file and rename them to:
 * indexJavascript.html and indexJQuery.html
 */

/**
 * 1. USA Define function getUSA() Find the html element that contains "USA".
 * Print that element's contents.
 */

function getUSA(){
	console.log (document.querySelector("h1").getElementsByTagName("span")[1]);
	
}
getUSA();
/**
 * 2. Sales Define function getPeopleInSales() Print the names of all the people
 * in the sales department.
 */
function getPeopleInSales(){
	var listofallTdElements = document.getElementsByTagName("TD");
	for (var i = 0; i< listofallTdElements.length;  i++){
		
		if(listofallTdElements[i].textContent == "Sales"){
			console.log(listofallTdElements[i-1].textContent);
		}
	}
	
}
getPeopleInSales();
/**
 * 3. Click Here Define function getAnchorChildren() Find all anchor elements
 * with a <span> child. Print the contents of <span>
 */
function getAnchorChildren(){
	var listallaElements = document.getElementsByTagName("span");
	
	for (var i=0; i<listallaElements.length; i++){
		
		if(listallaElements[i].parentElement.tagName == "A"){
			console.log(listallaElements [i].textContent);
		}

	}
}
getAnchorChildren();
/*
 * 4. Hobbies Define function getHobbies() Find all checked options in the
 * 'skills' select element. Print the value and the contents.
 */ 
function getHobbies() { 
let skills = document.querySelector("select[name='skills,']").children; 
for (let i=0; i<skills.length; i++) { 
if (skills[i].selected === true) { 
console.log(skills[i].textContent) 
} 
} 
} 
/**
 * 5. Custom Attribute *Define function getCustomAttribute() *Find all elements
 * with "data-customAttr" attribute *Print the value of the attribute. *Print
 * the element that has the attribute.
 */
function getCustomAttribute(){
	let vals = document.querySelectorAll("[data-customAttr]");
	let attrs;
	for (let i=0; i<vals.length; i++)
{
	attrs = vals [i].attributes;
	console.log(i + "." + vals[i].nodeName + "data-customAttr:"+ attrs["data- customattr"].value);
}
}

/**
 * 6. Sum Event NOTE: Write unobtrusive Javascript Regarding these elements:
 * <input id="num1" class="nums" type="text"/> 
 * <input id="num2" class="nums" type="text"/>
 * <h3>Sum: <span id="sum"></span></h3>
 * 
 * Define onchange event handler. 
 * Add <input> element values. 
 * Put the sum in the <span> element. 
 * If values cannot be added, put "Cannot add" in the <span>
 * element
 */
var n1 = document.getElementById("num1");
var n2 = document.getElementById("num2");
n1.onchange = function () {sumNums()}
n2.onchange = function() {sumNums()}
function sumNums(){
	letsum = document.getElementById('sum');
	if (Number.isNaN(parseInt(n1.value))|| Number.isNaN(parseInt(n2.value))
			{
		sum.textContent = "Cannot add";
			} return;
			
/**
 * 7. Skills Event NOTE: Write unobtrusive Javascript When user selects a skill,
 * create an alert with a message similar to: "Are you sure CSS is one of your
 * skills?" NOTE: no alert should appear when user deselects a skill.
 */

function eventSkills(){
	document.getElementsByName("skills")[0].addEventListener('change', function(){
		var selectedElement = document.getElementsByName("skills")[0].
		options[document.getElementsByName("skills")[0].selectedIndex];
		alert("Are you sure "+ selectedElement.textContent + " is one of your skills ?")
	};	
}
eventSkills();
	
/**
 * 8. Favorite Color Event NOTE: Write unobtrusive Javascript NOTE: This is
 * regarding the favoriteColor radio buttons.
 *  When a user selects a color,
 *   create an alert with a message similar to: "So you like green more than blue
 * now?" In this example, green is the new value and blue is the old value. Make
 * the background color (of all favoriteColor radio buttons) the newly selected
 * favoriteColor
 */
function favoriteColorEvent(){
 var old;
 var favoriteColorElements = document.getElementsByName("favoriteColor");
 for(var i=0; i<favoriteColorElements.length; i++){
	 favoriteColorElements[i].addEventListener("change", function(){
		 for (var k=0; k<favoriteColorElements.length; k++){
			 if(favoriteColorElements[k].checked){
				 var color = favoriteColorElements[k].value;
		
	alert("So you like" + color + "more than" + old +"now?");
	old = color;
	document.body.style.backgroundColor = color;
}
		 }
	 });
 }
}

/**
 * 9. Show/Hide Event NOTE: Write unobtrusive Javascript 
 * When user hovers over
 * an employees name: 
 * Hide the name if shown. Show the name if hidden.
 */
(function(){
	var employee =document.getElementsByClassName("empeeName");
	for (var i=0; i<employee.length; i++){
		employee[i].addEventListener('mouseover',showHide);
		employee[i].style.opacity= "1"
	}
})();
function showHide(){
	employ = even.target;
	if(employ.style.opacity === "1"){
		employ.style.opacity = "0";
	}else {
		employ.style.opacity ="1";
	}
}
/**
 * 10. Current Time *Regarding this element: *
 * <h5 id="currentTime"></h5>
 * *Show the current time in this element in this format: 9:05:23 AM *The time
 * should be accurate to the second without having to reload the page.
 */
function printTime(){
	let currentTime = new Date();
	let timeStr = currentTime.getHours() + ":"
	+ currentTime.getMinutes() + ":"
	+ currentTime.getSecond();
	let time = document.getElementById('currentTime').innerHTML = timeStr;
	setTimeout(printTime,1000);
}
printTime();
}
/**
 * 11. Delay *Regarding this element: *
 * <p id="helloWorld">
 * Hello, World!
 * </p>
 * *Three seconds after a user clicks on this element, change the text to a
 * random color.
 */
function changeColor(){
	let helloworld = document.getElementById('helloWorld');
	let num1 = Math.floor(Math.random()*256);
	let num2 = Math.floor(Math.random()*256);
	let num3 = Math.floor(Math.random()*256);
	helloworld.style.color = "rgb("+num1+","+num2+"," +num3+")";
			console.log(helloworld.style.font);
			console.log(num1 + " " + num2 + " " + num3);
	}
let helloworld = document.getElementById('helloWorld');
helloworld.onclick = function(){setTimeout(changeColor,3000)};

/**
 * 12. Walk the DOM Define function walkTheDOM(node, func)
 *  This function should
 * traverse every node in the DOM. Use recursion. 
 * On each node, call func(node).
 */
function walkTheDom(node,func) {
	func(node);
	node = node.firstElem;
	while (node){
		walkTheDom(node, func);
		node = node.nextElems;
	}
}
