
function getAll(){
    fetch('/fans/getAll')
    .then(res => {
        res.json().then(body => {
                data = JSON.stringify(body);
                console.log(data);
                displayAllInBody(body); 
           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })
}

    

function create(){

    let player = document.getElementById("player").value;
    let haters = document.getElementById("haters").value;
    let supporters = document.getElementById("supporters").value;
    
    console.log(JSON.stringify({

        "player": player,
        "haters": haters,
        "supporters": supporters,

    }))

    fetch("/fans/create?", {
            method: "POST",
            body: JSON.stringify({

                "player": player,
                "haters": haters,
                "supporters": supporters,
            }),
            headers: {
                "Content-Type": "application/json"
            }
        } 
    ).then(res => {
        res.json().then(body => {
                console.log(body);
           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })

}


function openTheForm() {
    document.getElementById("addfans").style.display = "block";
  }
  
function closeTheForm() {
    document.getElementById("addfans").style.display = "none";
  }

window.onclick = function (event) {
    let modal = document.getElementById('addfanspopup');
    if (event.target == modal) {
      closeForm();
    }
  }

function displayAllInBody(res){
    let tbody = document.getElementById("fans-table-body")
    tbody.innerHTML = "";
    res.forEach(fans => {
        tbody.appendChild(populateRow(fans));
    });
}

function displayBody(body){
    let old_tbody = document.getElementById("fans-table-body")
    let new_tbody = document.createElement("tbody");
    new_tbody;
    old_tbody.parentNode.replaceChild(new_tbody, old_tbody);
    new_tbody.id = "fans-table-body";
    populateRow(body);
}

function populateRow(fans){
    let table = document.getElementById("fans-table-body");
    let row = document.createElement("tr");
    let id = document.createElement("th");
    id.scope = "row";
    id.innerHTML = `${fans.id}`;
    row.appendChild(id);
    let player = document.createElement("td");
    player.innerHTML = `${fans.player.firstName}`;
    row.appendChild(player);
    let haters = document.createElement("td");
    haters.innerHTML = `${fans.haters}`;
    row.appendChild(haters);
    let supporters = document.createElement("td");
    supporters.innerHTML = `${fans.supporters}`;
    row.appendChild(supporters);
    return row;
}

function update(){

    let player = document.getElementById("player");
    let haters = document.getElementById("haters").value;
    let supporters = document.getElementById("supporters").value;

 
    console.log(JSON.stringify({

        "player": player,
        "haters": haters ,
        "supporters": supporters
    }))
    
    fetch(`/fans/update?=${id}`, {
            method: "PUT",
            body: JSON.stringify({

                "player": player,
                "haters": haters ,
                "supporters": supporters

            }),
            headers: {
                "Content-Type": "application/json"
            }
        } 
    ).then(res => {
        res.json().then(body => {
                console.log(body);
           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })
}

function openUpdateForm() {
    document.getElementById("updatefans").style.display = "block";
}
  
function closeUpdateForm() {
    document.getElementById("updatefans").style.display = "none";
}


function deletePlayer(){

    let id = document.getElementById("deletefansId").value;
    
    fetch(`fans/delete/${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        } 
    ).then(res => {
        res.json().then(body => {
                console.log(body);
           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })
}

function openDeleteForm() {
    document.getElementById("deletefans").style.display = "block";
}

function closeDeleteForm() {
    document.getElementById("deletefans").style.display = "none";
}