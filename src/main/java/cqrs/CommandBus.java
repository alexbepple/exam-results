package cqrs;

import exam.CreateExamResultCommand;

public interface CommandBus {

	void handle(CreateExamResultCommand command);
	
}
