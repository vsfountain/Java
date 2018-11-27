/**
 * 
 */

console.log("logout created");
let button = document.getElementById("logOutButton");
button.addEventListener("click", logOut);


function logOut() {
    //console.log("attempting logout")


    document.getElementById('user').innerHTML = "";
    document.getElementsByTagName("body").innerHtml = "";
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "/ReimburseSys/logOut", true);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            let tableBod = document.getElementById("body");
            while (tableBod.firstChild) {
                document.getElementById("body").removeChild(tableBod.firstChild);
            }
            //console.log('Ready state: ' + xmlHttp.readyState);
            //console.log(xmlHttp.response);
        }
        //console.log(xmlHttp.status, " ", xmlHttp.readyState);
    };

    xmlHttp.send();

    console.log("the body of the table:", document.getElementById("body").innerHTML);

    console.log("the body of the table2:", document.getElementById("body").innerHTML);
    window.location = "/ReimburseSys/index.html";


}