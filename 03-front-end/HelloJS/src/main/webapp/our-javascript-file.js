/**
 * 
 */
/*
 * What is javascript?
 * 		JavaScript is a programming/scripting language that allows you to implement complex logic on web pages;
 * 	every time a web page does more than just display static information more than likely JS is at work.
 * 
 * 		It was built mainly for DOM manipulation but it has evolved heavily due to its popularity.
 * 
 * Javascript is a dynamic, loosely-typed, and object oriented language. JS is an interpreted language; meaning it
 * 	has a JIT compiler.
 * 
 *  What is ECMAscript?
 *  	It’s a specification A standard to uphold for scripting languages.
 *		2015/ES6
 *
 *	Do you need semicolons in JS? Nope!
 *	Is ending statements with a semicolon a good idea? Yes. Because it will have less ambiguity.
 */

//a console log is like a system.out.println();
//console.log("we're talking from a separate file!");

//an alerts summons a small window that pauses the javascript
//  until the user clicks a button
//alert('LOOK AT THIS ALERT!');

//demonstrating that alert halts the rest of the application.
//console.log('after the alert');

//document.write('we can write directly to the DOM');

//////////primitive datatypes in javascript
//		number, string, boolean, null, undefined
var num= 5;		//number
var numTwo;		//undefined
//numThree    //undeclared
var name= "Aster 'The Raver'";	//string
		//notice how I have single quotes within double quotes
var isApproved= false;	//boolean
var noMansLand= undefined;	//undefined
var noObj= null;	//null


//typeof(name);
//name= 15;
//typeof(name);

//time for a console == demo, and === (strictly equals)
//5=="5" is true
//5==="5" is false, because === checks type as well

/////////////referenced types
//			arrays, functions, and objects
/*var exArray= ['Monkey', 'Wolf'];  //array
console.log(exArray);

//functions
function exFunc(){
	//this is how we create a function
	console.log('inside our 1st function');
}
console.log(exFunc);

exFunc();

var varFunc= function exFunc2(){
	console.log('my logic');
}
console.log(varFunc);
varFunc();*/

/*//objects
var exObj= {
		name: 'Danny Boy',
		ability: 'Electromagnetic manipulation',
		'bounty': 250000
};

//demonstrating the dynamic nature of objects
console.log(exObj);
console.log(exObj.name);
console.log(exObj.bounty);
console.log(exObj['name']);

//inserting properties on the fly
exObj['role']='mafia leader';
console.log(exObj);
console.log(exObj['role']);
//deleting on the fly
delete exObj.role;
console.log(exObj);*/

//pass by
var passby1= 10;
var passby2= passby1;
passby1= 25;
//console.log(passby2); //10 is the value

//pass by
var passby3= {value: 20};
var passby4= passby3.value;
passby3.value= 50;
//console.log(passby4);

/*//arrays and their dynamic nature
var arrayOfDoggos=['doggo', 'pupper', 'furmissle','goodestboi'];
console.log(arrayOfDoggos);
console.log(arrayOfDoggos[2]);
arrayOfDoggos[4]='woofer';
console.log(arrayOfDoggos);
//changing datatypes in arrays
arrayOfDoggos[0]= 15;
console.log(arrayOfDoggos);*/

//////More on strings
var tempNum=15;
var longString= 'Printing longString: '+ tempNum +
	'and now that we have that...theres more'+
	'and again...more.';
//console.log(longString);
//Template literals (backticks)
// Template literals came along in ECMAscript2015/ES6
var longString2= `Printing longString: ${tempNum}
	and now that we have that....theres more
	and again...more.`;
//console.log(longString2);



///// HOISTING in javascript
// Hoisting- all variable declarations will be brought to the top
//		of the file.
/*printStuff();
function printStuff(){
	console.log('in the printStuff() function');
}*/


///////FALSEY VALUES
function falseDemo(someVar){
	if(someVar){
		console.log("it's true!")
	}else{
		console.log("it's false!");
	}
}

var randomVar= "";
		//0 is false 
		//false is false
		//"" is false
		//null
		//NaN is false
		//undefined is false
		//THESE are our falsey values
	//what are our truthy values?
	//everything else that's not falsey
	
//falseDemo(randomVar);

///////What are the scopes in javascript?
//global, local, block
/*var globalVar=0; // this would be global
function myFunc(){var localVar=6;} //local
function myFunc2(){
	ghostVariable= 17;  //this will be global
		//must call function THEN it will act as a global variable
	if(true){
		let blockVar=8;
	}
	console.log(blockVar);
}
myFunc2();*/
//var   can only have global and local scopes
//let AND const   can have global, local, and block


/////////what is an anonymous function?
// it's a function without a name
//let anoFunc= function(s) {console.log('in anoFunc: '+ s);}
//anoFunc('Abigail');

///////what is a self-invoking function?
//a function that calls itself
/*(function(s){
	console.log('in my self-invoking function: '+s);
})('does this work?');*/


/////////what is a nested function?
//a function within a function.
/*function birdNest(){
	let nextVar= 7;
	function babyBird(){
		nextVar += 1;
		console.log('babybird(): ', nextVar);
	}
	babyBird();
}
birdNest();
birdNest();*/

////////CLOSURE!
//what is closure?
//inner function that has access to the outer function's
//	state.
/*let foo = (function funcName(){
	let bar = 0;
	return function() {
		return bar+=1;
	}
})();
console.log(foo()); //1
console.log(foo());	//2
console.log(foo());	//3
*/
/////////object example, with methods
let tempSuperVillain = {
		name: "Danny Boy",
		ability: "Electromagnetic Manip,",
		doSuperStuff: function(){
			console.log("the most super stuff you can imagine");
		}
}
tempSuperVillain.doSuperStuff();

///////factory function
function supervillainFactory(name, ability){
	return {name,
		ability,
		doSuperStuff: function(){
			console.log('produced in factory');
		}
	}
}
let myVill = supervillainFactory('Phillip',
		'winning rock paper scissors');

console.log(myVill);















