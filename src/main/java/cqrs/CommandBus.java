package cqrs;

import domain.exam.result.new_result.CreateExamResultCommand;

public interface CommandBus {

	void register(Class<CreateExamResultCommand> clazz, 
			CommandHandler commandHandler);
	void handle(CreateExamResultCommand command);
	
}
