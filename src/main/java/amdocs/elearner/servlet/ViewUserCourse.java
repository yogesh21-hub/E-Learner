package amdocs.elearner.servlet;

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
import javax.servlet.http.HttpSession;

import amdocs.elearner.dao.MySQLUtil;
import amdocs.elearner.model.Course;

/**
 * Servlet implementation class ViewUserCourse
 */
@WebServlet("/ViewUserCourse")
public class ViewUserCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserCourse() {
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
		HttpSession session=request.getSession(false);  
        int user_id=(int)session.getAttribute("user_id");  
		String query="select * from course where course_id in"
				+ " (select course_id from user_course where user_id="+user_id+")";
		System.out.println("Fetching Query: "+query);
		
		//get resultset
		request.setAttribute("url", "user-home.jsp");
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
