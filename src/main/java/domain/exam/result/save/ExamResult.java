package domain.exam.result.save;

public class ExamResult {

	private String student;
	private Integer points;

	public ExamResult(String student, Integer points) {
		this.setStudent(student);
		this.setPoints(points);
	}

	public String getStudent() {
		return student;
	}

	private void setStudent(String student) {
		this.student = student;
	}

	public Integer getPoints() {
		return points;
	}

	private void setPoints(Integer points) {
		this.points = points;
	}

}
