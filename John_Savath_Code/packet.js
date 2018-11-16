/*Javascript Packet

-----------------------------------------------------------------------------------
PART I

Create a single Javascript file called packet.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------*/

/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/
function fib(n){
    var a = 1, b = 0, temp;

    while (n >= 0){
        temp = a;
        a = a + b;
        b = temp;
        n--;
    }

    return b;
}
/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray){
    for(var i = 0; i < numArray.length; i++) {
        for(var j = 1; j < numArray.length; j++) {
            if(numArray[j - 1] > numArray[j]) {
                swap(numArray, j - 1, j);
            }
        }
    }
    return numArray;
}

/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr){
    let reversed = "";
    for (let i = someStr.length - 1; i >= 0; i--){
        reversed += someStr[i];
    }
    return reversed;
}

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/

function factorial(someNum){
    if (someNum === 0)
    {
        return 1;
    }
    return someNum * factorial(someNum-1);
}

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/
function substring(someStr, length, offset){
	
}
/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
function isEven(someNum){
    if (someNum === 0)
        return true;
    else if (someNum === 1)
        return false;
    else if (someNum < 0)
        return isEven(-someNum);
    else
        return isEven(someNum - 2);
}
/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(someStr){
    let cstr = someStr.toLowerCase().replace(/[^a-zA-Z0-9]+/g,'');
    let count = 0;

    if(cstr==="") {
        console.log("Nothing found!");
        return false;
    }

    if ((cstr.length) % 2 === 0) {
        count = (cstr.length) / 2;
    } else {

        if (cstr.length === 1) {
            console.log("Entry is a palindrome.");
            return true;
        } else {

            count = (cstr.length - 1) / 2;
        }
    }

    for (let x = 0; x < count; x++) {

        if (cstr[x] != cstr.slice(-1-x)[0]) {
            console.log("False, not a palindrome.");
            return false;
        }
    }
    console.log("This is a palindrome, true.");
    return true;
}
/*8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
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
  **/
function printShape(shape, height, character){

    switch(shape){
        case "Square":
            let getShape = '\n';
            for(let i = 0; i <height; i++){
                getShape += character + character + character + "\n";
            }
            console.log(getShape);
            break;
        case "Triangle":

            let getShape1 = '\n';
            let counter = 1;
            let nextIter = 1;
            let currString = "";
            for (let i = 0; i <height; i++){
                while (counter >= 1){
                    currString += character;
                    counter -= 1;
                }
                nextIter += 1;
                counter = nextIter;
                getShape1 += currString + "\n";
                currString = "";
            }
            console.log(getShape1);
            break;
        case "Diamond":
            let getShapeee = "\n";
            let counterr = 1;
            let nextIterr = 1;
            let currStringg = "";
            let space = n-1;
            //First half
            for(let i = 0; i < height/2-1; i++){

                while(counterr>=1){
                    currStringg += character;
                    counterr -= 1;
                }
                nextIterr += 2;
                counterr = nextIterr;
                for(i =0; i < space; i++){
                    getShape += " ";
                }
                getShapeee += currStringg + "\n";
                currStringg = "";
            }
            while(counterr>=1){
                currStringg += character;
                counterr -= 1;
            }
            getShapeee+= currStringg + "\n";
            currStringg = "";
            counterr = nextIterr-2;
            nextIterr = nextIterr-2;
            //Second half
            for(let i = height/2-1; i >= 0; i--){
                while(counterr>=1){
                    currStringg += character;
                    counterr -= 1;
                }
                nextIterr -= 2;
                counterr = nextIterr;
                for(i =0; i < space; i++){
                    getShape += " ";
                }
                getShapeee+= currStringg + "\n";
                currStringg = "";
            }
            console.log(getShapeee);
            break;
    }
}
/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
	console.log(someObj);
}
let obj = {};
obj.name = 'this';
obj.number = 2;

traverseObject(obj);
/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
function deleteElement(someArr){
    delete someArr[2];
    console.log(someArr);
}

let someArr = [1,2,3,4];
deleteElement(someArr);

/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function spliceElement(someArr){
	someArr.splice(2,1);
    console.log(someArr);
}

someArr = [1,2,3,4];
spliceElement(someArr);
/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/
function Person(name, age){
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);
/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/ 
 function getPerson(name, age){
	 return this.Person;
 }
 var john = getPerson("John", 30);
 
 
/*-----------------------------------------------------------------------------------
PART II

Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.

NOTE: Part II will be done twice: once with Javascript and once with jQuery.
	  They should be done separately.
	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
-----------------------------------------------------------------------------------
*/
/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/  
 function getUSA(){
    var usa = document.getElementsByTagName("h1");
    console.log(usa);
}
/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales(){
    let arr = [];
    var empName = document.getElementsByClassName("empName");
    var department;

    for (let i = 0;i < empName.length; i++){
        department = empName[i].nextSibling.nextSibling.textContent;
        console.log(department)

        if (department == "Sales")
            arr.push(empName[i].textContent);

    }
    console.log(arr);
}
/*3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/  
 function getAnchorChildren(){
	var span = document.getElementsByClassName("a");
	var children = span.parentNode;
	console.log(children);
 }
/*4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
function getHobbies(){
    var ff = document.getElementById("firstForm").elements.namedItem("skills").textContent;
    console.log(ff);
}
/*5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

(function getCustomAttribute(){
    let customAttr = document.querySelectorAll("[data-customAttr]");
    for(let i = 0; i < customAttr.length; i++){
        console.log(customAttr[i].getAttribute("data-customAttr") + " " + customAttr[i].tagName);
    }
})();


/*6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/

(function onChange(){
    document.getElementById("num1").onchange = function(){ sumEvent()};
    document.getElementById("num2").onchange = function(){ sumEvent()};
})();

function sumEvent(){
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let changeThisHtml = document.getElementById("sum");
    num1 = parseInt(num1);
    num2 = parseInt(num2);
    if(isNaN(num1) || isNaN(num2)){
        changeThisHtml.innerHTML = "Cannot add";
    }
    else{
        changeThisHtml.innerHTML = num1+num2;
    }
}
/*7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/


(function skillsSelected(){
	    for(let i = 0; i < document.getElementsByTagName("select").length; i++){
	        let varr = document.getElementsByTagName("select")[i];
	        if(varr.getAttribute("name")=="skills"){
	            varr.onchange = function(){ popUpAlert(varr.value)};
	        }
	    }
	})();

	function popUpAlert(nameOfSkill){
	    alert("Are you sure " + nameOfSkill + " is one of your skills?");
	}
 


/*8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/



/*9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
*/



/*10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/

(function (){
	let time = document.getElementById("currentTime");
	let currentTime = new Date();
	time = currentTime.getHours()+ ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();
	time.innerHTML = time;
	console.log("The time is: "+time);
})();

/*11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/

(function changeDelayElement(){
    let getId = document.getElementById("helloWorld");
    getId.addEventListener("click", changeRandomText);
})();

function changeRandomText(){
    let getColor = "rgb(" + Math.floor(Math.random() * 256) +", "+
        Math.floor(Math.random() * 256) +", "+
        Math.floor(Math.random() * 256) + ")";
    setTimeout(function(){document.getElementById("helloWorld").style.color=getColor}, 3000);
}

/*12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
 function walkTheDOM(node, func){
     func(node);
     node = node.firstChild;
     while (node) {
         walkTheDOM(node, func);
         node = node.nextSibling;
     }
 }