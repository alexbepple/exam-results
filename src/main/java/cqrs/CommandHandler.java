package cqrs;

import domain.exam.result.new_result.CreateExamResultCommand;

public interface CommandHandler {

	void handle(CreateExamResultCommand createExamResultCommand, EventBus eventBus);
}
