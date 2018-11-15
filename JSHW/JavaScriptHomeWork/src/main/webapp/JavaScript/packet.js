/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
 */
console.log(fib(14));
function fib(n) {
	let a = 1;
	let aMinusOne = 0;
	let answerString = "0, 1, ";
	let fibbNum;
	if (n == 0) {
		return a;
	}
	if (n == 1) {
		return aMinusOne;
	}
	for (let i = 0; i < n - 1; i++) {
		fibbNum = a + aMinusOne;
		answerString = answerString + fibbNum + ", ";
		aMinusOne = a;
		a = fibbNum;

	}

	return fibbNum;
}

/*
 * 2. Bubble Sort Define function: bubbleSort(numArray) Use the bubble sort
 * algorithm to sort the array. Return the sorted array.
 */
let myArr = [ 60, 48, 98, 77, 100, 52, 43, 1, 36, 97, 10, 32, 92, 76, 9, 85,
		13, 37, 6, 55 ];

console.log(bubbleSort(myArr));
function bubbleSort(arr) {
	let length = arr.length;
	let sortedFrom = length;
	let temp = 0;
	for (let x = 0; x < length; x++) {
		for (let y = 0; y < sortedFrom - 1; y++) {
			if (myArr[y] > myArr[y + 1]) {
				temp = myArr[y];
				myArr[y] = myArr[y + 1];
				myArr[y + 1] = temp;
			}
		}
		sortedFrom = sortedFrom - 1;
	}

	return arr;
}

/*
 * 3. Reverse String Define function: reverseStr(someStr) Reverse and return the
 * String.
 */
console.log(reverseStr('this is a string'));
function reverseStr(string) {
	let length = string.length;
	let newString = string;
	let lastItem = length;
	for (let x = 0; x < length; x++) {
		newString = newString.substring(1, newString.length - x)
				+ newString.substring(0, 1)
				+ newString.substring(newString.length - x, newString.length);
	}
	return newString;
}
/*
 * 4. Factorial Define function: factorial(someNum) Use recursion to compute and
 * return the factorial of someNum.
 */
console.log(factorial(5));
function factorial(someNum) {
	let number = someNum;
	if (number == 1) {
		return 1;
	} else {
		number = number * factorial(number - 1);
		return number;
	}

}

/*
 * 5. Substring Define function substring(someStr, length, offset) Return the
 * substring contained between offset and (offset + length) inclusively. If
 * incorrect input is entered, use the alert function and describe why the input
 * was incorrect.
 */
console.log(substring("123456789", 3, 5));
function substring(someStr, length, offset) {
	let toReturn = "";
	if (offset > someStr.length) {
		alert("offest is larger then string length");
		return toReturn;
	}
	if (offset + length > someStr.length) {
		alert("the length will try to get characters after the last one in "
				+ someStr);
		return toReturn;
	}
	if (offset < 0 || length < 0) {
		alert("Inputs can not be negative");
		return toReturn;
	}

	for (let x = offset; x < offset + length; x++) {
		toReturn = toReturn + someStr[x];
	}
	return toReturn;
}

/*
 * 6. Even Number Define function: isEven(someNum) Return true if even, false if
 * odd. Do not use % operator.
 */
console.log(isEven(4));
function isEven(someNum) {
	if ((1 & someNum) > 0) {
		return false;
	}
	return true;

}
/*
 * 7. Palindrome Define function isPalindrome(someStr) Return true if someStr is
 * a palindrome, otherwise return false
 */
console.log(isPalindrome("tacocat")); // he's a palindrome!
function isPalindrome(someStr) {
	for (let x = 0; x < someStr.length / 2; x++) {
		if (someStr[x] != someStr[someStr.length - 1 - x]) {
			return false;
		}
	}
	return true;
}

/*
 * 8. Shapes Define function: printShape(shape, height, character) shape is a
 * String and is either "Square", "Triangle", "Diamond". height is a Number and
 * is the height of the shape. Assume the number is odd. character is a String
 * that represents the contents of the shape. Assume this String contains just
 * one character. Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape. Example for
 * printShape("Square", 3, "%"); %%% %%% %%% Example for printShape("Triangle",
 * 3, "$"); $ $$ $$$ Example for printShape("Diamond", 5, "*"); ** **** **
 * 
 * 
 * 
 */
console.log(printShape("Diamond", 5, "%"));
function printShape(shape, height, character) {
	let toReturn = "";
	if (shape === "Square") {
		for (let x = 0; x < height; x++) {
			for (let y = 0; y < height; y++) {
				toReturn += character;
			}
			toReturn += "\n";
		}

	}

	if (shape === "Triangle") {
		for (let x = 0; x < height; x++) {
			for (let y = 0; y <= x; y++) {
				toReturn += character;
			}
			toReturn += "\n";
		}
	}
	if (shape === "Diamond") {
		let maxSpaces = (height) / 2;
		// x*2 since we need to be 1/2 the height
		for (let x = 0; (x*2) < height; x++) {

			for (let y = 0; y <= maxSpaces-1; y++) {
				toReturn += " ";
			}
			maxSpaces--;
			// need to add 2 x per layer
			for (let y = 0; y <= 2*x; y++) {
				toReturn += character;

			}
			toReturn += "\n";
		}
		spaces = 1;
		// suptract 1 from height since middle taken care above
		for (let x = 0; (x*2) < height -1 ; x++) {
			for (let y = 0; y < spaces; y++) {
				toReturn += " ";
			}
			spaces++;
			for (let y =  0 ; y < 2*((height-1)/2 -x) -1; y++) {
				toReturn += character;
			}

			toReturn += "\n";
		}
	}

	return toReturn
}


/*
 * 9. Object literal Define function traverseObject(someObj) Print every
 * property and it's value.
 */

let obj = {
		
		property1: "hello",
		property2: "hello2",
		fun(){
			let word = "wow im in a function";
		}
};


traverseObject(obj);
function traverseObject(someObj){
	for(let y in someObj){
		console.log(y + ": " + someObj[y]);
	}
}

/*
 * 10. Delete Element Define function deleteElement(someArr) Print length Delete
 * the third element in the array. Print length The lengths should be the same.
 */
let thing = ["2",'2',"2","2",5,6];
deleteElement(thing);
function deleteElement(someArr){
	console.log(someArr.length);
	someArr[3]=null;
	console.log(someArr.length);
	console.log(someArr);
}

/*
 * 11. Splice Element Define function spliceElement(someArr) Print length Splice
 * the third element in the array. Print length The lengths should be one less
 * than the original length.
 */
spliceElement(thing);
function spliceElement(someArr){
	console.log(someArr.length);
	let something = someArr.splice(3);
	console.log(someArr);
	console.log(something)
}

/*
 * 12. Defining an object using a constructor Define a function Person(name,
 * age) The following line should set a Person object to the variable john: var
 * john = new Person("John", 30);
 */

function Person(name, age){
	this.name = name,
	this.age = age;
	
}
let person = new Person("bob", 23);
console.log(person);

/*
 * 13. Defining an object using an object literal Define function
 * getPerson(name, age) The following line should set a Person object to the
 * variable john: var john = getPerson("John", 30);
 */

function getPerson(name, age){
	 let thing = {
			theirName: name,
			theirAge: age
		};
	
	return  thing;
}

console.log(getPerson("jill",532));