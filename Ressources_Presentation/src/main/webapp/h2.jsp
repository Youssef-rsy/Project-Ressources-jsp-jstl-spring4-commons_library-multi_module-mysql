<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Ressource - Projets</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="<c:url value="assets/css/bootstrap.min.css"/>" rel="stylesheet" />
 <%--     <link href="<c:url value="ressources/assets/css/bootstrap.min.css"/>" rel="stylesheet" />
     <link href="<c:url value="ressources/css/bootstrap.min.css"/>" rel="stylesheet" /> --%>

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="http://www.creative-tim.com" class="simple-text">
                    Ressources
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="#">
                        <i class="pe-7s-config"></i>
                        <p>Ressources</p>
                    </a>
                </li>
                <li class="active">
                        <a href="#">
                            <i class="pe-7s-config"></i>
                            <p>Projets</p>
                        </a>
                    </li>
               
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
                                <h4 class="title">Gestion des Ressources </h4>
                                <!-- Large modal -->
                                <button type="button" class="btn btn-success" data-toggle="modal" data-target=".ajout"><i class="pe-7s-plus"></i> une Ressource</button>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".affectation"><i class="pe-7s-repeat"></i> Ressource - Projet</button>
  
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>ID</th>
                                    	<th>nom</th>
                                    	<th>prenom</th>
                                    	<th>Refog</th>
                                        <th>date d'integration</th>
                                        <th>Status</th>
                                        <th>Operation</th>
                                    </thead>
                                    <tbody>
                                        <tr>

                                            <td>1</td>
                                            <td>nom</td>
                                            <td>prenom</td>
                                            <td>Refog</td>
                                            <td>date d'integration</td>
                                            <td>Status</td>
                                        	<td>
                                                <button type="button" class="btn btn-warning"><i class="pe-7s-delete-user"></i></button>
                                                <button type="button" class="btn btn-warning" ><i class="pe-7s-trash"></i></button>
                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".edit"><i class="pe-7s-tools"></i></button>
                                            </td>
                                        </tr>
                                        
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

<div class="modal fade ajout" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                    <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Nouvelle Ressource</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                    </div>
                          <div class="modal-body">
                            <form>
                            <div class="form-group">
                                <label for="nom" class="col-form-label">Nom:</label>
                                <input type="text" class="form-control" id="nom" name="nom">
                              </div>
                            <div class="form-group">
                                <label for="prenom" class="col-form-label">Prenom:</label>
                                <input class="form-control" id="prenom"name="prenom">
                              </div>
                            <div class="form-group">
                                <label for="refog" class="col-form-label">Refog:</label>
                                <input type="text" class="form-control" id="refog"name="refog">
                                </div>
                            <div class="form-group">
                                <label for="integration" class="col-form-label">Date d'integration:</label>
                                <input type="date" class="form-control" id="integration"name="integration">
                                </div>
                                <div class="form-group">
                                        <label for="integration" class="col-form-label">Status:</label>
                                        <label for="exampleSelect1">Example select</label>
                                        <select class="form-control" id="exampleSelect1">
                                          <option>1</option>
                                          <option>2</option>
                                          <option>3</option>
                                          <option>4</option>
                                          <option>5</option>
                                        </select>
                                </div>   
                            </form>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                            <button type="button" class="btn btn-primary">Ajouter</button>
                          </div>
            </div>
        </div>
    </div>
    <div class="modal fade affectation" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                        <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                  <span aria-hidden="true">&times;</span>
                                </button>
                        </div>
                              <div class="modal-body" style="height: 120%;">
                                <form>
                                        <div class="form-group col-md-6">
                                                <label for="exampleSelect1">Select Ressources</label>
                                                <select multiple class="form-control" id="exampleSelect1">
                                                  <option>1</option>
                                                  <option>2</option>
                                                  <option>3</option>
                                                  <option>4</option>
                                                  <option>5</option>
                                                </select>
                                        </div>   
                                        <div class="form-group col-md-6">
                                                <label for="exampleSelect1">Select Projet</label>
                                                <select class="form-control" id="exampleSelect1" >
                                                  <option>1</option>
                                                  <option>2</option>
                                                  <option>3</option>
                                                  <option>4</option>
                                                  <option>5</option>
                                                </select>
                                        </div>   
                                </form>
                                </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                <button type="button" class="btn btn-primary">Affecter</button>
                              </div>
                </div>
            </div>
            </div>
            <div class="modal fade edit" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                                <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                          <span aria-hidden="true">&times;</span>
                                        </button>
                                      </div>
                                      <div class="modal-body">
                                            <form>
                                                    <div class="form-group">
                                                        <label for="nom" class="col-form-label">Nom:</label>
                                                        <input type="text" class="form-control" id="nom" name="nom">
                                                      </div>
                                                    <div class="form-group">
                                                        <label for="prenom" class="col-form-label">Prenom:</label>
                                                        <input class="form-control" id="prenom"name="prenom">
                                                      </div>
                                                    <div class="form-group">
                                                        <label for="refog" class="col-form-label">Refog:</label>
                                                        <input type="text" class="form-control" id="refog"name="refog">
                                                        </div>
                                                    <div class="form-group">
                                                        <label for="integration" class="col-form-label">Date d'integration:</label>
                                                        <input type="date" class="form-control" id="integration"name="integration">
                                                        </div>
                                                        <div class="form-group">
                                                                <label for="integration" class="col-form-label">Status:</label>
                                                                <label for="exampleSelect1">Example select</label>
                                                                <select class="form-control" id="exampleSelect1">
                                                                  <option>1</option>
                                                                  <option>2</option>
                                                                  <option>3</option>
                                                                  <option>4</option>
                                                                  <option>5</option>
                                                                </select>
                                                        </div>   
                                                    </form>
                                      </div>
                                      <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                        <button type="button" class="btn btn-primary">Enregistrer</button>
                                      </div>
                        </div>
                    </div>
                    </div>
            
</body>
 

    <!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

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