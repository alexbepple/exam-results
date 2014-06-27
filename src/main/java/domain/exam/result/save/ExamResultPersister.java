package domain.exam.result.save;

import cqrs.EventHandler;
import domain.exam.result.new_result.ExamResultCreatedEvent;

public class ExamResultPersister implements EventHandler {

	private ExamResultsRepository resultsRepository;
	
	public ExamResultPersister(ExamResultsRepository resultsRepository) {
		super();
		this.resultsRepository = resultsRepository;
	}

	@Override
	public void handle(ExamResultCreatedEvent event) {
		resultsRepository.add(new ExamResult(event.getStudent(), event.getPoints()));
	}

}
