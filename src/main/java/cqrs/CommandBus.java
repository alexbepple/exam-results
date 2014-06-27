package cqrs;

import domain.exam.result.new_result.CreateExamResultCommand;

public interface CommandBus {

	void handle(CreateExamResultCommand command);
	
}
