package cqrs;

import exam.ExamResultCreatedEvent;

public interface EventHandler {

	void handle(ExamResultCreatedEvent event);

}
