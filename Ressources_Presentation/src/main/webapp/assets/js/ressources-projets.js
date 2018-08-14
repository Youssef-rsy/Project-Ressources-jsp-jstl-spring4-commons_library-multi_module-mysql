$(document).ready(function(){
	alert("hi js");
	
var url = "localhost:8080/Ressources_Presentation/RessourcesProjets/";
	
	var nom;
	var prenom;
	var dateAffectation;
	var status;

	/****************delete******************/
	

	function deleteRes(id){

		alert(id);
		
		
		}




	
    $("#addRessource").click(function(){
			var urn = "ressource/";
			var uri=url+urn;
			
	nom = $("#nom").val();
	prenom = $("#prenom").val();
	dateAffectation =$("#dateAffectation").val();
	status =  $("#status").val();
	
	alert("nom = "+nom  +"prenom : "+prenom+ "dateaffectation : "+dateAffectation +" status : "+status);
	if( nom && prenom && dateAffectation && status){
		alert('begin')
		 $.post(uri,
		{nom :nom , prenom :prenom , dateAffectation:dateAffectation , status:status},
    function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
	/* 	$.ajax({
			  type: "POST",
			  url: uri,
			  data: {nom :nom , prenom :prenom , dateAffectation:dateAffectation , status:status},
			  success:  function (html) {
		         alert(html);
		        },
		      error: function(error){
				aler(error);
			        },
			  dataType: json
			});  */
		alert("end")
		/* $.post(uri,
		        {
		          name: "Donald Duck",
		          city: "Duckburg"
		        },
		        function(data,status){
		            alert("Data: " + data + "\nStatus: " + status);
		        }); */
	 	    
	}else{
		alert("l'un des champs et vide");
	}
    
	});



    
});
