package exam;

import cqrs.EventHandler;

public class BestResultCalculator implements EventHandler {

	public void handle(ExamResultCreatedEvent event) {
		BestResultRepository.bestResult = Math.max(BestResultRepository.bestResult, event.getPoints());
	}
}
