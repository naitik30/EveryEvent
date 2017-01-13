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
      border: none;
      border-radius: 0;
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
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
  .btn {
      padding: 4px 13px;
      color: #f1f1f1;
      transition: .2s;
      background-color: #1abc9c;
      border-radius: 2px;
      border-color: #f1f1f1;
  }
  .btn:hover, .btn:focus {
      color: #f1f1f1
      
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
	            <li><a href="${pageContext.request.contextPath}/showAllUsers">USERS</a></li>
	            <li><a href="${pageContext.request.contextPath}/showMyEventsReq">EVENTS</a></li>
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
            <img class="card-bkimg" alt="" src="${sessionScope.userSession.googleImgUrl}">
            <!-- http://lorempixel.com/850/280/people/9/ -->
        </div>
        <div class="useravatar">
            <img alt="" src="${sessionScope.userSession.googleImgUrl}">
            <br><span class="card-title">${sessionScope.userSession.firstname} ${sessionScope.userSession.lastname}</span>
        </div>
     
    	</div>
            </div>
	</div>
        <br>
        <div class="container-fluid">
            <div class="row">
            <div class="col-sm-3" ></div>
            <div class="col-sm-6" >
                <table class="table table-striped">
                    <tbody>
                      <tr>
                          <td><b>First name</b></td>
                          <td>${userInfo.firstname}</td>
                      </tr>
                      <tr>
                          <td><b>Last name</b></td>
                          <td>${userInfo.lastname}</td>
                      </tr>
                      <tr>
                          <td><b>Email</b></td>
                          <td>${userInfo.email}</td>
                      </tr>
                       <tr>
                          <td><b>Phone</b></td>
                          <td>${userInfo.phone}</td>
                      </tr>
                      <tr>
                          <td><b>Events attending</b></td>
                          <td>Coming Soon...</td>
                      </tr>
                      
                      <tr>
                          <td><b>Password</b></td>
                          <td>
                            <div class="btn-group" role="group" aria-label="Password operations">
                          		 <button type="button" class="btn" data-toggle="modal" data-target="#passwordModal">Show Password</button>
                                 <button type="button" class="btn" id="changePasswordBtn" >Change Password</button>
                          	</div>
                          	</td>
                      </tr>
                      
				    </tbody>
        </table>
        </div>
        </div>
        </div>
        <script type="text/javascript">
        $('#changePasswordBtn').on('click', function (e) {
              window.location="${pageContext.request.contextPath}/changePwdReq";
       })
        </script>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        
	<div id="passwordModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Your Password. keep Safe</h4>
				</div>
				<div class="modal-body">
					<p>Your Password is <b> ${userInfo.password} </b></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>EveryEvent Developed by Patel's Group</p>
</footer>
     <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" hidden="true"></div>
	
</body>
</html>

