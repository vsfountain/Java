
$(function singlePageTable(){
	var xhr = new XMLHttpRequest(),
    method = "GET",
    url = "reqTable.json";
	xhr.open(method, url, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {		
		jsonData = JSON.parse(xhr.responseText);
		table = [];
		for(var i in jsonData){
			str = JSON.stringify(i);
			table.push(str);
		}
	  }
	};
	xhr.send();
});

//GET JSON OBJECT OUT
//function getObj(){
//	fullTable = JSON.stringify(jsonData);
//	return fullTable;	
//}

$('main').on('focus', 'li', function() {
    $this = $(this);
    $this.addClass('active').siblings().removeClass();
    $this.closest('main').scrollTop($this.index() * $this.outerHeight());
}).on('keydown', 'li', function(e) {
    $this = $(this);
    if (e.keyCode == 40) 
    {$this.next().focus();return false;}
    else if (e.keyCode == 38) 
    {$this.prev().focus(); return false;
    }
}).find('li').first().focus();

$(function() {
    $('#allReq').on('click', function() {
    	//singlePageTable();
        var tableClone ;
        //= $.clone(this);
        var stage = $('#showTableHereWhenTableIsClicked');
        stage.prop('innerHTML', table);
        $(tableClone).appendTo(stage);
        
    });
});

$(function() {
    $('#allReq').on('click', function() {
    	//singlePageTablePending();
        var tableClone ;
        //= $.clone(this);
        var two = $('#2');
        two.prop('innerHTML'," ");
        two.prop('innerHTML',table[0]);
        $(tableClone).appendTo(two);
        
        var three = $('#3');
        three.prop('innerHTML'," ");
        three.prop('innerHTML',table[1]);
        $(tableClone).appendTo(three);
        
        var four = $('#4');
        four.prop('innerHTML'," ");
        four.prop('innerHTML',table[2]);
        $(tableClone).appendTo(four);
        
        var five = $('#5');
        five.prop('innerHTML'," ");
        five.prop('innerHTML',table[3]);
        $(tableClone).appendTo(five);
        
        var six = $('#6');
        six.prop('innerHTML'," ");
        six.prop('innerHTML',table[4]);
        $(tableClone).appendTo(six);
        
        var seven = $('#7');
        seven.prop('innerHTML',table[5]);
        $(tableClone).appendTo(seven);
        
        var eight = $('#8');
        eight.prop('innerHTML'," ");
        eight.prop('innerHTML',table[6]);
        $(tableClone).appendTo(eight);
        
        var nine = $('#9');
        nine.prop('innerHTML', " ");
        nine.prop('innerHTML',table[7]);
        $(tableClone).appendTo(nine);
        
        var ten = $('#10');
        ten.prop('innerHTML', " ");
        ten.prop('innerHTML',table[8]);
        $(tableClone).appendTo(ten);
        
        var eleven = $('#11');
        eleven.prop('innerHTML', " ");
        eleven.prop('innerHTML',table[9]);
        $(tableClone).appendTo(eleven);
        
        var twelve = $('#12');
        twelve.prop('innerHTML', " ");
        twelve.prop('innerHTML',table[10]);
        $(tableClone).appendTo(twelve);
    });
});




