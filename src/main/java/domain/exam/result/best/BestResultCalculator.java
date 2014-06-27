package domain.exam.result.best;

import cqrs.EventHandler;
import domain.exam.result.new_result.ExamResultCreatedEvent;

public class BestResultCalculator implements EventHandler {

	public void handle(ExamResultCreatedEvent event) {
		BestResultRepository.bestResult = Math.max(BestResultRepository.bestResult, event.getPoints());
	}
}
