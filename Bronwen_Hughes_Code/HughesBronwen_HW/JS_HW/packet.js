/**
 * 
 */

/*
 * 1. Fibonacci Define function: fib(n) Return the nth number in the fibonacci
 * sequence.
 */

function Fib(num) {
	if (num == 1 || num == 2) {
		return 1;
	} else {
		return Fib(num - 1) + Fib(num - 2);
	}
}

console.log("Fib(5): " + Fib(5));

/*
 * 2. Bubble Sort Define function: bubbleSort(numArray) Use the bubble sort
 * algorithm to sort the array. Return the sorted array.
 */

function BubbleSort(array) {
	while (IsNotSorted(array)) {
		SortArray(array);
	}
	console.log(array);
}

function NeedToSort(FirstNum, SecondNum) {
	if (FirstNum > SecondNum) {
		return true;
	} else {
		return false;
	}
}

function IsNotSorted(array) {
	for (i = 0; i < (array.length - 1); i++) {
		if (NeedToSort(array[i], array[i + 1])) {
			return true;
		}
	}
	return false;
}

function SortArray(array) {
	for (i = 0; i < (array.length - 1); i++) {
		if (NeedToSort(array[i], array[i + 1])) {
			let temp = array[i];
			array[i] = array[i + 1];
			array[i + 1] = temp;
		}
	}
}

let tempArray = [ 1, 6, 2, 3, 2, 6, 2 ];
BubbleSort(tempArray);

/*
 * 3. Reverse String Define function: reverseStr(someStr) Reverse and return the
 * String.
 */

let tempStr2 = 'billy';

function reverseString(someStr) {
	let tempString = "";
	for (i = someStr.length - 1; i >= 0; i--) {
		tempString += someStr[i];
	}
	return tempString;
}

console.log("Reverse of billy: " + reverseString(tempStr2));

/*
 * 4. Factorial Define function: factorial(someNum) Use recursion to compute and
 * return the factorial of someNum.
 */

function Factorial(num) {
	if (num > 1) {
		num *= Factorial(num - 1);
		return num;
	} else {
		return 1;
	}
}

console.log("Factorial 5: " + Factorial(5));

/*
 * 5. Substring Define function substring(someStr, length, offset) Return the
 * substring contained between offset and (offset + length) inclusively. If
 * incorrect input is entered, use the alert function and describe why the input
 * was incorrect.
 */

function substring(someStr, length, offset) {
	return someStr.substring(offset, offset + length);
}

let str = "Hello World!";

console.log(substring(str, 4, 1));
/*
 * 6. Even Number Define function: isEven(someNum) Return true if even, false if
 * odd. Do not use % operator.
 */

function isEven(num) {
	let temp = num / 2;
	return parseInt(temp) === temp;
}

console.log("Is 30 even? : " + isEven(30));
console.log("Is 21 even? : " + isEven(21));

/*
 * 7. Palindrome Define function isPalindrome(someStr) Return true if someStr is
 * a palindrome, otherwise return false
 */

let tempStr = 'racecar';

function isPalindrome(someStr) {
	if (someStr === reverseString(someStr)) {
		return true;
	} else {
		return false;
	}
}

console.log("Is racecar a palindrome? : " + isPalindrome(tempStr));
console.log("Is billy a palindrome? : " + isPalindrome(tempStr2));

/*
 * 8. Shapes Define function: printShape(shape, height, character) shape is a
 * String and is either "Square", "Triangle", "Diamond". height is a Number and
 * is the height of the shape. Assume the number is odd. character is a String
 * that represents the contents of the shape. Assume this String contains just
 * one character. Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 */

printShape("Square", 3, '%');
printShape("Triangle", 3, "$");
printShape("Diamond", 9, "*");

function printShape(shape, height, character) {
	switch (shape) {
	case "Square":
		printSquare(height, character);
		break;
	case "Triangle":
		printTriangle(height, character);
		break;
	case "Diamond":
		printDiamond(height, character);
		break;
	}
}

function printSquare(height, character) {
	let temp = '';
	for (i = 0; i < height; i++) {
		temp += character.repeat(height) + "\n";
	}
	console.log(temp);
}

function printTriangle(height, character) {
	let temp = '';
	for (i = 1; i <= height; i++) {
		temp += character.repeat(i) + "\n";
	}
	console.log(temp);
}

function printDiamond(height, character) {
	let temp = '';
	let whitespace = ' ';
	
	for(i = 1; i <= height; i+=2){
		temp += whitespace.repeat((height - i) / 2);
		temp += character.repeat(i) + "\n";
	}
	for(i = (height -2); i >= 0; i-=2){
		temp += whitespace.repeat((height - i) / 2);
		temp += character.repeat(i) + "\n";
	}
	console.log(temp);
}

/*
 * 9. Object literal Define function traverseObject(someObj) 
 * Print every property and it's value.
 */

let a = {
		Name: "Kat",
		Ability: "sleep",
		Drink: "tea",
		Loves: "anime"
};


traverseObject(a);

function traverseObject(someObj){
	let value;
	let temp = '';
	for(let key in someObj){
		value = someObj[key];
		temp += key + ": " + value + "\n";
	}
	console.log(temp);
}

/*
 * 10. Delete Element
 *  Define function deleteElement(someArr) 
 *  Print length 
 *  Delete
 * the third element in the array. 
 * Print length The lengths should be the same.
 */

let someArr = [1,2,3,4,5,6];
deleteElement(someArr);

function deleteElement(someArr){
	let temp = '';
	temp += "The length of the array is: " + someArr.length + "\n";
	delete someArr[3];
	temp += "The length of the array after deleting the third element is: " + someArr.length;
	console.log(temp);
}

/*
 * 11. Splice Element Define function spliceElement(someArr) Print length Splice
 * the third element in the array. Print length The lengths should be one less
 * than the original length.
 */

spliceElement(someArr);

function spliceElement(someArr){
	let temp = '';
	temp += "The length of the array is: " + someArr.length + "\n";
	someArr.splice(3, 1);
	temp += "The length of the array after splicing the third element is: " + someArr.length;
	console.log(temp);
}

/*
 * 12. Defining an object using a constructor Define a function Person(name,
 * age) The following line should set a Person object to the variable john: var
 * john = new Person("John", 30);
 */

function Person(name, age){
	this.name = name;
	this.age = age;
}

var john = new Person("John", 30);
console.log(john);

/*
 * 13. Defining an object using an object literal 
 * Define function
 * getPerson(name, age) 
 * The following line should set a Person object to the
 * variable john: var john = getPerson("John", 30);
 */

function getPerson(name, age){
	return{name, age};
}

var john2 = getPerson("John", 30);
console.log(john2);

