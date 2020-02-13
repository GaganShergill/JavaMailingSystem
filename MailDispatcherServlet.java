package com.gagan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name="MailDispatcherServlet", urlPatterns= {"/MailDispatcherServlet"})
public class MailDispatcherServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String toEmail = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		//properties to be read from external file or database or server properties
		//hardcoding for tutorial

		String fromEmail = "dummy.use1d@gmail.com";
		String username = "dummy.use1d";
		String password = "1d2u3m4m5y";
		
		
		try(PrintWriter out = response.getWriter()) {
			
			//Call to mail sender bean
			
			//---------------------------------
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Mail Status</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Mail Status !!!</h1>");
			out.println("<b>Mail Sent Succesfully !!!</b>");
			out.println("Click <a href = 'emailClient.jsp'>here</a> to go back !!!");
			out.println("</body>");
			out.println("</html>");
			
		}
	
	}

}
