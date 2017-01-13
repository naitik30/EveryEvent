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
      background: #2d2d30;
      color: #bdbdbd;
  }
  .bg-1 h3 {color: #fff;}
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
      border: none;
      border-radius: 0;
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
  }
 .btn {
      padding: 4px 13px;
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
         <li><a href="${pageContext.request.contextPath}/newEvent" ><font color="#1abc9c"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Create Event</font></a></li>
         
         <c:if test="${sessionScope.locationset!=NULL}">
               		 <li><a data-toggle="modal" data-target="#cityModal"><span class="glyphicon glyphicon-map-marker"></span> ${sessionScope.locationset.city} </a></li>
         </c:if>
         <c:if test="${sessionScope.locationset == NULL}">
               		 <li> <a data-toggle="modal" data-target="#cityModal"><span class="glyphicon glyphicon-map-marker"></span>Set Location</a></li>
         </c:if>
         
         <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
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
              		 <li> <a href="${pageContext.request.contextPath}/signup">SIGN UP</a></li>
             </c:if>
      </ul>
    </div>
  </div>
</nav>    
    
    <c:if test="${status == 0}">
                   <script>$('#myModal').modal('show');</script>
    </c:if>  
     
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://www.skiheavenly.com/~/media/heavenly/images/732x260%20header%20images/events-heavenly-header.ashx" alt="New York" >
        <div class="carousel-caption">
          <h3>Events</h3>
          <p>All The Events in your city at one Place</p>
        </div>
      </div>

      <div class="item">
        <img src="http://static1.squarespace.com/static/533353a3e4b0429a548a8446/t/54a78bede4b057f9e3964d76/1420266478889/lights_events_1366x768_68503.jpg" alt="Chicago" >
        <div class="carousel-caption">
          <h3>Places near Events</h3>
          <p>Find cooles Restaurant and Hotels near your venue</p>
        </div>
      </div>
    
      <div class="item">
        <img src="http://visualmemories.photography/wp-content/uploads/2016/02/events1.jpg" alt="Los Angeles" >
        <div class="carousel-caption">
          <h3>Meetups</h3>
          <p>Get together to make something happened</p>
        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
  <h3>The EveryEvents</h3>
  <p><em>Everything at One Place</em></p>
  <p>We have created a fictional Event and Place Searching website, Where you can search varipus events near your city and anywhere in the world. Even You can find the places such as restaurant and hotels near to venue of area.</p>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <p class="text-center"><strong>Events</strong></p><br>
      <a href="#demo" data-toggle="collapse">
        <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTu-IdiTUWF5hSYM3i_fmvzIAC8zksbUGxzb0CAUk9nNf2pu14wjA" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo" class="collapse">
        <p>Events Near You</p>
        <p> Business | Concerts | Exhibitions
            Festivals | Meetups | Music | Parties </p>
        <p> Find Here</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>MeetsUps</strong></p><br>
      <a href="#demo2" data-toggle="collapse">
        <img src="http://eventsbyambrosia.com/wp-content/uploads/2016/06/events.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo2" class="collapse">
        <p>Together to learn something, </p>
        <p> Do something</p>
        <p> Share something</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>Places</strong></p><br>
      <a href="#demo3" data-toggle="collapse">
        <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTu-IdiTUWF5hSYM3i_fmvzIAC8zksbUGxzb0CAUk9nNf2pu14wjA" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo3" class="collapse">
        <p>Explore The places</p>
        <p>Search Places near to events</p>
      </div>
    </div>
  </div>
</div>

<div id="tour" class="bg-1">
  <div class="container">
    <h3 class="text-center">Events and Places</h3>
    
    <div class="row text-center">
      <div class="col-sm-4">
        <div class="thumbnail">
          <img style=" height: 250Px;" width="400" src="http://i239.photobucket.com/albums/ff212/brewedforthought/Events/120421%20Bay%20Area%20Craft%20Beer%20Festival/DSCN0043.jpg" alt="Paris" width="400" height="300">
          <p><strong>2016 Bay Area Summer Brew Festival</strong></p>
          <p>Friday 27 November 2016</p>
          <p>San Francisco</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">See Event</button>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
          <img style=" height: 250Px;" width="400" src="http://www.lifeofaneventplanner.com/uploads/5/3/0/4/53047881/alex-laughing_orig.jpg" alt="New York" width="400" height="300">
          <p><strong>Let's meet, laugh and have some good food!</strong></p>
          <p>Saturday 28 November 2016</p>
          <p>San Francisco</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">See Meetup</button>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
          <img style=" height: 250Px;" width="400" src="http://www.w3schools.com/bootstrap/sanfran.jpg" alt="San Francisco" width="400" height="300">
          <p><strong>Golden Gate Hotel</strong></p>
          <p>775 Bush St</p>
          <p>Union Square,SF</p>
          <button class="btn" data-toggle="modal" data-target="#myModal">See Place</button>
        </div>
      </div>
    </div>
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
          
          <p><a href="${pageContext.request.contextPath}/forgetpassword">forgot Password?</a></p>
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

 <c:if test="${sessionScope.locationset==NULL}">
<script type="text/javascript">
    $(window).load(function(){
        $('#cityModal').modal('show');
    });
</script>
</c:if>


 <!-- Modal -->
  <div class="modal fade" id="cityModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h5><span class="glyphicon glyphicon-map-marker"></span>  Enter Your City</h5>
        </div>
        <div class="modal-body">
        
          <form role="form"  role="form" action="setLocation" method="POST">
           <div class="form-group">
           <input id="city" type="text" name="city" size=20 class="form-control" style="border-radius: 4px;" placeholder="Search cities..." autocomplete="on" value="${sessionScope.locationset.city}" />
				        <script>
				            $(function() {
				                $('#city').typeahead({
				                    source: [
				                        {id: 1, name: 'San Jose'},
				                        {id: 2, name: 'fremont'},
				                        {id: 3, name: 'Hayward'},
				                        {id: 4, name: 'Buffalo'},
				                        {id: 5, name: 'Boston'},
				                        {id: 6, name: 'Columbus'},
				                        {id: 7, name: 'Dallas'},
				                        {id: 8, name: 'Vancouver'},
				                        {id: 9, name: 'Seattle'},
				                        {id: 10, name: 'Los Angeles'},
				                        {id: 11,name :'San Francisco'}
				                    ],
				                });
				            });	
				        </script>
				  </div>
				  <div class="form-group">      
      			 <input id="state" type="text" name="state" size=5 class="form-control" style="border-radius: 4px;" placeholder="CA" autocomplete="on" value="${sessionScope.locationset.state}" />
					      	 <script>
					            $(function() {
					                function displayResult(item) {
					                    $('.alert').show().html('You selected <strong>' + item.value + '</strong>: <strong>' + item.text + '</strong>');
					                }
					                $('#state').typeahead({
					                    source: [
					                        {id: 1, name: 'CA'},
					                        {id: 2, name: 'MA'},
					                        {id: 3, name: 'NY'},
					                        {id: 4, name: 'FL'},
					                        {id: 5, name: 'NV'},
					                        {id: 6, name: 'OG'},
					                        {id: 7, name: 'MS'},
					                        {id: 8, name: 'NJ'},
					                        {id: 9, name: 'BS'},
					                        {id: 10, name: 'NK'}
					                    ],
					                    onSelect: displayResult
					                });
					            });	
					        </script>
					        </div>
       		<input type="submit" id="submit" class="btn btn-success"  style="background-color: #1abc9c" value="Set">
          </form>
        </div>
        <div class="modal-footer">
         
        </div>
      </div>
    </div>
  </div>



<!-- Container (Contact Section) -->
<div id="contact" class="container">
  <h3 class="text-center">Contact</h3>
  <p class="text-center"><em>We love our fans!</em></p>

  <div class="row">
    <div class="col-md-4">
      <p>Fan? Drop a note.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>Union city,CA</p>
      <p><span class="glyphicon glyphicon-phone"></span>Phone: +1 630 363 2408</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: bhagyesh18@gmail.com</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
  <br>
 

</div>

<div id="googleMap"></div>

<!-- Add Google Maps -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAtVWg3QWglahWlTn6JmFwJUVcQe_EzWW8
&callback=initMap"></script>
<script>
var myCenter = new google.maps.LatLng(37.6577512,-122.0585936);

function initialize() {
var mapProp = {
center:myCenter,
zoom:12,
scrollwheel:false,
draggable:false,
mapTypeId:google.maps.MapTypeId.ROADMAP
};

var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker = new google.maps.Marker({
position:myCenter,
});

marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>

<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>EveryEvent Developed by Patel's Group</p>
</footer>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip();
   
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>
 <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" hidden="true"></div>
</body>
</html>

