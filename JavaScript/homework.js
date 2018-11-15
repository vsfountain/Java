//Clement JavaScript Homework
function getNum(n){
let i;
let fib = [];

fib[0] = 0;
fib[1] = 1;
for (i = 2; i <= 10; i++) {
  fib[i] = fib[i - 2] + fib[i - 1];
}

  return fib[n];
}

console.log("Question 1: When n is set to 9")
console.log(getNum(9));

console.log("Question 2:")
// Question 2 : Bubble Sort
arr = [9,29,3,1,4,41,2,3,13,23,10]
console.log('Initial Array :', arr.join(' '))
bubbleSort(arr);

function bubbleSort(arr) {
  var n = arr.length;
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
      }
    }
  }console.log(arr)
}
/*Reverse String
 */

console.log("Question 3: String to be reversed : 'tseb eht ma i' ")
toBeReversed = str =>{
	let characters = str.split(''); 
	characters.reverse();
	joinedChars = characters.join('');
	return joinedChars;
	}
console.log("reversed :" + toBeReversed('tseb eht ma i'))

/*Factorial
*/
function factorial(num){
  if (num <= 1){
    return 1;
  }
  else{
    return num * factorial(num - 1);
  }
  return num;
}

console.log("Question 4: Factorial ( 4 ) = " + factorial(4));

/*

5. Substring

*/

console.log("Question 5: the string i passed as an argument is: 'this string', the offset:length is 2:9. ")

function Substring(someStr, offset, length){
  if(someStr.length >= (length + offset))
    {
	  console.log(someStr.substring(offset, (length + offset)))
    }
  else if((offset+length) > someStr.length ){
	  console.log("This is invalid input");
  }
  else{
	  console.log("i don't know how we got here");
    
  } 
}
	console.log("The result is below ");
	Substring("this string", 2, 9);

//6. Even Number

function EvenOrOdd(num){
	while(num >= 0){
	if(num >= 0){
		num = num - 2;
		//EvenOrOdd(num);
		if(num == 0){
			console.log("tis even");
		}
		if(num == 1){
			console.log("tis odd");
		}
		} 
	} 
}
EvenOrOdd(10);

/*
7. Palindrome
*/

function Palindrome(str){
	let splitStr = str.split('');
	let reversedStr = splitStr.reverse();
	let newStr = reversedStr.join('');
	if(str == newStr) console.log( "The string : " + str + " is a Palindrome.")
	else console.log("This is not a palindrome")
}
Palindrome("hello")
Palindrome("dad")

/* I really could not figure out 8...will make sure to
 *  figure it out for java and javascript when i have the time because i need to understand this logic */


/*9. Object literal
 * 
 */

function ObjectLiteral(obj){
  obj.name = "Clement";
  obj.nationality = "American";
  obj.birthCountry = "Greece";
  obj.heightInCM = 178;
  obj.tooCoolForSchool = true;
  console.log(obj);
}
 obj = new Object();
ObjectLiteral(obj);
/*
10. Delete Element
*/

let testArr = [];
function deleteElement(arr){
  for(let i = 0; i< 10; i++){
    arr.push(i);
  }
  console.log(testArr)
  console.log(testArr.length)
  
  delete arr[5];
  console.log(testArr)
  console.log(testArr.length)
}

deleteElement(testArr)

11.
let spliceArray= [];
function spliceElement(arr){
  for(let i = 0; i< 10; i++){
    arr.push(i);
  }
  console.log(arr);
  console.log(arr.length)
  arr.splice(5,1);
  console.log(arr)
  console.log(arr.length)
}

spliceElement(spliceArray);

//12. Person(name, age)

function Person(name, age){
  this.name = name;
  this.age = age;
}

let jDawg = new Person("John", 30);
console.log(jDawg.name, jDawg.age);

/*
13. Defining an object using an object literal
*/
function getPerson(name, age){
  Person = new Object();
  Person.name = name;
  Person.age = age;
  return Person;
}

var john = getPerson("John", 30)
console.log(john)
