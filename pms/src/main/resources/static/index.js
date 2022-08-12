function updateCall(item){
    fetch(`player/update?id=${item.id}`,{
            method:"POST",
            body:JSON.stringify(item),
            headers:{
                "Content-Type":"application/json"
            }
        
        }).then(res => {
        
        
            res.json().then(body => {
                document.body.innerHTML = JSON.stringify(body)
            })
        
        
        }).catch(err =>{
            console.log(err)
            document.body.innerHTML= `<p>Error: ${err.message}</p>`
        })

}

function searchCall(item){
    fetch(`player/search?firstname=${item.firstName}?lastName=${item.lastName}`,{
            method:"",
            body:JSON.stringify(item),
            headers:{
                "Content-Type":"application/json"
            }
        
        }).then(res => {
        
        
            res.json().then(body => {
                document.body.innerHTML = JSON.stringify(body)
            })
        
        
        }).catch(err =>{
            console.log(err)
            document.body.innerHTML= `<p>Error: ${err.message}</p>`
        })

}

player = {
    "kitNumber": "12",
    "firstName": "messi",
    "lastName": "lionel",
    "position": "st",
    "age": 35,
    "id": 1
}

player2 = {
    "kitNumber": "15",
    "firstName": "uche",
    "lastName": "lionel",
    "position": "cb",
    "age": 100,
}

updateCall(player)
searchCall(player)