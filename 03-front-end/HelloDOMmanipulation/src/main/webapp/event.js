//console.log('second js page');

///////old way of doing things
function myFunc(vari){
	console.warn('stuff about warnings: '+ vari);
}


let buttonOne = document.getElementById('button');
//in this case, myFuncTwo is a callback function, meaning
//	after the click event returns the callback function will fire
//A higher order function calls a callback function upon completing
buttonOne.addEventListener('click', myFuncTwo);

function myFuncTwo(eve){
	//console.log(eve);
	/*console.log(eve.target);//displays target element
	console.log(eve.clientY);
	console.log("clientx: "+eve.clientX);//mouse position in window
	console.log("offsetx: "+eve.offsetX);//mouse position in respect to
										// the element
*/	console.log(eve.altKey);
}
/*other events: onsubmit, onchange, click, dblclick, mouseup,
 * 		mousedown, mouseenter, mouseleave, mouseover, mouseout,
 * 		mousemove
 * 		(mouseover includes children, mouseenter doesn't)
 * 		(same with mouseleave and mouseout respectively)
 * 
 * 		
 */
buttonOne.addEventListener('mouseout', myFuncThree);

function  myFuncThree(eveThree){
	console.log(eveThree.type);
}

/*there's also
 * 		keyup, keydown, keypress, cut, paste, change(state change)
 * 		,submit
 */

let body=document.querySelector('body');
body.addEventListener('mousemove', myFuncFour);

function myFuncFour(eve){
	console.log(eve.type);
	body.style.backgroundColor="rgb("+eve.offsetX+","+eve.offsetY+
					", 40)";
}













