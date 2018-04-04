package com.send.email;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class send
 */
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 PreparedStatement preparedStatement = null;
	    ResultSet resultSet=null;
	 java.sql.Connection con=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String username1=request.getParameter("id");
		final String username=request.getParameter("uname");
		final String password=request.getParameter("pass");
		final String recipient=request.getParameter("recipient");
		
		
		
		
		
		  try {
				 java.sql.Statement statement;
				 Class.forName("com.mysql.jdbc.Driver");
		          con =  DriverManager.getConnection("jdbc:mysql://localhost/db","root","1234");
		          preparedStatement=con.prepareStatement("insert into user values(?,?)");
			      preparedStatement.setString(1, username1);
			      preparedStatement.setString(2, password);
		          preparedStatement.executeUpdate();
		       	  System.out.println("Saved");
		       	  
		   
		       	  preparedStatement=con.prepareStatement("update user set name='Devarajrc' where uid=1");
		       	  
		    //   	System.out.println("Updated");
		       	  String sql="select * from user";
		       	ResultSet result =preparedStatement.executeQuery(sql); 
		       	int count = 0;
		        
		       	while (result.next()){
		       	    String name1 = result.getString("uid");
		       	    String pass = result.getString("password");
		       	//    String fullname = result.getString("fullname");
		       	  //  String email = result.getString("email");
		       	 
		       	    String output = "User #%d: %s - %s";
		       	    System.out.println(String.format(output, ++count, name1,pass)); 	   
		      	  System.out.println("List of Users");
		       	}
		     	  preparedStatement=con.prepareStatement("delete from user where uid=6");
		       	  preparedStatement.executeUpdate();
		      	System.out.println("Deleted");
	        }catch(Exception e)
	        {
	        	System.out.println(e);
		           
	        }
		
		
		
		
		
		
		
		
		
		
		
		

		
				System.out.println("Generating OTP using random() : ");
				System.out.print("You OTP is : ");

				// Using numeric values
				String numbers = "0123456789";

				// Using random method
				Random rndm_method = new Random();
				int len = 8;
				char[] otp = new char[len];

				for (int i = 0; i < len; i++)
				{
					// Use of charAt() method : to get character value
					// Use of nextInt() as it is scanning the value as int
					otp[i] =
					numbers.charAt(rndm_method.nextInt(numbers.length()));
				}
				System.out.println(otp);
		
		
		
		
		
		
		
		//final String message1=request.getParameter("message1");
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
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Your Username is");
		//  	String str=String.valueOf(otp);
			message.setText(username);
			Transport.send(message);
			System.out.println("done");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		String name=request.getParameter("message1");
		
		System.out.println(name);
		
	}
		



}
