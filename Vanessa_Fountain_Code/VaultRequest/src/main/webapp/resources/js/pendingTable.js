
$(function singlePageTablePending(){
	var xhr = new XMLHttpRequest(),
    method = "GET",
    url = "reqTablePending.json";
	xhr.open(method, url, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {
		jData = JSON.parse(xhr.responseText);
		pendingTable = [];
		for(var i in jData){
			str = JSON.stringify(i);
			pendingTable.push(str);
		}
	  }
	}; 
	xhr.send();
});

//$(function() {
//    $('#pending').on('click', function() {
//        var tableClone = $.clone(this);
//        var stage = $('#showTableHereWhenTableIsClicked');
//        stage.prop('innerHTML', pendingTable);
//        $(tableClone).appendTo(stage);
//        
//    });
//});

$(function() {
    $('#pending').on('click', function() {
    	
        var tableClone;
        	
        var two = $('#2');
        two.prop('innerHTML', " ");
        two.prop('innerHTML',pendingTable[0]);
        $(tableClone).appendTo(two);
        $('#2').on('click', function() {
        	var prompt;
            var stage = $('#showTableHereWhenTableIsClicked');
            stage.prop('innerHTML', "Would you like to approve this request?")
            stage.push("Would you like to approve this request?");
            $(prompt).appendTo(stage);
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