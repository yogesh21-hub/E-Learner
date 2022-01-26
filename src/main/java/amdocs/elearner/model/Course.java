package amdocs.elearner.model;

public class Course {
	private int course_id;
	private String course_name;
	private String course_desp;
	private int course_fees;
	private String course_resource;
	
	public Course(int course_id, String course_name, String course_desp, int course_fees, String course_resource) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_desp = course_desp;
		this.course_fees = course_fees;
		this.course_resource = course_resource;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_desp() {
		return course_desp;
	}

	public void setCourse_desp(String course_desp) {
		this.course_desp = course_desp;
	}

	public int getCourse_fees() {
		return course_fees;
	}

	public void setCourse_fees(int course_fees) {
		this.course_fees = course_fees;
	}

	public String getCourse_resource() {
		return course_resource;
	}

	public void setCourse_resource(String course_resource) {
		this.course_resource = course_resource;
	}
	
	
}
