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
  
  
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
	<script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
  
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
      border-color:#b9b9b9;
      border-radius: 4Px;
     
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
      height: 25px;
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
      font-size: 20px;
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

  
   @media screen and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
  }
  
  
 
  
   h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }
  .jumbotron {
       background-color: #1abc9c;
      color: #fff;
      padding: 50px 15px;
      font-family: Montserrat, sans-serif;
  }
  
  .card {
    margin-top: 0px;
    padding: 30px;
    background-color: rgba(214, 224, 226, 0.2);
    -webkit-border-top-left-radius:5px;
    -moz-border-top-left-radius:5px;
    border-top-left-radius:5px;
    -webkit-border-top-right-radius:5px;
    -moz-border-top-right-radius:5px;
    border-top-right-radius:5px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.card.hovercard {
    position: relative;
    padding-top: 0;
    overflow: hidden;
    text-align: center;
    background-color: #fff;
    background-color: rgba(255, 255, 255, 1);
}
.card.hovercard .card-background {
    height: 250px;
}
.card-background img {
    -webkit-filter: blur(25px);
    -moz-filter: blur(25px);
    -o-filter: blur(25px);
    -ms-filter: blur(25px);
    filter: blur(20px);
    margin-left: -100px;
    margin-top: -200px;
    min-width: 130%;
}
.card.hovercard .useravatar {
    position: absolute;
    top: 60px;
    left: 0;
    right: 0;
}
.card.hovercard .useravatar img {
    width: 100px;
    height: 100px;
    max-width: 100px;
    max-height: 100px;
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    border-radius: 50%;
    border: 5px rgba(255, 255, 255, 0.5);
}
.card.hovercard .card-info {
    position: absolute;
    bottom: 14px;
    left: 0;
    right: 0;
}
.card.hovercard .useravatar .card-title {
    padding:0 2px;
    font-size: 25px;
    line-height: 2;
    color: #fff;
    background-color: rgba(255, 255, 255, 0.1);
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
}

.card.hovercard .bottom {
    padding: 0 20px;
    margin-bottom: 17px;
}


  
  </style>
  
   <script type="text/javascript">
                function validatePassword(form)
                {
                    //event.preventDefault();
                    var input = document.forms["signupForm"]["password"].value;
                    var cnfmpassword = document.forms["signupForm"]["cnfmpassword"].value;
                    // var input=frm.password;
                    var paswd = /^(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{7,}/;
                    if (!paswd.test(input))
                    {
                        alert('Password Incorrect! Must have more than 7 characters, one numeric digit & a special character');
                        return false;
                    }
                    if (cnfmpassword !== input)
                    {
                        alert('password should match with comfirm password!!!');
                        return false;
                    }
                    return true;
                }
                
                $(document).ready(function() {
                	$(".btn-pref .btn").click(function () {
                	    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
                	    // $(".tab").addClass("active"); // instead of this do the below 
                	    $(this).removeClass("btn-default").addClass("btn-primary");   
                	});
                	});
                
            </script>  
  
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
	          <li><a href="${pageContext.request.contextPath}/showAllUsers" >USERS</a></li>
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
  
        <div class="row">
            <div class="col-lg-12">
  			<div class="card hovercard">
        <div class="card-background">
            <img class="card-bkimg" alt="" src="${infoEvent.logoURL}">
        
        </div>
        <div class="useravatar">
            <img alt="" src="${infoEvent.logoURL}">
            <br><span class="card-title">${infoEvent.name}</span>
        </div>
     
    	</div>
            </div>
	</div>
        <br>
        <div class="container-fluid">
            <div class="row">
            <div class="col-sm-2" >
		         
					   <div class="thumbnail text-center">
				          <img src="${infoEvent.logoURL}" alt="Paris" style=" height: 182Px;" width="400" height="300">
				          <p> ${infoEvent.name} </p><br>
						  <p><a href="${infoEvent.event_url}" target="_blank" class="btn">See Event</a>
				        </div>
				         <div class="thumbnail text-center">
				             <p style="color: #d9534f;"><b>Rating</b></p>
				           <c:if test="${infoEvent.rating==0}">
				            <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_0_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==0.5}">
				            <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_0_and_half_star.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==1.0}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_1_star.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==1.5}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_1_and_a_half_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==2.0}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_2_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==2.5}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_2_and_a_half_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==3.0}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_3_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==3.5}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_3_and_a_half_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==4.0}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_4_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==4.5}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_4_and_a_half_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
				           <c:if test="${infoEvent.rating==5.0}">
				             <img src="http://www.wpclipart.com/signs_symbol/stars/5_star_rating_system/.cache/5_Star_Rating_System_5_stars.png" alt="Rating" style=" height: 25Px;" width="100" height="50">
				           </c:if>
						</div>
					   <div class="thumbnail text-center">
                          <p style="color: #d9534f;"><b>Share</b></p>
				              <a data-toggle="modal" data-target="#sharemailModal">
				          <img src="http://jeffrsmith.com/dylan/wp-content/uploads/2015/03/mail-icon.png" alt="Rating" style=" height: 45Px; width: 80Px;"></a>
				       </div>
				       <div class="thumbnail text-center">
                          <p style="color: #d9534f;"><b>Going in Event?</b></p>
				             <a href="${pageContext.request.contextPath}/visitEventsYesByIDReq?eventID=${infoEvent.event_id}"  class="btn"><span class="glyphicon glyphicon-thumbs-up"></span> Yes</a>
				             <a href="" target="_blank" class="btn"><span class="glyphicon glyphicon-thumbs-down"></span> No</a>
				       </div>
				        
            </div>
            <div class="col-sm-8" >
                <table class="table table-striped">
                    <tbody>
                      <tr>
                          <td><b>Duration</b></td>
                          <td>${infoEvent.duration}</td>
                      </tr>
                     <c:if test="${infoEvent.endtime==NULL}">
              			<tr>
                          <td><b>Time</b></td>
                          <td>${infoEvent.starttime}</td>
                        </tr>
                       </c:if>
                    
                    <c:if test="${infoEvent.endtime!=NULL}">
              		 <tr>
                          <td><b>Start Time</b></td>
                          <td>${infoEvent.starttime}</td>
                      </tr>
                      
                      <tr>
                          <td><b>End time</b></td>
                          <td>${infoEvent.endtime}</td>
                      </tr>
                    </c:if>
                      
                    
                        <tr>
                          <td><b>description</b></td>
                          <td>${infoEvent.description}</td>
                      </tr>
                        <tr>
                          <td><b>Vanue</b></td>
                          <td>
                          <p> ${infoEvent.venue.name} </p>
                          <p> ${infoEvent.venue.address1} </p>
                          <p> ${infoEvent.venue.address2} </p>
                          <p> ${infoEvent.venue.address3} </p>
                          <p> ${infoEvent.venue.city} </p>
                          <p> ${infoEvent.venue.state} </p>
                          <p> ${infoEvent.venue.country} </p>
                          <p> ${infoEvent.venue.zip} </p>
                          <p> ${infoEvent.venue.phone} </p>
                          </td>
                      </tr>
                      <tr>
                          <td><b>Amount Fees</b></td>
                          <td>$ ${infoEvent.amount}</td>
                      </tr>
                        <tr>
                          <td><b>Why</b></td>
                          <td>${infoEvent.why}</td>
                      </tr>
                        <tr>
                          <td><b>Capacity</b></td>
                          <td>${infoEvent.capacity}</td>
                      </tr>
                        <tr>
                          <td><b>Head Count</b></td>
                          <td>${infoEvent.headCount}</td>
                      </tr>
                        <tr>
                          <td><b>Yes Count</b></td>
                          <td>${infoEvent.yesCount}</td>
                      </tr>
                        <tr>
                          <td><b>Rsvp Limit</b></td>
                          <td>${infoEvent.rsvpLimit}</td>
                      </tr>
                      
                      <tr>
                          <td><b>Waitlist Count</b></td>
                          <td>${infoEvent.waitlistCount}</td>
                      </tr>
                      <tr>
                          <td><b>Yes Rsvp Count</b></td>
                          <td>${infoEvent.yesRsvpCount}</td>
                      </tr>
                      <tr>
                          <td><b>is Reserved Seating</b></td>
                          <td>${infoEvent.isReservedSeating}</td>
                      </tr>
                      <tr>
                          <td><b>May Be Rsvp Count</b></td>
                          <td>${infoEvent.maybeRsvpCount}</td>
                      </tr>
                      <tr>
                       <td><b>Status</b></td>
                          <td>${infoEvent.status}</td>
                      </tr>
                      <tr>
                       <td><b>Created On</b></td>
                          <td>${infoEvent.created}</td>
                      </tr>
                      <tr>
                       <td><b>Last Updated</b></td>
                          <td>${infoEvent.updated}</td>
                      </tr>
                    </tbody>
        </table>
        </div>
         <div class="col-sm-2" >
                       <div class="thumbnail text-center">
				          <img src="https://cdn.evbuc.com/eventlogos/1040789/eventbritelogogradientv2.png" alt="Paris" style=" height: 121Px;" width="400" height="300">
				            <p style="color: #d9534f;"><b>Brought to you by</b></p>
				          <p> ${infoEvent.name}</p><br>
						  <p><a href="${infoEvent.event_url}" target="_blank" class="btn">See Event</a>
				          </p>
				         
				        </div>
				        <div class="thumbnail text-center">
				         <p style="    color: #d9534f;"><b>Hotel near Vanue</b></p>
				          <p><a href="${pageContext.request.contextPath}/placesHotelNearReq?city=${infoEvent.venue.city}&state=${infoEvent.venue.state}" target="_blank" class="btn">Hotels</a>
				          </p>
				        </div>
				        <div class="thumbnail text-center">
				          <p style="    color: #d9534f;"><b>Restaurant near Vanue</b></p>
				          <p><a href="${pageContext.request.contextPath}/placesRestaurantNearReq?city=${infoEvent.venue.city}&state=${infoEvent.venue.state}" target="_blank" class="btn">Restaurant</a>
				          </p>
				        </div>
				        <div class="thumbnail text-center">
                          <p style="color: #d9534f;"><b>See In Maps</b></p>
				          <a href="https://www.google.com/maps/@${infoEvent.venue.lat},${infoEvent.venue.lon}" target="_blank" class="btn">Maps</a>
				         </div>
				   
				        
         </div>
        </div>
        </div>
 
 <!-- share Modal -->
  <div class="modal fade" id="sharemailModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="background-color: #f44336;">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h5><span class="glyphicon glyphicon-lock"></span>Share The Event</h5>
        </div>
       <div class="modal-body">
          <form role="form"  role="form" action="shareEventByMail?eventID=${infoEvent.event_id}"  method="POST">
            <div class="form-group">
              <label for="email"><span class="glyphicon glyphicon-envelope"></span> Email</label>
              <input type="email" class="form-control" id="email" name="email" placeholder="Email Address">
            </div>
           <button type="submit" style="background-color: #f44336;border-radius: 4Px;border-color: #f44336;" name="submit" id="submit" class="btn btn-success">Share</button>
          </form>
        </div>
        <div class="modal-footer">
         
         </div>
      </div>
    </div>
  </div>

 
 
        
	 <div id="googleMap"></div>
  
<!-- Add Google Maps -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAtVWg3QWglahWlTn6JmFwJUVcQe_EzWW8
&callback=initMap"></script>
<script>

var lon = eval("${infoEvent.venue.lon} ");
var lat = eval("${infoEvent.venue.lat} ");

var myCenter = new google.maps.LatLng(lat, lon );

function initialize() {
var mapProp = {
center:myCenter,
zoom:14,
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
	<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>EveryEvent Developed by Patel's Group</p>
</footer>
     <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" hidden="true"></div>
 <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" hidden="true"></div>	
</body>
</html>

