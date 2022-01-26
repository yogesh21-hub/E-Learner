package amdocs.elearner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amdocs.elearner.dao.MySQLUtil;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		//get html form data
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String password = request.getParameter("password");
		
		//fetch query
		String query = String.format("select * from user1 where user_id=%1$d "
				+ "and password='%2$s'",user_id,password);
		System.out.println("Fetching Query:"+query);
		
		//get resultset
		ResultSet result = MySQLUtil.fetchQuery(query);
		if(result!=null) {
			try {
				if (result.next())
				{
//					request.setAttribute("name", result.getString(2));
					HttpSession session = request.getSession();
					session.setAttribute("user_name", result.getString(2));
					session.setAttribute("user_id", result.getInt(1));
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("/user-home.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("wrongCredentials", 1);
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("url", "index.jsp");
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("url", "index.jsp");
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
