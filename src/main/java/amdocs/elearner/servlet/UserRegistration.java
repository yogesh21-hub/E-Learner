package amdocs.elearner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amdocs.elearner.dao.MySQLUtil;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//set content type
		response.setContentType("text/html");
		
		//get writer
		PrintWriter out = response.getWriter();
		
		//get html form data
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String address = request.getParameter("address");
		String photo = request.getParameter("photo");
		
		//insert query
		String query = String.format("insert into user1 (user_id,name,"
				+ "phone_no,email,address,password,upload_photo) "
				+ "values(%1$d,'%2$s','%3$d','%4$s','%5$s','%6$s','%7$s')",
				user_id,name,phone,email,address,password,photo);
		System.out.println("Inserting Query:"+query);
		String result = MySQLUtil.insertQuery(query);
		if(result=="success") {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		else if (result=="integrityfailure")
		{
			request.setAttribute("userExist", 1);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/user-registration.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("url", "user-registration.jsp");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
