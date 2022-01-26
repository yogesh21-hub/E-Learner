package amdocs.elearner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amdocs.elearner.dao.MySQLUtil;
import amdocs.elearner.model.Feedback;
import amdocs.elearner.model.User;

/**
 * Servlet implementation class ViewUser
 */
@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUser() {
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
		String query = "select * from user1";
		System.out.println("Fetching Query:"+query);
		
		//get resultset
		ResultSet result = MySQLUtil.fetchQuery(query);
		if(result!=null) {
			try {
				List<User> users = new ArrayList<User>();
				while(result.next())
				{
					
					users.add(new User(result.getInt(1), result.getString(2), 
							result.getLong(3), result.getString(4), 
							result.getString(5), result.getString(7), 
							result.getDate(6)));
					
					
				}
				request.setAttribute("users", users);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/view-user.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("url", "view-user.jsp");
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("url", "view-user.jsp");
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
