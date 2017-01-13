package com.every.events.controller;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.sequencing.UUIDSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.email.EmailServices;
import com.every.events.model.Role;
import com.every.events.model.User;
import com.every.events.utils.JPAInitEMF;
 
@Controller
public class AuthenticationController {
 
	public static final String PERSISTENCE_UNIT_NAME = "per";
	private static EntityManagerFactory factory;

	
	
   @RequestMapping("/homepage")
   public String hello(Model model) {
       return "login";
   }
 
   
   @RequestMapping(value = "/signup", method = RequestMethod.GET)
   public ModelAndView showForm() {
       return new ModelAndView("signup", "user", new User());
   }
   
   
   @RequestMapping(value="/login")
   public ModelAndView guestbook(HttpServletRequest request) {
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       HttpSession session=request.getSession();
       System.out.println("Username "+username + "password "+password);
       if (username != null && password !=null)
       {
    	   User user=new User().userByEmail(username);
    	   if(user==null){
    		   System.out.println("Authentication Login Method ::: user is not valid");
    	       return new ModelAndView("login", "status", 0);
    	   }else if(username.equals(user.getEmail()) && password.equals(user.getPassword() )){
    	       session.setAttribute("userSession",user);
    	       session.setAttribute("displayName",user.getFirstname());
    		   Role role=new Role();
    		   role=user.getRole();
    		   
    		   if(role.getRole_name().equals("admin")){
    			   session.setAttribute("isadmin", 1);
    		   }else{
    			   session.setAttribute("isadmin", 0);
    	      }
    		   System.out.println("Authentication Login Method ::: user is valid");
    	       return new ModelAndView("login", "status", 1);
    	   }
       }
       return new ModelAndView("login", "status", 0);
   }

   @RequestMapping(value="/googleAuth")
   public ModelAndView googleAuth(HttpServletRequest request) {
       

	   String googleId = request.getParameter("googleId");
       String firstName = request.getParameter("givenName");
       String lastName = request.getParameter("familyName");
       String imageURL = request.getParameter("imageURL");
       String email = request.getParameter("email");
       String IdToken=request.getParameter("idToken");
       HttpSession session=request.getSession();
      
       System.out.println("Authentication Controller Google Auth ::: "+googleId+"  "+email);
       
       if (email != null && googleId !=null)
       {
    	   User user=new User().userByEmail(email);
    	   if(user==null){
    		   System.out.println("Authentication Google Auth :: NEW User");
    		   User newGoogleUser=new User();
    		   newGoogleUser.setFirstname(firstName);
    		   newGoogleUser.setLastname(lastName);
    		   newGoogleUser.setGoogleID(googleId);
    		   newGoogleUser.setEmail(email);
    		   newGoogleUser.setGoogleImgUrl(imageURL);
    		  // Token
    		   JPAInitEMF jpa=new JPAInitEMF();
    		   jpa.InsertEntity(newGoogleUser);
    		   session.setAttribute("userSession",newGoogleUser);
    		   session.setAttribute("displayName",newGoogleUser.getFirstname());
    	       session.setAttribute("googleUser", "GoogleUserLogedIn");
    		   return new ModelAndView("login", "googleUser", 1);
    	   }else if(email.equals(user.getEmail())){
    		   System.out.println("Authentication Google Auth :: NEW User");
    	       session.setAttribute("userSession",user);
    	       session.setAttribute("displayName",user.getFirstname());
    	       session.setAttribute("googleUser", "GoogleUserLogedIn");
    		   System.out.println("Authentication Login Method ::: user is valid");
    	       return new ModelAndView("login", "googleUser", 1);
    	   }
       }
       return new ModelAndView("login", "googleUser", 0);
   }
   
   
   @RequestMapping(value="/logout")
   public ModelAndView logout(HttpServletRequest request) {
       HttpSession session=request.getSession();
       System.out.println("Authentication Controller Logout Method :");
       session.removeAttribute("userSession");
       session.removeAttribute("locationset");
       session.removeAttribute("googleUser");
       session.removeAttribute("displayName");
       return new ModelAndView("login", "user", null);
   }

   
   
   @RequestMapping(value = "/loginEvent", method = RequestMethod.POST)
   public String submit(@ModelAttribute("User")User userdata, BindingResult result, ModelMap model) {
	return null;
//    
//	   if (result.hasErrors()) {
//           return "error";
//       }
//       
//       System.out.println("--------------------------------------------------"+userdata.getFirstname());
//     
//       UserIO userIO=new UserIO();
//       userIO.showList();
//       UserData ud=userIO.getUserDataByEmail(userdata.getEmail());
//       UserIO.setSession(ud);
//       
//       if(ud!=null && userdata.getPassword().equals(ud.getPassword())){
//    	   model.addAttribute("firstname", ud.getFirstname());
//           model.addAttribute("lastname", ud.getLastname());
//           model.addAttribute("email", ud.getEmail());
//           return "home";
//       }else{
//    	   model.addAttribute("error", 0);
//           return "login";
//       }
       
   }
  

   @RequestMapping(value = "/signupEvent")
   public ModelAndView signup(HttpServletRequest request) throws ParseException {
	   User newUser=new User();
	   newUser.setFirstname(request.getParameter("firstname"));
	   newUser.setLastname(request.getParameter("lastname"));
	   newUser.setPassword(request.getParameter("password"));
	   newUser.setPhone(request.getParameter("phone"));
	   newUser.setEmail(request.getParameter("email"));
	   Role role=new Role();
	   JPAInitEMF jpa=new JPAInitEMF();
	   role=role.roleByName("user");
	   newUser.setRole(role);
	   System.out.println("Date "+request.getParameter("dob"));
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	   Date d=formatter.parse(request.getParameter("dob").toString());
	   newUser.setDob(d);
	   newUser.setUsername(request.getParameter("email"));
	   newUser.setGoogleImgUrl("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-4/512/User-blue-icon.png");
	   
	   jpa.InsertEntity(newUser);
	   HttpSession session=request.getSession();
	 
	    session.setAttribute("userSession",newUser);
        session.setAttribute("displayName",newUser.getFirstname());
	   
       System.out.println("Authentication SignuEvent Method ::: "+newUser.getEmail());
	   
       return new ModelAndView("login", "status", 1);
            
   }
   
   @RequestMapping("/changePwdReq")
   public String forget(Model model){
	   return "changePassword";
   }
 
   
   @RequestMapping(value = "/changePasswordaction")
   public ModelAndView forgetPassword(HttpServletRequest request) throws ParseException {
	   
	   String email = request.getParameter("email");
	   String oldPassword = request.getParameter("oldpassword");
	   try{
	   if(email != null && oldPassword != null){
		   User user=new User().userByEmail(email);
		   if(user != null){
			   String userpassword = user.getPassword();
			   System.out.println(userpassword);
			   if(oldPassword.equals(userpassword)){
					   user.setPassword(request.getParameter("newpassword")); 
					   user.updateUser(user);
					   HttpSession session=request.getSession();
					   session.setAttribute("userSession", user);
					   
			   return new ModelAndView("changePassword", "Error", 0);
			   }else{
				   return new ModelAndView("changePassword", "Error", 1);
			   }
		   }else{
			   return new ModelAndView("changePassword", "Error", 1);
		   }
	   }
	   }catch(Exception e){
		   System.out.println("ForgetPassword Method "+e.getMessage());
	   }
	   return new ModelAndView("changePassword", "Error", 1);
            
   }
   
   
   @RequestMapping("/forgetpassword")
	public String forgetpwd(Model model) {
		return "forgetPassword";
	}

	@RequestMapping(value = "/forgetpasswordaction")
	public ModelAndView forgetPasswordaction(HttpServletRequest request) throws ParseException {

		String email = request.getParameter("email");
		// String oldPassword = request.getParameter("oldpassword");
		try {
			if (email != null) {
				User user = new User().userByEmail(email);
				if (user != null) {

					String useremail = user.getEmail();
					// System.out.println(userpassword);
					if (email.equals(useremail)) {
						String[] to = { email };
						EmailServices emailSend = new EmailServices();
						
						Random rand = new Random();
						String  randomNumber = String.valueOf(rand.nextInt(99999) + 1);
						String newPassword = "<h2 style='color:#d9534f'>Hello "+ user.firstname+" </h2><p style='font-family: sans-serif'>Your New Password is " + randomNumber+"</p>";
						newPassword=newPassword.concat("<img src='https://s3.postimg.io/6i3h5logz/Every_Events.jpg'     style=\" max-height: 25s0Px\" >");
						if (emailSend.sendMail(newPassword,to)) {
							System.out.println("Send Successfully");
							user.setPassword(randomNumber);
							user.updateUser(user);
						} else
							System.out.println("Failed");

						HttpSession session = request.getSession();
						session.setAttribute("userSession", user);

						return new ModelAndView("forgetPassword", "Error", 0);
					} else {
						return new ModelAndView("forgetPassword", "Error", 1);
					}
				} else {
					return new ModelAndView("v", "Error", 1);
				}
			}
		} catch (Exception e) {
			System.out.println("forgetPassword Method " + e.getMessage());
		}
		return new ModelAndView("forgetPassword", "Error", 1);

	}
   

}