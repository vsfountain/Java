/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/
function fib(n) {
	let fibArray = [ 0, 1 ];

	for (let i = 2; i < n; i++) {
		fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
	}

	return fibArray[n - 1];
}

//console.log(fib(5));

/*
 * 2. Bubble Sort Define function: bubbleSort(numArray) Use the bubble sort
 * algorithm to sort the array. Return the sorted array.
 */
function bubbleSort(numArray) {
	let swapCnt = -2; // non-zero integer to begin while loop
	while (swapCnt != 0) {
		swapCnt = 0;
		for (let i = 0; i < numArray.length - 1; i++) {
			if (numArray[i] > numArray[i + 1]) {
				let temp = numArray[i]; // Swap the two adjacent numbers
				numArray[i] = numArray[i + 1];// using a temporary 3rd
												// variable
				numArray[i + 1] = temp; // if they are out of order
				swapCnt++;
			}
		}
	}
	return numArray;
}

//console.log(bubbleSort([8,9,2,9,1,5]));

/*
 * 3. Reverse String Define function: reverseStr(someStr)
 *  Reverse and return the String.
 */
function reverseStr(someStr){
	let newStr = "";
	for(let i=someStr.length-1;i>-1;i--){
		newStr+=someStr[i];
	}
	return newStr;
}
//console.log('Clutch is now ' + reverseStr("Clutch"));

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/
function factorial(someNum){
	if(someNum==1) {// base case for end of recursion
		return someNum;
	}
	else
		return someNum * factorial(someNum-1);
}

//console.log(factorial(6));

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/

function substring(someStr, length, offset){
	let newStr = ""
	if(typeof someStr == 'string'){
		if(typeof length == 'number'){
			if(typeof offset == 'number'){
				for(let i = length; i<=offset; i++){
					newStr += someStr[i];
				}
			}else{
				alert("offset must be a number.");
			}
		}else{
			alert("length must be a number.");
		}
	}else{
		alert("someStr must be a string.");
	}
	return newStr;
}

//console.log(substring("Blaziken",2,5));

/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/

function isEven(someNum){
	if ((Math.floor((someNum) / 2)) * 2 == someNum) {
		return true;
	} else {
		return false;
	}
}

//console.log(isEven(4));
//console.log(isEven(9));

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(someStr){
	return someStr == reverseStr(someStr);
}

//console.log(isPalindrome('madam'));
//console.log(isPalindrome('hyper'));

/*8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.*/

function printShape(shape, height, character){
	let result = "";
	switch(shape){
	case "Square":
		for(let i = 0; i<height; i++){
			for(let j = 0; j<height; j++){
				result+=character;
			}
			result += "\n";
		}
		console.log(result);
		break
	case "Triangle":
		for(let i = 0; i<height;i++){
			
			/*for(let j = 0; j<1; j++){
				result += " ";
			}*/
			for(let k = 0; k<i+1; k++){
				result+=character;
			}
			result += "\n"
		}
		console.log(result);
		break
	case "Diamond":
		let row = 1;
		for(let i = Math.ceil(height/2); i>0;i--){
			
			for(let j = 0; j<1; j++){
				result += " ";
			}
			
			for(let k = 0; k<row; k++){
				result+=character + " ";
			}
			result += "\n";
			row++;
		}
		console.log(result);		
		break
	}
}

//printShape("Square", 3, "$");
//printShape("Triangle", 5, "#");
printShape("Diamond", 5, "*");

/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/
function traverseObject(someObj){
	for(elem in someObj){
	console.log(elem + ": " + someObj[elem]);
	}
}

let john = getPerson("John", 30);
traverseObject(john);

/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/

function deleteElement(someArr){
	console.log(someArr);
	console.log(someArr.length);
	delete someArr[2];
	console.log(someArr);
	console.log(someArr.length);
}

//deleteElement([1,2,3,4,5]);

/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/

function spliceElement(someArr){
	console.log(someArr);
	console.log(someArr.length);
	someArr.splice(2,1);
	console.log(someArr);
	console.log(someArr.length);
}

//spliceElement([1,2,3,4,5]);

/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);*/

function Person(name, age){
	this.name = name;
	this.age = age;
}

//let josh = new Person("Josh", 30);
//console.log(josh);

/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);*/
function getPerson(name, age){
	return { name, age }
}

//let john = getPerson("John", 30);













