var currentActivedId="dashboard";
function locationUrl(url,activeId){
	if(currentActivedId != null && currentActivedId != "" && activeId != null && activeId != ""){
		$("#"+currentActivedId).removeClass("active");
		$("#"+activeId).addClass("active");
		mainActiveId = activeId;
	}
	goUrl(url,null);
}


var xmlhttp = new getXMLObject();
function goUrl(url,params) {
	if(xmlhttp) {
		//var params = "";
		xmlhttp.open("GET",url,true);
		xmlhttp.onreadystatechange = handleServerResponse;
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8');
		xmlhttp.send(params);
	}
}



//XML OBJECT
function getXMLObject() {
	var xmlHttp = false;
	try {
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP") // For Old Microsoft
														// Browsers
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") // For Microsoft
																// IE 6.0+
		} catch (e2) {
			xmlHttp = false // No Browser accepts the XMLHTTP Object then false
		}
	}
	if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
		xmlHttp = new XMLHttpRequest(); // For Mozilla, Opera Browsers
	}
	return xmlHttp; // Mandatory Statement returning the ajax object created
}

function handleServerResponse() {
	if (xmlhttp.readyState == 4) {
		//document.getElementById("mainSection").innerHTML =xmlhttp.responseText;
		var text = xmlhttp.responseText;
		if(text.indexOf("<title>Favorites error Page</title>") >= 0){
			window.location.href="/error.html";
		}else{
			$("#main").html(xmlhttp.responseText);
		}
	}
}