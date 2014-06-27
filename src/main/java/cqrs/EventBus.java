package cqrs;

import domain.exam.result.new_result.ExamResultCreatedEvent;

public interface EventBus {

	void subscribe(Class<ExamResultCreatedEvent> clazz,
			EventHandler eventHandler);
	
	void announce(ExamResultCreatedEvent event);

}
