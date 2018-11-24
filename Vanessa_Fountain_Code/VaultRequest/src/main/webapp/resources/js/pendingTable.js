
$(function singlePageTablePending(){
	var xhr = new XMLHttpRequest(),
    method = "GET",
    url = "reqTablePending.json";
	xhr.open(method, url, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {
		 //console.log(xhr.responseText);
		jData = JSON.parse(xhr.responseText);
		//console.log(jData);
		pendingTable = [];
		for(var key in jData){
			
			str = JSON.stringify(key);
			//console.log(jData[key]);

			pendingTable.push(str);
		}
	  }
	}; 
	xhr.send();
});

function singlePageTableApprove(reimbKey){
	key = JSON.parse(reimbKey);
	
	value = jData[key]
	console.log(jData[key]);
	var xhr = new XMLHttpRequest(),
    method = 'POST',
    url = 'reqTableApprove.json';
	xhr.open(method, url + '?reimbKey='+value, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {
		  console.log("inside single page table approve");
//		jData = JSON.parse(xhr.responseText);
//		pendingTable = [];
//		for(var i in jData){
//			str = JSON.stringify(i);
//			pendingTable.push(str);
//		}
	  }
	}; 
	xhr.send();
}

$(function() {
    $('#pending').on('click', function() {
        var tableClone;
        	
        var two = $('#2');
        two.prop('innerHTML', " ");
        two.prop('innerHTML',pendingTable[0]);
        $(tableClone).appendTo(two);
	      $(function() {
	      $('#2').on('click', function() {
	          var tc = $.clone(this);
	          var stage = $('#showTableHereWhenTableIsClicked');
	          singlePageTableApprove(pendingTable[0]);
	          //stage.prop('innerHTML',"Would you like to approve this request?");
	          $(tc).appendTo(stage);

	      });
	  });
        
        var three = $('#3');
        three.prop('innerHTML'," ");
        three.prop('innerHTML',pendingTable[1]);
        $(tableClone).appendTo(three);
        
        var four = $('#4');
        four.prop('innerHTML'," ");
        four.prop('innerHTML',pendingTable[2]);
        $(tableClone).appendTo(four);
        
        var five = $('#5');
        five.prop('innerHTML'," ");
        five.prop('innerHTML',pendingTable[3]);
        $(tableClone).appendTo(five);
        
        var six = $('#6');
        six.prop('innerHTML',pendingTable[4]);
        $(tableClone).appendTo(six);
        
        var seven = $('#7');
        seven.prop('innerHTML'," ")
        seven.prop('innerHTML',pendingTable[5]);
        $(tableClone).appendTo(seven);
        
        var eight = $('#8');
        eight.prop('innerHTML'," ");
        eight.prop('innerHTML',pendingTable[6]);
        $(tableClone).appendTo(eight);
        
        var nine = $('#9');
        nine.prop('innerHTML'," ");
        nine.prop('innerHTML',pendingTable[7]);
        $(tableClone).appendTo(nine);
        
        var ten = $('#10');
        ten.prop('innerHTML'," ");
        ten.prop('innerHTML',pendingTable[8]);
        $(tableClone).appendTo(ten);
        
        var eleven = $('#11');
        eleven.prop('innerHTML'," ");
        eleven.prop('innerHTML',pendingTable[9]);
        $(tableClone).appendTo(eleven);
        
        var twelve = $('#12');
        twelve.prop(" ");
        twelve.prop('innerHTML'," ");
        twelve.prop('innerHTML',pendingTable[10]);
        $(tableClone).appendTo(twelve);
    });
});