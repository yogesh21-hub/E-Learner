package amdocs.elearner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amdocs.elearner.dao.MySQLUtil;

/**
 * Servlet implementation class EnrollCourse
 */
@WebServlet("/EnrollCourse")
public class EnrollCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollCourse() {
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
		
		if(request.getParameterValues("course_id")==null)
		{
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/user-home.jsp");
			dispatcher.forward(request, response);
		}
		else {
		//get html form data
		List<Integer> courses = new ArrayList<Integer>();
		
		for(String temp:request.getParameterValues("course_id"))
		{
			courses.add(Integer.parseInt(temp));
		}
		
		//insert query
		HttpSession session=request.getSession(false);  
        int user_id=(int)session.getAttribute("user_id");
		String query = "insert into user_course(user_id,course_id) values";
		for(int course_id:courses)
		{
			query+="("+user_id+","+course_id+"),";
		}
		query=query.substring(0, query.length() -1);
		
		System.out.println("Inserting Query:"+query);
		
		// Invoking DAO to store into Database
		String result = MySQLUtil.insertQuery(query);
		if(result=="success") {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/user-home.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("url", "enroll-course.jsp");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
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
