package exam;


public class CreateExamResultCommand {

    private final String student;
	private final Integer points;
	
	public CreateExamResultCommand(String student, Integer points) {
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
