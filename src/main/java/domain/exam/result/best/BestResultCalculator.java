package domain.exam.result.best;

import cqrs.EventHandler;
import domain.exam.result.new_result.ExamResultCreatedEvent;

public class BestResultCalculator implements EventHandler {
	
	private BestResultRepository bestResultRepository;

	public BestResultCalculator(BestResultRepository bestResultRepository) {
		this.bestResultRepository = bestResultRepository;
	}

	public void handle(ExamResultCreatedEvent event) {
		bestResultRepository.setBestResult(Math.max(bestResultRepository.getBestResult(), event.getPoints()));
	}
}
