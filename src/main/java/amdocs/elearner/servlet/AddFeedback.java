package amdocs.elearner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amdocs.elearner.dao.MySQLUtil;

/**
 * Servlet implementation class AddFeedback
 */
@WebServlet("/AddFeedback")
public class AddFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedback() {
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
		//set content type
		response.setContentType("text/html");
		
		//get writer
		PrintWriter out = response.getWriter();
		
		//get html form data
		HttpSession session=request.getSession(false);  
        int user_id=(int)session.getAttribute("user_id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String feedback = request.getParameter("feedback");
		
		//insert query
		String query = String.format("insert into feedback (user_id,name,"
				+ "email,feedback) values(%1$d,'%2$s','%3$s','%4$s')"
				,user_id,name,email,feedback);
		System.out.println("Inserting Query:"+query);
		
		String result = MySQLUtil.insertQuery(query);
		if(result=="success") {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/user-home.jsp");
			dispatcher.forward(request, response);
		}
		else if(result=="integrityfailure") {
			request.setAttribute("userNotExist", 1);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/feedback.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("url", "feedback.jsp");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
