//Fibonacci: Define function: fib(n) Return the nth number in the fibonacci sequence.
function fib(n) {
	if ((typeof n) != 'number') {
		alert('Eek! please enter a number for the factorial function.')
	} else {
		n = Math.abs(n);
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			let fnm2 = 0;
			let fnm1 = 1;
			let fn = fnm1+fnm2;
			for (let i = 2; i <= n; i++) {
				fn = fnm1 + fnm2;
				fnm2 = fnm1;
				fnm1 = fn;
			}
			return fn;
		}
	}
}

// Bubble Sort: Define function: bubbleSort(numArray) Use the bubble sort algorithm to sort the array. Return the sorted array.
function bubbleSort(numArray) {
	if (numArray.length <= 1){ 
		return numArray;
	} else {
		let temp;
		for (let i = numArray.length-1; i >= 0; i--) {
			for (let j = numArray.length-1; j >= 1; j--) {
				if (numArray[j] < numArray[j - 1]) {
					temp = numArray[j];
					numArray[j] = numArray[j - 1];
					numArray[j - 1] = temp;
				}
			}
		}
		return numArray;
	}
}

// Reverse String: Define function: reverseStr(someStr) Reverse and return the
// String.
function reverseStr(someStr) {
	if (someStr.length == 0){
		return '';
	} else if (someStr.length == 1){
		return someStr;
	} else {
		let holder = '';
		for (let i = someStr.length - 1; i >= 0; i--) {
			holder += someStr[i];
		}
		return holder;
	}
}

// Factorial: Define function: factorial(someNum) Use recursion to compute and
// return the factorial of someNum.
function factorial(someNum) {
	if (someNum == 0) {
		return 1;
	} else if (typeof someNum != 'number') {
		alert('Eek! please enter a number for the factorial function.')
	} else {
		let temp = 1;
		for (let i = 1; i <= someNum; i++) {
			temp *= i;
		}
		return temp;
	}
}

// Substring: Define function substring(someStr, length, offset) Return the
// substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the
// input was incorrect.
function substring(someStr, length, offset) {
	if (offset < 0) {
		alert('Sorry starting index input was negative/NaN.');
	} else if (offset > someStr.length) {
		alert('Sorry starting index input was larger than string size.');
	} else if (length + offset > someStr.length) {
		alert('Sorry ending index input was larger than string size/NaN.');
	} else if (length == 0) {
		alert('Sorry offset input was 0.');
	} else {
		return someStr.substring(offset, offset + length);
	}
}

// Even Number: Define function: isEven(someNum) Return true if even, false if
// odd. Do not use % operator.
function isEven(someNum) {
	if (typeof someNum != 'number') {
		alert('Eek! please enter a NUMBER for the isEven function.');
	} else if(someNum != Math.floor(someNum)) {
		alert('Eek! please enter a whole number for the isEven function.');
	} else {
		if (Math.floor((someNum+1)/2) == someNum/2) {
			//this is the even case.
			return true;
		} else {
			//this is the odd case.
			return false;
		}
	}
}


// Palindrome: Define function isPalindrome(someStr) Return true if someStr is a
// palindrome, otherwise return false
function isPalindrome(someStr){
	if (typeof someStr != 'string') {
		alert('Eek! please enter a STRING for the isPalindrome function.');
	} else if(someStr.length <= 1) {
		return true;
	} else {
		let holder = '';
		for (let i = someStr.length - 1; i >= 0; i--) {
			holder += someStr[i];
		}
		if (holder == someStr){
			return true;
		} else {
			return false;
		}
	}
}

// Shapes:
/*
 * Define function: printShape(shape, height, character) shape is a String and
 * is either "Square", "Triangle", "Diamond". height is a Number and is the
 * height of the shape. Assume the number is odd. character is a String that
 * represents the contents of the shape. Assume this String contains just one
 * character. Use a switch statement to determine which shape was passed in. Use
 * the console.log function to print the desired shape. 
 * Example for printShape("Square", 3, "%"); 
 * %%% 
 * %%% 
 * %%% 
 * Example for printShape("Triangle", 3, "$"); 
 * $ 
 * $$ 
 * $$$ 
 * Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
 */
function printShape(shape, height, character){
	if (((typeof height) != 'number') || (height <= 0) || (Math.round(height) != height)){
		alert('Eek! please enter a valid height.')
	} 
	switch(shape.toLowerCase()){
		case 'square':
			printSquare(shape, height, character);
			break;
		case 'triangle':
			printTriangle(shape, height, character);
			break;
		case'diamond':
			if (height%2 == 1){
				printDiamond(shape, height, character);
			} else {
				alert('Eek! please enter an odd value for height when making diamonds.')
			}
			break;
		default:
			alert('Eek! please enter Square, Triangle, or Diamond for the shape.')
	}
}


function printSquare(shape, height, character) {
	let temp = '';
	for (let i = 0; i < height; i++){
		for (let j = 0; j < height; j++) {
			temp += character;
		}
		temp += '\n';
	}
	console.log(temp);
}
function printTriangle(shape, height, character) {
	let temp = '';
	for (let i = 0; i < height; i++){
		for (let j = 0; j <= i; j++) {
			temp += character;
		}
		temp += '\n';
	}
	console.log(temp);
}
function printDiamond(shape, height, character) {
	let temp = '';
	let middle = height/2;
	for (let i = 1; i <= height; i++){
		for (let j = 1; j <= height; j++) {
			if (i < middle) {
				if (j > (middle - i+1) && j < (middle + i)){
					temp += character;
				}else {
					temp += ' ';
				}
			}else {
				if (j > (i-middle) && j < (height-(i-middle)+1)) {
					temp += character;
				} else {
					temp += ' ';
				}
			}
		}
		temp += '\n';
	}
	console.log(temp);
}


// Object literal: Define function traverseObject(someObj) Print every property
// and it's value.
function traverseObj(someObj) {
	let objlen = Object.keys(someObj);
	for (let i = 0; i < objlen.length; i++){
		console.log(objlen[i], '   ', someObj[objlen[i]]);
	}
}
//let myobj = {fart : 'lol', hello:'goodbye', saying:'hobo' };



// Delete Element: Define function deleteElement(someArr) Print length; Delete
// the third element in the array; Print length; The lengths should be the same.
function deleteElement(someArr){
	console.log(someArr.length);
	if (someArr.length > 3){
		delete someArr[3];
		console.log(someArr.length);
	} else {
		alert('Eek! please provide an array with at least 3 indices')
	}
}


// Splice Element: Define function spliceElement(someArr) Print length; Splice
// the third element in the array; Print length; The lengths should be one less
// than the original length.
function spliceElement(someArr){
	console.log(someArr.length);
	if (someArr.length > 3){
		someArr.splice(3, 1);
		console.log(someArr.length);
	} else {
		alert('Eek! please provide an array with at least 3 indices')
	}
}

// Defining an object using a constructor: Define a function Person(name, age)
// The following line should set a Person object to the variable john:
function Person(name, age) {
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);

// Defining an object using an object literal: Define function getPerson(name,
// age) The following line should set a Person object to the variable john:
// var john = getPerson("John", 30);
function getPerson(name, age) {
	return {name, age};
}
var john2 = getPerson("John", 30);






