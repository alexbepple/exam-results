package domain.exam.result.best;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import domain.exam.result.new_result.ExamResultCreatedEvent;

public class BestResultCalculatorTest {

	private BestResultRepository repo = mock(BestResultRepository.class);
	private BestResultCalculator calculator = new BestResultCalculator(repo);

	@Test
	public void updatesANewBest() throws Exception {
		when(repo.getBestResult()).thenReturn(0);
		calculator.handle(new ExamResultCreatedEvent(null, 1));
		verify(repo).setBestResult(1);
	}
	
	@Test
	public void keepsExistingBest() throws Exception {
		when(repo.getBestResult()).thenReturn(0);
		calculator.handle(new ExamResultCreatedEvent(null, -1));
		verify(repo).setBestResult(0);
	}
}
