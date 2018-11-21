/**
 * 
 */

console.log("logout created");
let button = document.getElementById("logOutButton");
button.addEventListener("click", logOut);


function logOut() {
    //console.log("attempting logout")
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "/ReimburseSys/logOut", true);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //console.log('Ready state: ' + xmlHttp.readyState);
            //console.log(xmlHttp.response);
        }
        //console.log(xmlHttp.status, " ", xmlHttp.readyState);
    };

    xmlHttp.send();
    localStorage.clear();
    document.getElementsByTagName("body").innerHtml = "";
    window.location="/ReimburseSys/index.html";
    

}