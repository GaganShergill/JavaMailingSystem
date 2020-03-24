package gagan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PermanentDeleteMailServlet")
/**
 * Permanently deletes a message from the database.
 *
 */
public class PermanentDeleteMailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.html");
		}else{
			String email=(String)session.getAttribute("email");
			out.print("<div class=\"username\">Welcome, "+email+
					"<img src=\"./images/welcome.png\"/>"+"</div>");
			int id=Integer.parseInt(request.getParameter("id"));
			
			try{
				Connection con=ConProvider.getConnection();
				PreparedStatement ps=con.prepareStatement("DELETE FROM message WHERE ID=?");
				ps.setInt(1,id);
				int i=ps.executeUpdate();
				if(i>0){
					request.setAttribute("msg","Mail successfully deleted permanently!");
					request.getRequestDispatcher("TrashServlet").forward(request, response);
				}
				con.close();
			}catch(Exception e){out.print(e);}
		}
		
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}