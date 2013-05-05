package com.otrocol.app;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Mailler{

	public Mailler(){
	};

	public void send(){
	   String result;
	   // Recipient's email ID needs to be mentioned.
	   String to = "vladotrocol@gmail.com";

	   // Sender's email ID needs to be mentioned
	   String from = "vladotrocol@gmail.com";

	   // Assuming you are sending email from localhost
	   String host = "gmail.com";

	   // Get system properties object
	   Properties properties = System.getProperties();

	   // Setup mail server
	   properties.setProperty("mail.smtp.host", host);
	   properties.setProperty("mail.smtp.port", "465");
	   properties.setProperty("mail.smtp.auth", "true");
	   properties.setProperty("mail.smtp.starttls.enable", "true");

	    Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vladotrocol", "zubavacavarivatelnita");
            }
        };

	   // Get the default Session object.
	   Session mailSession = Session.getInstance(properties,auth);

	   try{
	      // Create a default MimeMessage object.
	      MimeMessage message = new MimeMessage(mailSession);
	      // Set From: header field of the header.
	      message.setFrom(new InternetAddress(from));
	      // Set To: header field of the header.
	      message.addRecipient(Message.RecipientType.TO,
	                               new InternetAddress(to));
	      // Set Subject: header field
	      message.setSubject("This is the Subject Line!");
	      // Now set the actual message
	      message.setText("This is actual message");
	      // Send message
	      Transport.send(message);
	      result = "Sent message successfully....";
	   }catch (MessagingException mex) {
	      mex.printStackTrace();
	      result = "Error: unable to send message....";
	   }
	}

};