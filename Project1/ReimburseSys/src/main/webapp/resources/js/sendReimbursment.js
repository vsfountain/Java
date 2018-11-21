/**
 * 
 */

function sendReimburse() {
    let theForm = document.getElementById("reimburseTable");
    console.log("TRYING TO APPLY FOR REIMBURSMENT")
    var item = {

        "ammount": document.getElementById("ammount").value,
        "type": document.getElementsByName("type").selected,
        "desc": document.getElementsByName("desc").value
    };
        console.log(document.getElementsByName("type").value);
        console.log(JSON.stringify(item));
        console.log(document.getElementsByName("desc").value);
        let amount = document.getElementById("ammount").value;
        let type = document.querySelector('input[name = "type"]:checked').value;;
        let desc = document.getElementById('desc').value;

    var xmlhttp = new XMLHttpRequest();
    let params = 'ammount='+amount+'&type='+type+'&desc='+desc;
    console.log(params);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log('GOOD')

            console.log(xmlhttp.responseText);
            var json = JSON.parse(xmlhttp.responseText);
            console.log(json);

        }

    };
    let form = document.getElementById("reimburseForm");
    console.log(form);
    let formData = new FormData(form);
    console.log(formData)

    xmlhttp.open('POST', '/ReimburseSys/sendReimburse', true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    console.log("trying to send", JSON.stringify(item));
    xmlhttp.send(params);
    return false;
}