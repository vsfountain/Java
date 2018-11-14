/*
 *	Hw2 Part 1
 *	Javascript packet problems
 *
 */

/*
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence.
 */

function fib(n) {
	//this all assumes that the fibonacci sequence starts at 0
	let frist;	//first number before n
	let second;	//second number before n
	let current;	//nth fib at end of loop
	
	for (let i=0; i<n; i++) {
		if (i===0) {			//first fib is always 0
			first = 0;
		} else if (i===1) {	//second fib is always 1
			second = first;
			first = 1;
		} else {
			current = first + second; 
			second = first;	//first becomes second, current becomes first
			first = current;
		}
	}
	return current;
} 

/*
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */

function bubbleSort(numArray) {
	let sorted = false;
	let x = 0; //temporary variable for the swap
	let nums = numArray;
	while(!sorted) {
		sorted = true; //flip to false when values are shifted
		
		for(let i=0, j=1; j<nums.length; i++, j++) {
			if (nums[i]>nums[j]) {	//values not in order, need to swap
				//swap index values
				x = nums[i];
				nums[i] = nums[j];
				nums[j] = x;
				//we don't know if it has been completely sorted yet
				sorted = false;
			}
		}
	}
	return nums;
}

/*
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */

function reverseStr(someStr) {
	//tail call
	if (someStr.length===1){
		return someStr;
	} else {
		return someStr.charAt(someStr.length-1) + reverseStr(someStr.substr(0, someStr.length-1));
	}
}

/*
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
 */

function factorial(someNum) {
	if (someNum===1){
		return 1;
	} else {
		return someNum * factorial(--someNum);
	}
}

/*
 * 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */

function substring(someStr, length, offset) {
	//check for bad inputs
	if (someStr.length<length || someStr.length<length) {
		alert('Parameters exceeded the length of the input string');
	}
	
	//get substring
	let tmpStr = '';
	for (i=offset; i<length; i++) {
		tmpStr = tmpStr + someStr.charAt(i);
	}
	return tmpStr;
}

/*
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 */

function isEven(someNum) {
	/*
	 * An even number divided by two and then 
	 * multiplied by two will always equal itself.
	 */
	//need Math.floor to make sure that the result of division is an integer
	return ((Math.floor(someNum / 2) * 2) === someNum);
}

/*
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(someStr) {
	//return true if the string matches its reverse
	if (someStr === reverseStr(someStr)) {
		return true;
	} else {
		return false;
	}
}

/*
 * 8. Shapes
 * Define function: printShape(shape, height, character)
 * shape is a String and is either "Square", "Triangle", "Diamond".
 * height is a Number and is the height of the shape. Assume the number is odd.
 * character is a String that represents the contents of the shape. 
 * Assume this String contains just one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 * 
   Example for printShape("Square", 3, "%");
%%%
%%%
%%%
   Example for printShape("Triangle", 3, "$");
$
$$
$$$
   Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
 */

function printShape(shape, height, character) {
	let outStr = "";
	
	switch(shape) {
		case 'Square':
			for (let i=0; i<height; i++){
				for (let j=0; j<height; j++) {
					outStr += character;
				}
				outStr += "\n";
			}
			break;
		case 'Triangle':
			for (let i=0; i<height; i++){
				for (j=0; j<=i; j++) {
					outStr += character;
				}
				outStr += "\n";
			}
			break;
		case 'Diamond':
			let mid = Math.ceil(height/2);
			let length = mid;
			let n = mid - 1;
			
			for (let i=0; i<height; i++){ 	//loop for whole shape
				for (j=0; j<length; j++) {		//loop for each line
					if (j<n) {
						outStr += " ";
					} else {
						outStr += character;
					}
				}
				if (i<mid-1) {	//before midpoint
					n--;		//decrease space counter
					length++;	//increase line length
				} else {		//after midpoint
					n++;		//increase space counter
					length--;	//decrease line length
				}
				outStr += "\n";
			}
			break;
		default:
			outStr = "invalid input";
	}
	
	console.log(outStr);
}

/*
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value.
 */

function traverseObject(someObj) {
	//use the range loop
	// can pass keys or indices into the [] operator
	for (let key in someObj) {
		console.log(someObj[key]);
	}
}

/*
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
 */

function deleteElement(someArr) {
	//replace the third element in the array with a null value
	console.log(someArr.length);
	someArr[2] = null;
	console.log(someArr.length);
}

/*
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */

function spliceElement(someArr) {
	//remove the third element in the array
	let tmpArr = [];
	console.log(someArr.length);
	for (let i=0; i<someArr.length; i++){
		if (i !== 2) {	//third element
			tmpArr.push(someArr[i]);
		}
	}
	someArr = tmpArr;
	console.log(someArr.length);
	console.log(someArr);
}

/*
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 * 		var john = new Person("John", 30);
 */

function Person(name, age) {
	//use the this keyword?
	this.name = name;
	this.age = age;
}

/*
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 * 		var john = getPerson("John", 30);
 */

function getPerson(name, age) {
	//just return an object?
	return {name: name, age: age};	
}
