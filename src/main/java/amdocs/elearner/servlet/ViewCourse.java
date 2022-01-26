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
 * Servlet implementation class ViewCourse
 */
@WebServlet("/ViewCourse")
public class ViewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCourse() {
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
		String query="select * from course";
		
		//get resultset
		request.setAttribute("url", "admin-home.jsp");;
		ResultSet result = MySQLUtil.fetchQuery(query);
		if(result!=null) {
			try {
				List<Course> courses = new ArrayList<Course>();
				while(result.next())
				{
					
					courses.add(new Course(result.getInt(1),result.getString(2),
							result.getString(3),result.getInt(4),
							result.getString(5)));
					
					
				}
				request.setAttribute("courses", courses);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/view-course.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("url", "view-course.jsp");
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("url", "view-course.jsp");
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
