package amdocs.elearner.servlet;

import amdocs.elearner.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amdocs.elearner.dao.MySQLUtil;
import amdocs.elearner.model.Feedback;

/**
 * Servlet implementation class ViewContact
 */
@WebServlet("/ViewContact")
public class ViewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set content type
		response.setContentType("text/html");
		
		//get writer
		PrintWriter out = response.getWriter();
		
		//fetch query
		String query = "select * from contact";
		System.out.println("Fetching Query:"+query);
		
		//get resultset
		ResultSet result = MySQLUtil.fetchQuery(query);
		if(result!=null) {
			try {
				List<Contact> contacts = new ArrayList<Contact>();
				while(result.next())
				{
					
					contacts.add(new Contact(result.getInt(1),
							result.getString(2),result.getString(3),
							result.getLong(4),result.getString(5)));
					
					
				}
				request.setAttribute("contacts", contacts);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/view-contact.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("url", "view-contact.jsp");
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("url", "view-contact.jsp");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
