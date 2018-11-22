singlePageTable();
singlePageTablePending();

function singlePageTable(){
	var xhr = new XMLHttpRequest(),
    method = "GET",
    url = "reqTable.json";
	xhr.open(method, url, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {
		
		jsonData = JSON.parse(xhr.responseText);
		//console.log(jsonData);
		//console.log(xhr.responseText);
	  }
	};
	xhr.send();
}

//GET JSON OBJECT OUT
function getObj(){
	fullTable = JSON.stringify(jsonData);
	//console.log(fullTable);
	return fullTable;	
}

function singlePageTablePending(){
	var xhr = new XMLHttpRequest(),
    method = "GET",
    url = "reqTablePending.json";
	xhr.open(method, url, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {
		jData = JSON.parse(xhr.responseText);
	    console.log(jData);
		console.log(xhr.responseText);
	  }
	};
	xhr.send();
}

function getPendingObj(){
	pendingTable = JSON.stringify(jData);
	console.log(pendingTable);
	return pendingTable;	
}

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
        var tableClone = $.clone(this);
        var stage = $('#showTableHereWhenTableIsClicked');
        stage.prop('innerHTML', getObj());
        $(tableClone).appendTo(stage);
        
    });
});

$(function() {
    $('#allReq').on('click', function() {
        var tableClone = $.clone(this);
        var stage = $('#2');
        stage.prop('innerHTML', getObj());
        $(tableClone).appendTo(stage);
        
    });
});

$(function() {
    $('#pending').on('click', function() {
        var tableClone = $.clone(this);
        var stage = $('#showTableHereWhenTableIsClicked');
        stage.prop('innerHTML',getPendingObj());
        $(tableClone).appendTo(stage);
        
    });
});
$(function() {
    $('#pending').on('click', function() {
        var tableClone = $.clone(this);
        var stage = $('#2');
        stage.prop('innerHTML',getPendingObj());
        $(tableClone).appendTo(stage);
        
    });
});



