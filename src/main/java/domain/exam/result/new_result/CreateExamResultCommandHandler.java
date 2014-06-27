package domain.exam.result.new_result;

import cqrs.CommandHandler;
import cqrs.EventBus;

public class CreateExamResultCommandHandler implements CommandHandler {

	@Override
	public void handle(CreateExamResultCommand command, EventBus eventBus) {
		eventBus.announce(new ExamResultCreatedEvent(command.getStudent(), command.getPoints()));
	}

}
