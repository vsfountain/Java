/**
 * 
 */


function validateAmountField() {
	var x = document.getElementsByTagName("form")[1]["amount"].value;
	var isnum = !isNaN(x);
	console.log(x);
	console.log(isnum);
	if(!isnum) {
		var xxxxx = document.getElementById("aa");
		if(xxxxx == null) {
			var xxxxxxxx = document.createElement('style');
			var e = '#oo:hover{ cursor: not-allowed; }';
			if(xxxxxxxx.styleSheet) {
				xxxxxxxx.styleSheet.cssText = e;
			} else {
				xxxxxxxx.appendChild(document.createTextNode(e));
			}
			document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
			var xxxxxxx = document.getElementsByTagName("button")[1];
			xxxxxxx.disabled = true;
			var xx = document.createElement("span");
			xx.setAttribute("style", "color:red;font-size:12px;margin-bottom:20px;margin-left:83px;");
			xx.setAttribute("id", "aa");
			xx.textContent="Amount must be a valid number";
			var xxxx = document.getElementsByTagName("form")[1]["amount"];
			xxxx.parentNode.insertBefore(xx, xxxx.nextSibling);
		} else if(xxxxx.textContent == "Decimal count cannot be greater than 2" || xxxxx.textContent == "Cannot have more than single Decimal Point") {
			var xxxxxxxx = document.createElement('style');
			var e = '#oo:hover{ cursor: not-allowed; }';
			if(xxxxxxxx.styleSheet) {
				xxxxxxxx.styleSheet.cssText = e;
			} else {
				xxxxxxxx.appendChild(document.createTextNode(e));
			}
			document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
			var xxxxxxx = document.getElementsByTagName("button")[1];
			xxxxxxx.disabled = true;
			xxxxx.parentNode.removeChild(xxxxx);
			var xx = document.createElement("span");
			xx.setAttribute("style", "color:red;font-size:12px;margin-bottom:20px;margin-left:83px;");
			xx.setAttribute("id", "aa");
			xx.textContent="Amount must be a valid number";
			var xxxx = document.getElementsByTagName("form")[1]["amount"];
			xxxx.parentNode.insertBefore(xx, xxxx.nextSibling);
		}
	} else if(isnum) {
		if(x == "") {
			var xxxxxxxx = document.createElement('style');
			var e = '#oo:hover{ cursor: not-allowed; }';
			if(xxxxxxxx.styleSheet) {
				xxxxxxxx.styleSheet.cssText = e;
			} else {
				xxxxxxxx.appendChild(document.createTextNode(e));
			}
			document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
			var xxxxxxx = document.getElementsByTagName("button")[1];
			xxxxxxx.disabled = true;
		}else {
		var xx = x.split(".");
		if(xx.length == 1) {
			var xxxxx = document.getElementById("aa");
			if(xxxxx == null) {
				var xxxxxx = document.getElementById("oo");
				var xxxxxxxx = document.createElement('style');
				var e = '#oo:hover{ cursor: pointer; }';
				if(xxxxxxxx.styleSheet) {
					xxxxxxxx.styleSheet.cssText = e;
				} else {
					xxxxxxxx.appendChild(document.createTextNode(e));
				}
				document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
				var xxxxxxx = document.getElementsByTagName("button")[1];
				xxxxxxx.disabled = false;
			} else {
				xxxxx.parentNode.removeChild(xxxxx);
				var xxxxxx = document.getElementById("oo");
				var xxxxxxxx = document.createElement('style');
				var e = '#oo:hover{ cursor: pointer; }';
				if(xxxxxxxx.styleSheet) {
					xxxxxxxx.styleSheet.cssText = e;
				} else {
					xxxxxxxx.appendChild(document.createTextNode(e));
				}
				document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
				var xxxxxxx = document.getElementsByTagName("button")[1];
				xxxxxxx.disabled = false;
			}
		} else if(xx.length == 2) {
			if(xx[1].length > 2) {
				var xxxxx = document.getElementById("aa");
				if(xxxxx == null) {
					var xxxxxxxx = document.createElement('style');
					var e = '#oo:hover{ cursor: not-allowed; }';
					if(xxxxxxxx.styleSheet) {
						xxxxxxxx.styleSheet.cssText = e;
					} else {
						xxxxxxxx.appendChild(document.createTextNode(e));
					}
					document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
					var xxxxxxx = document.getElementsByTagName("button")[1];
					xxxxxxx.disabled = true;
					var xxxxxx = document.createElement("span");
					xxxxxx.setAttribute("style", "color:red;font-size:12px;margin-bottom:20px;margin-left:120px;");
					xxxxxx.setAttribute("id", "aa");
					xxxxxx.textContent="Decimal count cannot be greater than 2";
					var xxxxxxx = document.getElementsByTagName("form")[1]["amount"];
					xxxxxxx.parentNode.insertBefore(xxxxxx, xxxxxxx.nextSibling);
				} else if(xxxxx.textContent == "Amount must be a valid number" || xxxxx.textContent == "Cannot have more than single Decimal Point") {
					var xxxxxxxx = document.createElement('style');
					var e = '#oo:hover{ cursor: not-allowed; }';
					if(xxxxxxxx.styleSheet) {
						xxxxxxxx.styleSheet.cssText = e;
					} else {
						xxxxxxxx.appendChild(document.createTextNode(e));
					}
					document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
					var xxxxxxx = document.getElementsByTagName("button")[1];
					xxxxxxx.disabled = true;
					xxxxx.parentNode.removeChild(xxxxx);
					var xxxxxx = document.createElement("span");
					xxxxxx.setAttribute("style", "color:red;font-size:12px;margin-bottom:20px;margin-left:120px;");
					xxxxxx.setAttribute("id", "aa");
					xxxxxx.textContent="Decimal count cannot be greater than 2";
					var xxxxxxx = document.getElementsByTagName("form")[1]["amount"];
					console.log(xxxxxxx);
					console.log(xxxxxx);
					xxxxxxx.parentNode.insertBefore(xxxxxx, xxxxxxx.nextSibling);
				}
			} else {
				var xxxxx = document.getElementById("aa");
				if(xxxxx == null) {
					var xxxxxx = document.getElementById("oo");
					var xxxxxxxx = document.createElement('style');
					var e = '#oo:hover{ cursor: pointer; }';
					if(xxxxxxxx.styleSheet) {
						xxxxxxxx.styleSheet.cssText = e;
					} else {
						xxxxxxxx.appendChild(document.createTextNode(e));
					}
					document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
					var xxxxxxx = document.getElementsByTagName("button")[1];
					xxxxxxx.disabled = false;
				} else {
					xxxxx.parentNode.removeChild(xxxxx);
					var xxxxxx = document.getElementById("oo");
					var xxxxxxxx = document.createElement('style');
					var e = '#oo:hover{ cursor: pointer; }';
					if(xxxxxxxx.styleSheet) {
						xxxxxxxx.styleSheet.cssText = e;
					} else {
						xxxxxxxx.appendChild(document.createTextNode(e));
					}
					document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
					var xxxxxxx = document.getElementsByTagName("button")[1];
					xxxxxxx.disabled = false;
				}
			}
		} else {
			var xxxxx = document.getElementById("aa");
			if(xxxxx == null) {
				var xxxxxxxx = document.createElement('style');
				var e = '#oo:hover{ cursor: not-allowed; }';
				if(xxxxxxxx.styleSheet) {
					xxxxxxxx.styleSheet.cssText = e;
				} else {
					xxxxxxxx.appendChild(document.createTextNode(e));
				}
				document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
				var xxxxxxx = document.getElementsByTagName("button")[1];
				xxxxxxx.disabled = true;
				var xxxxxx = document.createElement("span");
				xxxxxx.setAttribute("style", "color:red;font-size:12px;margin-bottom:20px;margin-left:120px;");
				xxxxxx.setAttribute("id", "aa");
				xxxxxx.textContent="Cannot have more than single Decimal Point";
				var xxxxxxx = document.getElementsByTagName("form")[1]["amount"];
				xxxxxxx.parentNode.insertBefore(xxxxxx, xxxxxxx.nextSibling);
			} else if(xxxxx.textContent == "Amount must be a valid number" || xxxxx.textContent == "Decimal count cannot be greater than 2") {
				var xxxxxxxx = document.createElement('style');
				var e = '#oo:hover{ cursor: not-allowed; }';
				if(xxxxxxxx.styleSheet) {
					xxxxxxxx.styleSheet.cssText = e;
				} else {
					xxxxxxxx.appendChild(document.createTextNode(e));
				}
				document.getElementsByTagName('head')[0].appendChild(xxxxxxxx);
				var xxxxxxx = document.getElementsByTagName("button")[1];
				xxxxxxx.disabled = true;
				xxxxx.parentNode.removeChild(xxxxx);
				var xxxxxx = document.createElement("span");
				xxxxxx.setAttribute("style", "color:red;font-size:12px;margin-bottom:20px;margin-left:120px;");
				xxxxxx.setAttribute("id", "aa");
				xxxxxx.textContent="Cannot have more than single Decimal Point";
				var xxxxxxx = document.getElementsByTagName("form")[1]["amount"];
				console.log(xxxxxxx);
				console.log(xxxxxx);
				xxxxxxx.parentNode.insertBefore(xxxxxx, xxxxxxx.nextSibling);
			}
		}
		}
	}
	/*if(x)*/
}

function aa() {
	document.getElementsByName("amount")[0].addEventListener("blur", function() {
		
		
		validateAmountField();
	})
	
	
	
}

aa();