//completed this section on codepen which might be easier to view functionality
//https://codepen.io/Ryanwfile/pen/NENrNO

/* Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence*/
function fibSequence(num){
    let fibArr = [1];//1,1,2,3,5,8  
    let previous = 1;
    let current = 1;
    let total = 0;
    for (let i = 0; current<=num; i++){//uses previous, current, and total values to push the correct sequence of fibonacci numbers to an array.  Uses the for loop condition to be sure the highest current value is always less than or equal to num
      fibArr.push(current);//1
      total = previous + current;//2
      previous = current;//1
      current = total;//2      
     }
    return fibArr;
  }
function fib(n){
  let fibArr = fibSequence(500);//gets fibanocci numbers up to 500, to get more just make this a higher number
  return fibArr[n-1];
}
//console.log(fib(4))
///////////////////////////////////////////////////////////////////////////
/* Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/
function bubbleSort(array) {
  var swapCounter = -3;//initialize a swapcounter variable to any non 0 integer
  function swap(arr, pos1, pos2){    
      var temp = arr[pos1];
      arr[pos1] = arr[pos2];
      arr[pos2] = temp;    
  }
  while (swapCounter !== 0)
    {
      swapCounter = 0;
      for (var i = 0; i<array.length;i++){      
      if (array[i + 1] < array[i])        
        swap(array, i,(i + 1) );
        swapCounter ++;    
      } 
    }  
  return array;
}
//console.log(bubbleSort([1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92]));
/////////////////////////////////////////////////////////////////////////////////////////////
reverseStr = str => {
  let splitter = str.split('');
  splitter.reverse();
  let joinedStr = splitter.join('');
  return joinedStr;
}
//console.log(reverseStr("racecar"));
//////////////////////////////////////////////////////////////////////////////
factorial = num =>{
  if (num <= 1){
    return 1;
  }
  else{
    return num * factorial(num - 1);
  }
  return num;
}
//console.log(factorial(5));
//////////////////////////////////////////////////////////////////////////////
/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/
sub = (str, len, offset) =>{
  if(typeof(str) !== 'string')
    {
      alert("That's not a string")
    }
  else{
     return str.substring(len, (len + offset) + 1)//plus 1 to be inclusive
  } 
}
//console.log(sub("testing stuff", 4, 6));
/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
isEven = num =>{
  const half = Math.floor(num/2);
  let output;
  if(half * 2 === num){
    output = "even number"
  }
   else{
     output = "odd number"
   }   
  return output;
}
//console.log(isEven(567))
/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(str){
  var noCaps = str.toLowerCase().replace(/[^a-z0-9]+/g, "");
  var reverse = str.split('').reverse().join('').toLowerCase().replace(/[^a-z0-9]+/g, "");  
  return noCaps === reverse;
};
//console.log(isPalindrome("racecar"));
//8. Shapes
printShape = (shape, height, character) => {
  let arr = [];
  let str;
  switch (shape){
    case "Square":      
        for(let i = 0; i<height;i++){
          arr.push(character);
        }
        str = arr.join('');     
        for(let j = 0; j<height; j++){
          console.log(str);
        }
        break;
      case "Triangle" :
        for(let i = 1; i<=height;i++){        
          arr.push(character)
          str = arr.join('');
        console.log(str);
        }      
        break;
      case "Diamond"://create an array that has space character space  then join that into a string
        diamond(height, character);
        break;
    default:
      console.log("Hmm, questionable input at best");
      break;
  }
  return 0;
}
//printShape("Diamond", 7, '&');
function diamond(height, char){
  let botHalf = false;
  let space = Math.floor(height/2);
  let amount = 1; 
  for (let idx = 0; idx<height; idx++){   
      let spaceArr = [];
      let charArr = [];     
      for(let i = 0; i<amount; i++){
         charArr.push(char);
      }    
      for(let j = 0; j< space; j++){
      spaceArr.push(" ");
      }
    let str = '';
    let spaceStr = '';
    let charStr = '';
    spaceStr = spaceArr.join('');
    charStr = charArr.join('');
    str = spaceStr + charStr + spaceStr;
    console.log(str)//this should always be 5
    if(charArr.length === height){
      botHalf = true;
      break;
    }
    space--;
    amount += 2;  
  }  
    for(let idx = 0; idx <= height; idx++){
        let spaceArr = [];
        let charArr = []; 
        amount = amount - 2;
        space = (height - amount) /2;
        for(let i = 0; i<amount; i++){
          charArr.push(char);
      }
      for (let j = 0; j<space; j++){
          spaceArr.push(" ");
      }
       let str = '';
       let spaceStr = '';
       let charStr = '';
       spaceStr = spaceArr.join('');
       charStr = charArr.join('');
       str = spaceStr + charStr + spaceStr;
      console.log(str);
       if(amount <= 1){
       break;
       }   
  }   
}
/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/
function traverseObj(obj){
  obj.name = "Al";
  obj.game = "Warcraft3";
  obj.test = "Umm, testing, yea";
  obj.bool = true;
  console.log(obj);
}
testObj = new Object();
//traverseObj(testObj);

/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
let testArr = [];
function deleteElement(arr){
  for(let i = 0; i< 6; i++){
    arr.push(i);
  }
  console.log(testArr)
  console.log(testArr.length)
  //delete ar[4]; // delete element with index 4
  delete arr[3];
  console.log(testArr)
  console.log(testArr.length)
}
//deleteElement(testArr)
/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/
let testArr2 = [];
function spliceElement(arr){
  for(let i = 0; i< 6; i++){
    arr.push(i);
  }
  console.log(arr);
  console.log(arr.length)
  arr.splice(3,1);
  console.log(arr)
  console.log(arr.length)
}
//spliceElement(testArr2);
/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);*/
function Person(name, age){
  this.name = name;
  this.age = age;
}
//let john = new Person("John", 30);
//console.log(john);
/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);*/
function getPerson(name, age){
  Person = new Object();
  Person.name = name;
  Person.age = age;
  return Person;
}
//console.log(getPerson("John", 30));