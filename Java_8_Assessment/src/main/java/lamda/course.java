package lamda;

public class course {

	private int course_id;
	private String course_name;
	private String course_teacher;
	private String duration;
	private double total_fees;

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

	public String getCourse_teacher() {
		return course_teacher;
	}

	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getTotal_fees() {
		return total_fees;
	}

	public void setTotal_fees(double total_fees) {
		this.total_fees = total_fees;
	}

	public course(int course_id, String course_name, String course_teacher, String duration, double total_fees) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_teacher = course_teacher;
		this.duration = duration;
		this.total_fees = total_fees;
	}

	@Override
	public String toString() {
		return "course [course_id=" + course_id + ", course_name=" + course_name + ", course_teacher=" + course_teacher
				+ ", duration=" + duration + ", total_fees=" + total_fees + "]";
	}

}
