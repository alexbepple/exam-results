package domain.exam.result.new_result;

public class ExamResultCreatedEvent {

	private final String student;
	private final Integer points;
	
	public ExamResultCreatedEvent(String student, Integer points) {
		this.student = student;
		this.points = points;
	}
	
	public String getStudent() {
		return student;
	}
	
	public Integer getPoints() {
		return points;
	}

}
