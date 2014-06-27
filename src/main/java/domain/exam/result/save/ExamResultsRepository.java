package domain.exam.result.save;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamResultsRepository {

	private List<ExamResult> examResults = new ArrayList<>();

	public void add(ExamResult examResult) {
		examResults.add(examResult);
	}

	public List<ExamResult> find() {
		return Collections.unmodifiableList(examResults);
	}

}
