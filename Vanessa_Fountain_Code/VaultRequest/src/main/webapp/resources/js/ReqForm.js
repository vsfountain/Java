singlePageTable();

function singlePageTable(){
	var xhr = new XMLHttpRequest(),
    method = "GET",
    url = "reqTable.json";
	xhr.open(method, url, true);
	xhr.onreadystatechange = function () {
	  if(xhr.readyState === 4 && xhr.status === 200) {
		jsonData = JSON.parse(xhr.responseText);
	    console.log(jsonData);
		console.log(xhr.responseText);
	  }
	};
	xhr.send();
}

//GET JSON OBJECT OUT
function getObj(){
	fullTable = JSON.stringify(jsonData);
	return fullTable;
	
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
    $('li').on('click', function() {
        var tableClone = $.clone(this);
        var stage = $('#showTableHereWhenTableIsClicked');
        stage.prop('innerHTML', getObj());
        $(tableClone).appendTo(stage);
    });
});



