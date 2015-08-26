
function fillCountries() {
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://localhost:8080/simple/rest/values/countries", false );
    xmlHttp.send( null );
    var response = xmlHttp.responseText;
    var b = JSON.parse(response);
    var str = "<select id='country' name='country' onchange='fillStates()'>";
    for(var i=0;i<b.length;i++){
    	str = str+"<option value='"+b[i]["id"]+"'>" +b[i]["name"]+"</option>";
    }
    str = str+"</select>";
    document.getElementById("spanState").innerHTML="";
    document.getElementById("spanCity").innerHTML = "";
    document.getElementById("spanCountry").innerHTML = str;
}

function fillStates() {
	var country = document.getElementById("country");
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET","http://localhost:8080/simple/rest/values/states/getByCountryId/"+country.value,false);
	xmlHttp.send(null);
	var response = xmlHttp.responseText;
	var json = JSON.parse(response);
	 var str = "<select id='state' name='state' onchange='fillCities()'>";
	 
	 for(var i=0;i<json.length;i++) {
		str = str+ "<option value='"+json[i]["id"]+"'>" +json[i]["name"]+"</option>";
	 }
	 str = str+"</select>";
	 document.getElementById("spanCity").innerHTML = "";
	 document.getElementById("spanState").innerHTML=str;
}

function fillCities() {
	var stateId = document.getElementById("state").value;
	var request = new XMLHttpRequest();
	request.open("GET","http://localhost:8080/simple/rest/values/cities/getByStateId/"+stateId,false);
	request.send(null);
	var response = request.responseText;
	var json = JSON.parse(response);
	var str = "<select id='city' name='city'>";
	for(var i=0;i<json.length;i++) {
		str = str + "<option value='"+json[i]["id"]+"'>"+json[i]["name"]+"</option>";
	}
	str = str+"</select>";
	document.getElementById("spanCity").innerHTML = str;
}

function getSignupJson() {
	var str = "{ \"name\":\""++"\",\"id\":\""++"\",\"password\":\""++"\",\"contact\":\""++"\",\"city\":\""++"\",\"id\":\""+
}

