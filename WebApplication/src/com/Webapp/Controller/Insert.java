package com.Webapp.Controller;

import java.beans.Statement;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	   PreparedStatement preparedStatement = null;
	    ResultSet resultSet=null;
	 java.sql.Connection con=null;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		
		String name=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		 String UsernameLabel=request.getParameter(name);
		  request.setAttribute("mes_add_pageTitle",UsernameLabel); //Setting UsernameLabel to mes_add_pageTitle

		  RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");
		  rd.forward(request,response);  //forwarded to welcome.jsp
		  
		  
		  
		doGet(request, response);
		  try {
				 java.sql.Statement statement;
				 Class.forName("com.mysql.jdbc.Driver");
		          con =  DriverManager.getConnection("jdbc:mysql://localhost/db","root","1234");
		          preparedStatement=con.prepareStatement("insert into user values(?,?)");
			      preparedStatement.setString(1, name);
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
		  
		  
		
	}

}
