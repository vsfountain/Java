//$('main').on('focus', 'li', function() {
//    $this = $(this);
//    $this.addClass('active').siblings().removeClass();
//    $this.closest('main').scrollTop($this.index() * $this.outerHeight());
//}).on('keydown', 'li', function(e) {
//    $this = $(this);
//    if (e.keyCode == 40) 
//    {$this.next().focus();return false;}
//    else if (e.keyCode == 38) 
//    {$this.prev().focus(); return false;
//    }
//}).find('li').first().focus();
//
//$(function() {
//    $('li').on('click', function() {
//        var tableClone = $.clone(this);
//        var stage = $('#showTableHereWhenTableIsClicked');
//        stage.prop('innerHTML', "");
//        $(tableClone).appendTo(stage);
//    });
//});

singlePageTable();

function singlePageTable(){	
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status==200){
			console.log("should print")
			//xhttp.responeType = 'json';
			console.log(xhttp.responseText);
		
		}
	}
	xhttp.open("GET", 'reqTable.json');
	xhttp.send();
}
















