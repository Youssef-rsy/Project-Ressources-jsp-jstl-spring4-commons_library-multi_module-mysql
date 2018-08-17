<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="/assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Ressource - Projets</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!-- Bootstrap core CSS     -->
<link href="<c:url value="/assets/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<%--     <link href="<c:url value="ressources//assets/css/bootstrap.min.css"/>" rel="stylesheet" />
     <link href="<c:url value="ressources/css/bootstrap.min.css"/>" rel="stylesheet" /> --%>

<!-- Animation library for notifications   -->
<link href="<c:url value="/assets/css/animate.min.css"/>"
	rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link
	href="<c:url value="/assets/css/light-bootstrap-dashboard.css?v=1.4.0"/>"
	rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="<c:url value="/assets/css/demo.css"/>" rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="<c:url value="/assets/css/pe-icon-7-stroke.css"/>"
	rel="stylesheet" />

</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="purple"
			data-image="<c:url value="/assets/img/sidebar-5.jpg"/>">

			<!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text">
						Ressources </a>
				</div>
					<ul class="nav">
					<li class="active"><a href="/Ressources_Presentation/RessourcesProjets/ressource/"> <i class="pe-7s-config"></i>
							<p>Ressources</p>
					</a></li>
					<li ><a href="/Ressources_Presentation/RessourcesProjets/projets/"> <i class="pe-7s-config"></i>
							<p>Projets</p>
					</a></li>

				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">

					<div class="collapse navbar-collapse">

						<!--
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                           <a href="">
                               <p>Account</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
										Dropdown
										<b class="caret"></b>
									</p>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                              </ul>
                        </li>
                        <li>
                            <a href="#">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg"></li>
                    </ul>-->
					</div>
				</div>
			</nav>


			<div class="content">
				<div class="container-fluid">
					<div class="row">


						<div class="col-md-12">

							<div class="card">
								<div class="header">
									<h4 class="title">Gestion des Ressources</h4>

									<!-- Large modal -->
									<button type="button" class="btn btn-success"
										data-toggle="modal" data-target=".ajout">
										<i class="pe-7s-plus"></i> une Ressource
									</button>
									<!-- <button type="button" class="btn btn-primary"
										data-toggle="modal" data-target=".affectation">
										<i class="pe-7s-repeat"></i> Ressource - Projet
									</button> -->

								</div>
								<div id="ressourcetable"
									class="content table-responsive table-full-width">
									<table class="table table-hover table-striped">
										<thead>
											<th>ID</th>
											<th>nom</th>
											<th>prenom</th>
											<!-- <th>Refog</th >-->
											<th>date d'integration</th>
											<th>Status</th>
											<th>Operation</th>
										</thead>
										<tbody>

											<c:forEach items="${listResssources}" var="rs" varStatus="i">
												<tr>
													<td><c:out value="${rs.idRessouces}" /></td>
													<td><c:out value="${rs.nom}" /></td>
													<td><c:out value="${rs.prenom}" /></td>
													<%--<td> <c:out value="${rs.refog}"/> </td>--%>
													<td><c:out value="${rs.dateAffectation}" /></td>
													<td><c:out value="${rs.status}" /></td>
													<td><input type="hidden" value="${rs.idRessouces}"
														name="idval">
														<button type="button" class="btn btn-warning"
															onclick="deleteRessources(${rs.idRessouces})">
															<i class="pe-7s-delete-user"></i>
														</button> <!-- <button type="button" class="btn btn-warning">
															<i class="pe-7s-trash"></i>
														</button> -->
														<button type="button" class="btn btn-primary"
															onclick=" getRessource(${rs.idRessouces})"
															data-toggle="modal" data-target=".edit">
															<i class="pe-7s-tools"></i>
														</button></td>
												</tr>
											</c:forEach>


										</tbody>
									</table>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="modal fade ajout" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nouvelle
						Ressource</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<form >
					<div class="modal-body">
						<div class="form-group">
							<label for="nom" class="col-form-label">Nom:</label> <input
								type="text" class="form-control" id="nom" name="nom">
						</div>
						<div class="form-group">
							<label for="prenom" class="col-form-label">Prenom:</label> <input
								class="form-control" id="prenom" name="prenom">
						</div>
						<!-- <div class="form-group">
							<label for="refog" class="col-form-label">Refog:</label> <input
								type="text" class="form-control" id="refog" name="refog">
						</div> -->
						<div class="form-group">
							<label for="integration" class="col-form-label">Date
								d'integration:</label> <input type="date" class="form-control"
								id="dateAffectation" name="dateAffectation">
						</div>
						<div class="form-group">
							<label for="integration" class="col-form-label">Status:</label>  <select
								class="form-control" id="status" name="status">
								<option>Developper</option>
								<option>Testeur</option>
								<option>Responsable</option>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fermer</button>
						<button type="button" class="btn btn-primary" id="addRessource">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade affectation" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New message</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="height: 120%;">
					<form>
						<div class="form-group col-md-6">
							<label for="exampleSelect1">Select Ressources</label> 
							 <select class="form-control" id="responsableAff" name="responsableAff" multiple>
								<c:forEach items="${listNonResponsables}" var="resp" varStatus="i">
												<option value="<c:out value="${resp.idRessouces}" />">${resp.nom}</option>
											</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-6">
							<label for="exampleSelect1">Select Projet</label><select class="form-control" id="projetAff" name="projetAff" >
								<c:forEach items="${listProjets}" var="proj" varStatus="i">
												<option value="<c:out value="${proj.idProjet}" />">${proj.nom}</option>
											</c:forEach>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary">Affecter</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade edit" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New message</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form>
				<div class="modal-body">
					
						<div class="form-group">
							<label for="nomUp" class="col-form-label">Nom:</label> <input
								type="text" class="form-control" id="nomUp" name="nom">
						</div>
						<div class="form-group">
							<label for="prenom" class="col-form-label">Prenom:</label> <input
								class="form-control" id="prenomUp" name="prenom">
						</div>

						<div class="form-group">
							<label for="integration" class="col-form-label">Date
								d'integration:</label> <input type="date" class="form-control"
								id="dateAffectationUp" name="dateAffectation" value="2017-06-01" >
						</div>
						<div class="form-group">
							 <label
								for="exampleSelect1">Example select</label> <select
								class="form-control" id="statusUp" name="status">
								<option id="id1">Developper</option>
								<option id="id2">Testeur</option>
								<option id="id3">Responsable</option>
							</select>
						</div>
					<input type="hidden" name="idRessouces" id="idRessoucesUp">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" id="updateRessource">Enregistrer</button>
				</div>
				</form>
			</div>
		</div>
	</div>

</body>


<script src="<c:url value="/assets/js/jquery.3.2.1.min.js" />"
	type="text/javascript"></script>
<!--   Core JS Files   -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var url = "http://localhost:8080/Ressources_Presentation/RessourcesProjets/";

	/****************delete******************/
	function deleteRessources(id) {
		var urn = "ressource/delete/" + id;
		var uri = url + urn;
		$.ajax({
			url : uri,
			type : 'GET',
			success : function(data) {
				window.location.reload();
			},
			error : function(jqXHR, exception) {
				var msg = '';
				if (jqXHR.status === 0) {
					msg = 'Not connect.\n Verify Network.';
				} else if (jqXHR.status == 404) {
					msg = 'Requested page not found. [404]';
				} else if (jqXHR.status == 500) {
					msg = 'Internal Server Error [500].';
				} else if (exception === 'parsererror') {
					msg = 'Requested JSON parse failed.';
				} else if (exception === 'timeout') {
					msg = 'Time out error.';
				} else if (exception === 'abort') {
					msg = 'Ajax request aborted.';
				} else {
					msg = 'Uncaught Error.\n' + jqXHR.responseText;
				}
				console.log(msg);
			}
		});
	}
	;


	/*********************GET ONE **********************************/
	function getRessource(id) {
		var urn = "ressource/" + id;
		var uri = url + urn;
		$.ajax({
			url : uri,
			type : 'GET',
			dataType : 'json',
			contentType : "application/json",
			success : function(data) {
				console.log("data :", data);

				$("#nomUp").val(data["nom"]);
				$("#prenomUp").val(data["prenom"]);
				$("#idRessoucesUp").val(data["idRessouces"]);

				//$("#dateAffectationUp").val(data["dateAffectation"]);
				console.log(data["dateAffectation"]);
				var time = new Date(data["dateAffectation"]);
				document.getElementById("dateAffectationUp").valueAsDate = new Date(data["dateAffectation"])
				switch (data["status"]) {
				case $("#id1").val():
					$("#id1 ").attr('selected', 'selected');
					break;
				case $("#id2").val():
					$("#id2 ").attr('selected', 'selected');
					break;
				case $("#id3").val():
					$("#id3 ").attr('selected', 'selected');
					break;
				default:
					;
				}


			},
			error : function(jqXHR, exception) {
				var msg = '';
				if (jqXHR.status === 0) {
					msg = 'Not connect.\n Verify Network.';
				} else if (jqXHR.status == 404) {
					msg = 'Requested page not found. [404]';
				} else if (jqXHR.status == 500) {
					msg = 'Internal Server Error [500].';
				} else if (exception === 'parsererror') {
					msg = 'Requested JSON parse failed.';
				} else if (exception === 'timeout') {
					msg = 'Time out error.';
				} else if (exception === 'abort') {
					msg = 'Ajax request aborted.';
				} else {
					msg = 'Uncaught Error.\n' + jqXHR.responseText;
				}
				console.log(msg);
			}
		});
	}
	;

	$(document).ready(function() {






		var nom;
		var prenom;
		var dateAffectation;
		var status;






/**************************************ADDressources*****************************/

		$("#addRessource").click(function() {
			var urn = "ressource/";
			var uri = url + urn;

			nom = $("#nom").val();
			prenom = $("#prenom").val();
			dateAffectation = $("#dateAffectation").val();
			status = $("#status").val();


			if (nom && prenom && dateAffectation && status) {
				var data = {
					nom : nom,
					prenom : prenom,
					dateAffectation : dateAffectation,
					status : status
				};
				// $.post(uri,formdata,function(data, status){alert(status)});
				var formdata = JSON.stringify(data);
				$.ajax({
					url : uri,
					type : 'POST',
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(data) {
						window.location.reload();
					},
					error : function(jqXHR, exception) {
						var msg = '';
						if (jqXHR.status === 0) {
							msg = 'Not connect.\n Verify Network.';
						} else if (jqXHR.status == 404) {
							msg = 'Requested page not found. [404]';
						} else if (jqXHR.status == 500) {
							msg = 'Internal Server Error [500].';
						} else if (exception === 'parsererror') {
							msg = 'Requested JSON parse failed.';
						} else if (exception === 'timeout') {
							msg = 'Time out error.';
						} else if (exception === 'abort') {
							msg = 'Ajax request aborted.';
						} else {
							msg = 'Uncaught Error.\n' + jqXHR.responseText;
						}
						console.log(msg);
					}
				});
			} else {
				alert("l'un des champs et vide");
			}

		});


/**************************UpdateRessources*****************************************/
		
		$("#updateRessource").click(function() {
			var urn = "ressource/update/"+$("#idRessoucesUp").val();
			var uri = url + urn;

			nom = $("#nomUp").val();
			prenom = $("#prenomUp").val();
			dateAffectation = $("#dateAffectationUp").val();
			status = $("#statusUp").val();


			if (nom && prenom && dateAffectation && status) {
				var data = {
					nom : nom,
					prenom : prenom,
					dateAffectation : dateAffectation,
					status : status
				};
				var formdata = JSON.stringify(data);
				$.ajax({
					url : uri,
					type : 'POST',
					headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(data) {
						window.location.reload();
					},
					error : function(jqXHR, exception) {
						var msg = '';
						if (jqXHR.status === 0) {
							msg = 'Not connect.\n Verify Network.';
						} else if (jqXHR.status == 404) {
							msg = 'Requested page not found. [404]';
						} else if (jqXHR.status == 500) {
							msg = 'Internal Server Error [500].';
						} else if (exception === 'parsererror') {
							msg = 'Requested JSON parse failed.';
						} else if (exception === 'timeout') {
							msg = 'Time out error.';
						} else if (exception === 'abort') {
							msg = 'Ajax request aborted.';
						} else {
							msg = 'Uncaught Error.\n' + jqXHR.responseText;
						}
						console.log(msg);
					}
				});
			} else {
				alert("l'un des champs et vide");
			}

		});
	});
</script>
<%-- <script src="<c:url value="/assets/js/ressources-projets.js" />" type="text/javascript"></script> --%>
<script src="<c:url value="/assets/js/bootstrap.min.js" />"
	type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="<c:url value="/assets/js/chartist.min.js"/>"></script>

<!--  Notifications Plugin    -->
<script src="<c:url value="/assets/js/bootstrap-notify.js"/>"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script
	src="<c:url value="/assets/js/light-bootstrap-dashboard.js?v=1.4.0"/>"></script>

<!--<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'pe-7s-gift',
            	message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

            },{
                type: 'info',
                timer: 4000
            });

    	});
	</script>-->

</html>
