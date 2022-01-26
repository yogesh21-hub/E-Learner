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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		int user_id = Integer.parseInt(request.getParameter("admin_id"));
		String password = request.getParameter("password");
		
		//fetch query
		String query = String.format("select * from admin where admin_id=%1$d "
				+ "and password='%2$s'",user_id,password);
		System.out.println("Fetching Query:"+query);
		
		//get resultset
		ResultSet result = MySQLUtil.fetchQuery(query);
		if(result!=null) {
			try {
				if (result.next())
				{
					HttpSession session = request.getSession();
					session.setAttribute("admin_name", result.getString(2));
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("/admin-home.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("wrongCredentials", 1);
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher("/admin-login.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("url", "admin-login.jsp");
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("url", "admin-login.jsp");
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
