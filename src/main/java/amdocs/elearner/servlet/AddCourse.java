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
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
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
		int course_id = Integer.parseInt(request.getParameter("course_id"));
		String course_name = request.getParameter("course_name");
		String course_description = request.getParameter("course_description");
		String course_resources = request.getParameter("course_resources");
		int course_fees = Integer.parseInt(request.getParameter("course_fees"));
		
		//insert query
		String query = String.format("insert into course (course_id,c_name,"
				+ "c_desp,c_fees,c_resource) values(%1$d,'%2$s','%3$s',%4$d,"
				+ "'%5$s')",course_id,course_name,course_description,
				course_fees,course_resources);
		System.out.println("Inserting Query:"+query);
		
		// Invoking DAO to store into Database
		String result = MySQLUtil.insertQuery(query);
		if(result=="success") {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/admin-home.jsp");
			dispatcher.forward(request, response);
		}
		else if(result=="integrityfailure")
		{
			request.setAttribute("courseExist", 1);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/course.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("url", "course.jsp");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
