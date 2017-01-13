package com.every.events.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main
{
   public static void main(String [] args)
   {    
     EmailServices email=new EmailServices();
     String emailto[]={"bhagyesh18@gmail.com"};
     email.sendMail("Hello All",emailto);
   }
}

