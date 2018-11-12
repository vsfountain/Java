/////
//console.log(document);
/*console.log(document.URL);
console.log(document.title);
console.log(document.doctype);
console.log(document.all);
console.log(document.all[13]);
document.all[13].textContent='Wait,html elements have mailmen?!?';
console.log(document.all[13]);*/
/*console.log(document.links);
console.log(document.images);
console.log(document.forms);*/


//////////GET ELEMENT BY ID
let paraTwo= document.getElementById('para2');
//text content gets all text
//paraTwo.textContent = "Are things about to go wrong?";

//?
//paraTwo.innerText = 'im not <b>gonna let</b> this ruin my day';
//is able to inject elements
//paraTwo.innerHTML = 'im not <b>gonna let</b> this ruin my day';

///////GET ELEMENT BY CLASS NAME
/*let hders= document.getElementsByClassName('headers');
console.log(hders);
hders[1].textContent='Third Title';*/


///styling
//you can change styles of elements with:
//	collection.style.'attribute'=.....
/*for(let i=0; i<hders.length; i++){
	hders[i].style.fontWeight = 'normal';//or bold or a value
}*/

//////GET ELEMENTS BY TAGNAME
//getElementsByTagName('');
//   same as elements by class name



///////////QUERY SELECTOR
//css selectors
//'#' prefix for id, '.' prefix for class, no prefix for an element

//let selection = document.querySelector('#para2');
//let selection = document.querySelector('p');
//let selection = document.querySelectorAll('p');
let selection = document.querySelectorAll('.para-container');


//console.log(selection);
//selection.innerText='blah blah blah';

//we can use selectors in the follow ways:
//	last-child, first-child, nth-child(n)
/*let selectionTwo= document.querySelectorAll('.para:nth-child(2)');
console.log(selectionTwo);*/
///////NAVIGATING THE DOM 
/// other options
//document.querySelectorAll('input[selectorattribute]');
/*
 * 	.parentNode/.parentElement		//node list, collection respectively
 * 	.childNodes/ .childElements		//node list, collection respectively
 * 	.firstChild/.lastChild			//node list
 * .firstElementChild/.lastElementChild	//collections
 * 
 * 	also, next and previous siblings
 * 
 */

///////CREATING
//creating our new element
let newDiv = document.createElement('div');
//populating our new element with attributes
newDiv.id='newestDiv';
newDiv.setAttribute('title', 'div show');
//console.log(newDiv);
//creating a text node, then appending to our new div element
let divText = document.createTextNode('new text node riiiiight here');
newDiv.appendChild(divText);
//appending our new div element onto an existing element that is
//	currently inside of the dom
let newSelection = document.querySelector('#para1');
newSelection.appendChild(newDiv);

//////////DELETE
//// removeAttribue, removeChild, remove

///////////////////////////////////////////////////////
//////I want you to go to any website and play around with altering
// the DOM for that website, on the fly.

//also...try to change the image on google's main page


//.removeAttribute('srcset');
/*
* steps:
* 	let a = document.getElementById('hplogo');
* 	a.removeAttribute('srcset');
* 	a.src='another link';
* 	a.height/width
*/

