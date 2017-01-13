<!DOCTYPE html>
<%@page import="com.every.events.model.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>EveryEvents</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="google-signin-scope" content="profile email">
   <meta name="google-signin-client_id" content="818066948922-17koqiqu2j9pfvfhrbd5gjgrjta8mfbc.apps.googleusercontent.com">
   <script src="https://apis.google.com/js/platform.js" async defer></script>
 
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-mockjax/1.6.2/jquery.mockjax.js"></script>
  <script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>
  <script src="http://yourjavascript.com/8001226654/bootstrap-typeahead.js"></script>
  <style>
  body {
      font: 400 15px/1.8 Lato, sans-serif;
      color: #777;
      background-color: #ffffff;
  }
  
  h3, h4 {
      margin: 10px 0 30px 0;
      letter-spacing: 10px;
      font-size: 20px;
      color: #111;
  }
  .container {
      padding: 80px 120px;
  }
  .person {
      border: 10px solid transparent;
      margin-bottom: 25px;
      width: 80%;
      height: 80%;
      opacity: 0.7;
  }
  .person:hover {
      border-color: #f1f1f1;
  }
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
  }
  .carousel-caption h3 {
      color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  .bg-1 {
      background: #ffffff;
      color: #bdbdbd;
  }
  .bg-1 h3 {color: #ff5722;}
  .bg-1 p {font-style: italic;}
  .list-group-item:first-child {
      border-top-right-radius: 0;
      border-top-left-radius: 0;
  }
  .list-group-item:last-child {
      border-bottom-right-radius: 0;
      border-bottom-left-radius: 0;
  }
  .thumbnail {
      padding: 0 0 15px 0;
      border-color:#777;
      border-radius: 0;
     
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
      height: 25px;
  }
  .btn {
      padding: 10px 20px;
      color: #f1f1f1;
      transition: .2s;
      background-color: #d9534f;
      border-radius: 0px;
  }
  .btn:hover, .btn:focus {
      color: #f1f1f1
  }
  .modal-header, h4, .close {
      background-color: #1abc9c;
      color: #fff !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-header, .modal-body {
      padding: 10px 20px;
  }
  .nav-tabs li a {
      color: #777;
  }
  #googleMap {
      width: 100%;
      height: 400px;
     
  }
  .navbar {
      font-family: Montserrat, sans-serif;
      margin-bottom: 0;
      background-color: #2d2d30;
      border: 0;
      font-size: 11px !important;
      letter-spacing: 4px;
      opacity: 0.9;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #d5d5d5 !important;
  }
  .navbar-nav li a:hover {
      color: #fff !important;
  }
  .navbar-nav li.active a {
      color: #fff !important;
      background-color: #29292c !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
  }
  .open .dropdown-toggle {
      color: #fff;
      background-color: #555 !important;
  }
  .dropdown-menu li a {
      color: #000 !important;
  }
  .dropdown-menu li a:hover {
      background-color: red !important;
  }
  footer {
      background-color: #2d2d30;
      color: #f5f5f5;
      padding: 32px;
  }
  footer a {
      color: #f5f5f5;
  }
  footer a:hover {
      color: #777;
      text-decoration: none;
  }
  .form-control {
      border-radius: 0;
  }
  textarea {
      resize: none;
  }
  
    body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }
  
  h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }
  
  .jumbotron {
    position: relative;
    background: #000 url("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSks10L-xRjFcsiOXcLCLimsTB3q8iCwkwvPzVF-FKLIo4d2Eg8oQ") center center;
    width: 100%;
    height: 100%;
    background-size: cover;
    overflow: hidden;
    color: #fff;
      padding: 130px 25px;
      font-family: Montserrat, sans-serif;
 
}
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<c:if test="${status == 0}">
                   <script>$('#myModal').modal('show');</script>
</c:if>  
     
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/homepage" >EveryEvent</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/homepage">HOME</a></li>
         <li><a href="${pageContext.request.contextPath}/eventsReq">EVENTS</a></li>
        <li><a href="${pageContext.request.contextPath}/meetupsReq">MEETUPS</a></li>
        <li><a href="${pageContext.request.contextPath}/placesReq">PLACES</a></li>
       
        <c:if test="${sessionScope.userSession.role.role_name eq 'admin'}">
	         <li class="dropdown">
	          <a class="dropdown-toggle" data-toggle="dropdown" href="#">ADMIN
	          <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="${pageContext.request.contextPath}/showAllUsers">USERS</a></li>
	            <li><a href="#">EVENTS</a></li>
	            <li><a href="#">GROUPS</a></li>
	          </ul>
	        </li>
        </c:if>
             <li><a href="${pageContext.request.contextPath}/newEvent" ><font color="#1abc9c"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Create Event</font></a></li>    <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
     	  
         <c:if test="${sessionScope.locationset!=NULL}">
               		 <li><a data-toggle="modal" data-target="#cityModal"><span class="glyphicon glyphicon-map-marker"></span> ${sessionScope.locationset.city} </a></li>
         </c:if>
         <c:if test="${sessionScope.locationset == NULL}">
               		 <li> <a data-toggle="modal" data-target="#cityModal"><span class="glyphicon glyphicon-map-marker"></span>Set Location</a></li>
         </c:if>
         
     	 <c:if test="${sessionScope.userSession==NULL}">
              		 <li> <a data-toggle="modal" data-target="#myModal">LOG IN</a></li>
              </c:if>
              <c:if test="${sessionScope.userSession != NULL}">
         			    
         			     <li class="dropdown">
                          <a class="dropdown-toggle" data-toggle="dropdown" href="#">    <img src="${sessionScope.userSession.googleImgUrl}" class="img-circle"  width="20" height="20">           			     
				       ${sessionScope.displayName}
				          <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				           <li><a href="${pageContext.request.contextPath}/accountReq">My Account</a></li>
				            <li><a href="${pageContext.request.contextPath}/showMyEventsReq">EVENTS</a></li>
				              <c:if test="${sessionScope.googleUser!=NULL}">
              		            <li><a href="#" onclick="signOut();">Log out</a></li>
              		            <script>
              		        	      function signOut() {
			              		        var auth2 = gapi.auth2.getAuthInstance();
			              		        auth2.signOut().then(function () {
			              		          console.log('User signed out.');
			              		          window.location="${pageContext.request.contextPath}/logout";
			              		        });
			              		      }
              		            </script>
				 			 </c:if>
				 			 <c:if test="${sessionScope.googleUser==NULL}">
              		            <li><a data-toggle="modal"  href="${pageContext.request.contextPath}/logout">Log out</a></li>
				 			 </c:if>
                        </ul>
				        </li>
         			 
         			 
             </c:if>
     	 	 <c:if test="${sessionScope.userSession==NULL}">
              		 <li> <a data-toggle="modal" data-target="#myModal">SIGN UP</a></li>
             </c:if>
      </ul>
    </div>
  </div>
</nav>    
    
    <c:if test="${status == 0}">
                   <script>$('#myModal').modal('show');</script>
    </c:if>  
    
    
 <div class="jumbotron text-center">
  <h1>Events</h1>
  <p>Explore Places Near You</p>
  <form class="form-inline" method="POST" action="searcheventsReq">
   	 <input id="topic" type="text" name="topic" size=20 class="form-control" style="border-radius: 4px;" placeholder="Topic..." autocomplete="on" />
        <script>
            $(function() {
                function displayResult(item) {
                    $('.alert').show().html('You selected <strong>' + item.value + '</strong>: <strong>' + item.text + '</strong>');
                }
                $('#topic').typeahead({
                    source: [
                        {id: 1, name: 'Music'},
                        {id: 2, name: 'Meetups'},
                        {id: 3, name: 'Tech'},
                        {id: 4, name: 'Education'},
                        {id: 5, name: 'Concerts'},
                        {id: 6, name: 'Phorograpgy'},
                        {id: 7, name: 'Social'},
                        {id: 8, name: 'hackathon'},
                        {id: 9, name: 'Movie'},
                        {id: 10, name: 'Fitness'},
                        {id: 11, name: 'All'}
                    ],
                    onSelect: displayResult
                });
            });	
        </script>
	  <input id="city" type="text" name="city" size=20 class="form-control" style="border-radius: 4px;" placeholder="Search cities..." autocomplete="on" />
        <script>
            $(function() {
                function displayResult(item) {
                    $('.alert').show().html('You selected <strong>' + item.value + '</strong>: <strong>' + item.text + '</strong>');
                }
                $('#city').typeahead({
                    source: [
                        {id: 1, name: 'san jose'},
                        {id: 2, name: 'fremont'},
                        {id: 3, name: 'hayward'},
                        {id: 4, name: 'buffalo'},
                        {id: 5, name: 'boston'},
                        {id: 6, name: 'columbus'},
                        {id: 7, name: 'dallas'},
                        {id: 8, name: 'vancouver'},
                        {id: 9, name: 'seattle'},
                        {id: 10, name: 'los angeles'},
                        {id: 11,name :'san francisco'}
                    ],
                    onSelect: displayResult
                });
            });	
        </script>
       <input type="submit" id="submit" class="btn btn-danger"  style="padding: 6px 10px;border-radius: 5px;" value="Search">
  </form>
</div>
    
    
<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
  <div class="container">
    <h3 class="text-center">Events For Location </h3>
    
    <c:set var="count" value="1" scope="page"/>
    <c:forEach var="items" items="${listOfEvents}">
                    
         <c:if test="${(count%3)==1}">
	         		 <div class="row text-center">
         </c:if>
      <div class="col-sm-4">
      
        <div class="thumbnail">
          <img src="${items.logoURL}" alt="San Francisco" style=" height: 230Px;" width="400" height="300">
          <p><strong>${items.name}</strong></p>
          <p>${items.venue.city }</p>
          <form action="${pageContext.request.contextPath}/searcheventsByIDReq?eventID=${items.event_id}" method="Post">
		                          		 	<input type="submit" class="btn" id="submit" value="See place" > 
		   </form>
        </div>
      </div>
    
    <c:if test="${count%3==0}">
	         		 </div>
    </c:if>
     <c:set var="count" value="${count+1}" scope="page"/>
    </c:forEach>
</div>
  
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h5><span class="glyphicon glyphicon-lock"></span> Log In</h5>
        </div>
          
                   
        <div class="modal-body">
          <form role="form"  role="form" action="login" modelAttribute="user" method="POST">
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-envelope"></span> Email</label>
              <input type="email" for="email" class="form-control" id="username" name="username" placeholder="Username">
            </div>
            <div class="form-group">
              <label for="pwd"><span class="glyphicon glyphicon-user"></span> Password</label>
              <input type="password" for="pwd" class="form-control" id="password" name="password" placeholder="Password">
            </div>
              <button type="submit" style="background-color: #1abc9c" name="submit" id="submit" class="btn btn-success">Log In
              </button>
          </form>
        </div>
        <div class="modal-footer">
          <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
		  <c:if test="${sessionScope.userSession==NULL}">
        		<script>
					      function onSignIn(googleUser) {
					      	  var profile = googleUser.getBasicProfile();
					          console.log("ID: " + profile.getId()); // Don't send this directly to your server!
					          console.log('Full Name: ' + profile.getName());
					          console.log('Given Name: ' + profile.getGivenName());
					          console.log('Family Name: ' + profile.getFamilyName());
					          console.log("Image URL: " + profile.getImageUrl());
					          console.log("Email: " + profile.getEmail());

					          var id_token = googleUser.getAuthResponse().id_token;
					          console.log("ID Token: " + id_token);
					        
					          console.log("-----------------------------------------------------------");
					          window.location="${pageContext.request.contextPath}/googleAuth?googleId="+profile.getId()+'&fullName='+profile.getName()+'&givenName='+profile.getGivenName()+'&familyName='+profile.getFamilyName()+"&imageURL="+profile.getImageUrl()+"&email="+profile.getEmail()+"&idToken="+id_token;

				      };
				    
			  </script>
			  </c:if>
          
          <p>Need <a href="#">help?</a></p>
          <c:if test="${status == 0}">
                                            <div class="alert alert-danger pull-left"  >
                                                       <strong>Error! </strong>Username or Password Incorrect.Please sign up.
                                            </div>
          </c:if>
          
        </div>
      </div>
    </div>
  </div>
</div>




<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>EveryEvent Developed by Patel's Group</p>
</footer>
 <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" hidden="true"></div>

</body>
</html>

