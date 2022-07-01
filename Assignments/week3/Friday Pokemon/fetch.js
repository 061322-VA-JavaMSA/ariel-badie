// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id
    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object
    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    let data = await httpResponse.json();

    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {
    console.log(response);
    var table = document.createElement('table');
  var rows =  2;
  var cols =  2;
  for (var r = 0; r < rows; r++){
    let tr;
    tr = document.createElement('tr');
    for(var c = 0; c < cols; c++){
        var td;
        if (r === 0 ) {
            td = document.createElement('th');
            if(c === 0) td.innerHTML = 'name';
            else {td.innerHTML = 'hieght';
            }
        }
        else{ 
            td = document.createElement('td');
            if(c === 0) td.innerHTML = response.name;
            else { 
            td.innerHTML = response.height;
            }

        }
        tr.appendChild(td);
    }
    table.appendChild(tr);
  }
  tableSec.appendChild(table);

}


