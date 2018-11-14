
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.
//F(n) = F(n-1)+F(n-2)
function fib (n){
	memo = {};

	  if (memo[n]) return memo[n];
	  if (n <= 1) return 1;

	  return memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
}
console.log(fib(25));

//
//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.

function bubbleSort(numArray){
	
	for(var i=0; i<numArray.length;i++){
		for(j=i+1; j< numArray.length; j++){
			if(numArray[i]>numArray[j]){
				var temp = numArray[i];
				numArray[i] = numArray[j];
				numArray[j] = temp;
			}
		}
	}
	return numArray;
}
var numArray = [4,5,2];
console.log(bubbleSort(numArray));

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function reverseStr(someStr){
	var newStr = "";
	for (i = someStr.length-1; i >=0; i--){
		newStr+=someStr[i];
	}
	
	return newStr;
} 
var someStr = "Hello"
console.log(reverseStr(someStr));

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

function factorial(someNum){
	//set a base case
	if (someNum < 0){
		return ("must be non negative");
	}
	if (someNum == 0){
		return 1;
	}
	
	return (someNum * factorial(someNum-1));
}
var someNum = 5;
console.log(factorial(someNum));

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset){

	var sub = "";
	for(i = offset; i <= (offset + length); i++){
		sub += someStr[i];
	}
	
	return sub;
}
var someStr="Hello World";
var length = 5;
var offset = 2;

console.log(substring(someStr, length, offset));

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(someNum){	
	if(someNum & 1){
		return false;
	}
	return true;
}

var someNum = 7;
console.log(isEven(someNum));

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr){
	var mid = someStr.length/2;  
	for (var i = 1; i<mid;i++){
		for (var j = someStr.length-2; j>mid; j--){
			if(someStr[i] != someStr[j]){
				return false;
			}
		}
	}
	return true;
}
var someStr = 'maam';
console.log(isPalindrome(someStr));
//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
function printShape(shape, height, character){
	switch(shape){
	case 'square':
		square = "";
		for(i = height;i>0;i--){
			square += character;
		}
		
		while(height>0){
			//console.log(height);
			console.log(square);
			height--;
		}
		break;
		
	case 'triangle':
		triangle = "";
		for(i = 0; i < height; i++){
			triangle += character;
			console.log(triangle);
		}
		break;
		
	case 'diamond':
		diamond = "  *";
		mid = "";
		diamond2 = "*  ";
		
		console.log(diamond);
		console.log(" *** ");
		diamond = "**";
		for(var i = 1; i < ((height-1)/2); i++){
			mid +=character;
			diamond = (diamond+mid+diamond);
			console.log(diamond);
		}
		
		space = " ";
		for(var j = 1; j<((height-1)/2);j++){
			mid += character;
			diamond = space+mid+diamond2;
			console.log(diamond);
		}
		console.log("  *");
		

		//return(memo[height] = (printShape(shape, height-1, character)+printShape(shape, height-2, character)));
//		diamond = '';
//		diamond2 = '';
//		diamond3 = '';
//		for(var i = 0; i < (height-1)/2; i++){
//			diamond += ".";
//			}
//		diamond += character;
//		console.log(diamond);
//		
//		for(var i = 1; i < diamond.length; i++){
//			height--;
//			diamond2 += diamond[i];
//			for(var j =diamond.length-1; j>1; j--){
//				diamond3 += diamond[j];
//				}
//			console.log(diamond2 +character+character+ diamond3);
//			}
//		diamond = diamond2+character+character+diamond3;
	}
}

var shape = 'square';
var height = 5;
var character = "%";
printShape(shape, height, character);

var shape = 'triangle';
var height = 3;
var character = "$";
printShape(shape, height, character);

var shape = 'diamond';
var height = 5;
var character = "*";
printShape(shape, height, character);

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

function traverseObject(someObj){ 
	for(var item in someObj){
		console.log('key=',item);
		console.log('value=',someObj[item]);
	}
}

var someObj = {FIRST:'Bill',LAST:'Bob'};
traverseObject(someObj);

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

function deleteElement(someArr){
	console.log('length = ', someArr.length);
	delete someArr[3];
	console.log('length = ', someArr.length);
	//alert(someArr);
	
}

var someArr = [3,5,2,4,9];
deleteElement(someArr);


//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

function spliceElement(someArr){
	console.log('length = ', someArr.length);
	someArr.splice(3,1);
	console.log('length = ', someArr.length);
	//alert(someArr);
}

spliceElement(someArr);

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

function Person(name,age){
	this.name = name;
	this.age = age;
}
 
var john = new Person("John", 30);


//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);

 function getPerson(name,age){
	 getPerson.name = name;
	 getPerson.age = age;
 } 
 var john = getPerson("John", 30);
 
 
//-----------------------------------------------------------------------------------
//PART II
//
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//	  They should be done separately.
//	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
 
 function getUSA(elem){
	 console.log(document.body.innerText.match("USA"));
 }

 
//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
function getPeopleInSales(){
	let len = document.getElementsByTagName("tr").length;
	for (let i = 1; i<len;i++ ){
		if(document.getElementsByTagName("tr")[i].innerText.includes("Sales")){
			console.log(document.getElementsByTagName("tr")[i].innerText);
		}
	}	
}
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
function getAnchorChildren(){
	let len = document.getElementsByTagName("a").length;
	for(let i = 0; i<len;i++){
		if(document.getElementsByTagName("a")[i].querySelector("span") != null){
			console.log(document.getElementsByTagName("a")[i].querySelector("span"));
		}
	}
}

//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.

function getHobbies(){
	let len = document.getElementsByTagName("option").length;
	for(let i = 0; i<len;i++){
		if(document.getElementsByTagName("option")[i].getAttribute("selected")!=null){
			console.log(document.getElementsByTagName("option")[i]);
		}
	}
}

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.

function getCustomAttribute(){
	let len = document.getElementsByTagName("span").length;
	for(let i = 0; i<len;i++){
		if(document.getElementsByTagName("span")[i].getAttribute("data-customAttr")!=null){
			console.log("span", document.getElementsByTagName("span")[i].getAttribute("data-customAttr").valueOf("data-customAttr"));	
		}
	}
	let len2 = document.getElementsByTagName("input").length;
	for(let i = 0; i<len;i++){
		if(document.getElementsByTagName("input")[i].getAttribute("data-customAttr")!=null){
			console.log("input",document.getElementsByTagName("input")[i].getAttribute("data-customAttr").valueOf("data-customAttr"));	
		}
	}
}

//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>



//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element



//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
//
//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
//
//
