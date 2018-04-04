package com.email.send;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.*;
import javax.mail.Transport;


public class Send {
	

	public static void main(String[] args) {
		final String username="d.chennur@gmail.com";
		final String password="973_devaraj";
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session=Session.getInstance(props,new javax.mail.Authenticator()		
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication(username,password);
					}
				}
				
				);
		try
		{
			Message message =new MimeMessage(session);
			message.setFrom(new InternetAddress("d.chennur@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("devarajchennur@gmail.com"));
			message.setSubject("Testing Subject");
			String message1="From form";
			message.setText(message1);
			Transport.send(message);
			System.out.println("done");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	

}
