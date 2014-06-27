package cqrs;

import exam.ExamResultCreatedEvent;

public interface EventBus {

	void subscribe(Class<ExamResultCreatedEvent> clazz,
			EventHandler eventHandler);
	
	void announce(ExamResultCreatedEvent event);

}
