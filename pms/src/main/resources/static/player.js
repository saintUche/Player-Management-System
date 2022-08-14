
function getAll(){
    fetch('/player/getAll')
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

    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let kitNumber = document.getElementById("kitNumber").value;
    let position = document.getElementById("position").value;
    let age = document.getElementById("age").value;
    
    console.log(JSON.stringify({

        "firstName": firstName,
        "lastName": lastName ,
        "kitNumber": kitNumber,
        "position": position,
        "age": age
    }))

    fetch("/player/create?", {
            method: "POST",
            body: JSON.stringify({

                "firstName": firstName,
                "lastName": lastName,
                "kitNumber": kitNumber,
                "position": position,
                "age": age
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
    document.getElementById("addplayer").style.display = "block";
  }
  
function closeTheForm() {
    document.getElementById("addplayer").style.display = "none";
  }

window.onclick = function (event) {
    let modal = document.getElementById('addplayerpopup');
    if (event.target == modal) {
      closeForm();
    }
  }

function displayAllInBody(res){
    let tbody = document.getElementById("player-table-body")
    tbody.innerHTML = "";
    res.forEach(player => {
        tbody.appendChild(populateRow(player));
    });
}

function displayBody(body){
    let old_tbody = document.getElementById("player-table-body")
    let new_tbody = document.createElement("tbody");
    new_tbody;
    old_tbody.parentNode.replaceChild(new_tbody, old_tbody);
    new_tbody.id = "player-table-body";
    populateRow(body);
}

function populateRow(player){
    let table = document.getElementById("player-table-body");
    let row = document.createElement("tr");
    let id = document.createElement("th");
    id.scope = "row";
    id.innerHTML = `${player.id}`;
    row.appendChild(id);
    let firstName = document.createElement("td");
    firstName.innerHTML = `${player.firstName}`;
    row.appendChild(firstName);
    let lastName = document.createElement("td");
    lastName.innerHTML = `${player.lastName}`;
    row.appendChild(lastName);
    let kitNumber = document.createElement("td");
    kitNumber.innerHTML = `${player.kitNumber}`;
    row.appendChild(kitNumber);
    let position = document.createElement("td");
    position.innerHTML = `${player.position}`;
    row.appendChild(position);
    let age = document.createElement("td");
    age.innerHTML = `${player.age}`;
    row.appendChild(age);
    return row;
}


function update(){

    let id = document.getElementById("playerId");
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let kitNumber = document.getElementById("kitNumber").value;
    let position = document.getElementById("position").value;
    let age = document.getElementById("age").value;

 
    console.log(JSON.stringify({

        "firstName": firstName,
        "lastName": lastName ,
        "kitNumber": kitNumber,
        "position": position,
        "age": age
    }))
    
    fetch(`/player/update?=${id}`, {
            method: "PUT",
            body: JSON.stringify({

                "firstName": firstName,
                "lastName": lastName ,
                "kitNumber": kitNumber,
                "position": position,
                "age": age

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
    document.getElementById("updateplayer").style.display = "block";
}
  
function closeUpdateForm() {
    document.getElementById("updateplayer").style.display = "none";
}


function deletePlayer(){

    let id = document.getElementById("deleteplayerId").value;
    
    fetch(`player/delete/${id}`, {
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
    document.getElementById("deleteplayer").style.display = "block";
}