package cqrs;

import domain.exam.result.new_result.ExamResultCreatedEvent;

public interface EventHandler {

	void handle(ExamResultCreatedEvent event);

}
