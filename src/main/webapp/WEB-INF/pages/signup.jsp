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
      padding: 10px 20px;
      color: #f1f1f1;
      transition: .2s;
  }
  .btn:hover, .btn:focus {
      color: #f1f1f1;
      background-color: #f4511e;
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
  }
  textarea {
      resize: none;
  }
   @media screen and (max-width: 480px) {
    .logo {
        font-size: 150px;
    }
  }
  
  
   .btn-default{
            	background-color: #f4511e;
            	 color: #fff;
            }
            .panel-heading {
                 color: #fff !important;
                 background-color: #f4511e !important;
                 border-color:#f4511e !important;  
             }
  
   h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }
  .jumbotron {
      background-color: #f4511e;
      color: #fff;
      padding: 50px 15px;
      font-family: Montserrat, sans-serif;
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
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Merchandise</a></li>
            <li><a href="#">Extras</a></li>
            <li><a href="#">Media</a></li>
          </ul>
        </li>
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
              		 <li> <a data-toggle="modal" data-target="#myModal">SIGN UP</a></li>
             </c:if>
      </ul>
    </div>
  </div>
</nav>    
  
<div class="jumbotron text-center">
  <h2>EveryEvents</h2>
  <p>Sign Up</p>
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
          <form role="form" role="form" action="login"  method="POST">
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

     <div class="row">
            <div class="col-sm-1" ></div>
            <div class="col-sm-5" >
                
                        <div class="panel panel-default">
                          <div class="panel-heading">
                            <h3 class="panel-title">
                              Signup
                            </h3>
                          </div>
                          <div id="signup" class="panel-collapse">
                                    <div class="panel-body">
									<div class="row">
										  <div class="col-sm-4"></div>
										  <div class="col-sm-4">
										  			                                       <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" ></div>
                                		  </div>
										  <div class="col-sm-4"></div>
										</div>
								       <hr>
		                               <form  name="signupForm"  role="form" method="POST" onsubmit="return validatePassword();" action="signupEvent"  >
                                 		 <div class="form-group">
                                                <label class="control-label"  for="name"> First name</label>
                                                 <input class="form-control" type="text" id="firstname" name="firstname" />
                                                 
                                            </div>
                                            <div class="form-group">       
                                                <label class="control-label"  for="lname">Last name</label>
                                                <input class="form-control" type="text"  id="lastname" name="lastname" />
                                                
                                            </div>
                                            <div class="form-group">       
                                                <label class="control-label"  for="email">Email</label>
                                                 <input class="form-control" type="email" id="email" name="email" for="email" />
                                                 
                                            </div>
                                            
                                            <div class="form-group">       
                                                <label class="control-label"  for="email">Phone</label>
                                                 <input class="form-control" type="tel" id="phone" name="phone" for="phone"/>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="control-label"  for="pwd">Password</label>
                                                <input class="form-control" type="password" for="pwd" id="password" name="password"/>
                                                
                                            </div>
 
                                             <div class="form-group"> 
                                                 <label class="control-label"  for="pwd">Confirm Password</label> 
                                                 <input class="form-control" type="password" name="cnfmpassword" id="cnfmpassword"/> 
                                                  
                                             </div> 
                                             
                                            <div class="form-group"> 
                                                 <label class="control-label"  for="date">Date Of Birth</label> 
                                                 <input class="form-control" type="date" name="dob" id="dob" /> 
                                             </div> 
                                             
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10"><input type="submit"  class="btn btn-default"  value="Submit"/>
                                            </div>
                                            </div>
										
                                            
                                        </form>
                                    </div>
                          </div>
                        </div>
                </div>
            <div class="col-sm-5">
            
			     <div class="container-fluid bg-grey">
					  <div class="row">
					    <div class="col-sm-12">
		  			        <div class="row">
		  			            <div class="col-sm-4"></div>
							    <div class="col-sm-4">
				  			      <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTu-IdiTUWF5hSYM3i_fmvzIAC8zksbUGxzb0CAUk9nNf2pu14wjA" class="img-circle" alt="Random Name" width="180" height="180">
		      					</div>
		      				    <div class="col-sm-4"></div>
		      				</div>
      				      <h2>Our Values</h2><br>
					      <p><strong>MISSION:</strong> Our mission lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p><br>
					      <p><strong>VISION:</strong> Our vision Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
					      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
					    </div>
					  </div>
					</div>
            
            </div>
            <div class="col-sm-1"></div>
            </div>

<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p>EveryEvent Developed by Patel's Group</p>
</footer>

</body>
</html>

