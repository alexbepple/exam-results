package cqrs;

import java.util.ArrayList;
import java.util.List;

import domain.exam.result.new_result.CreateExamResultCommand;

public class SimpleCommandBus implements CommandBus {

	private List<CommandHandler> commandHandlers = new ArrayList<>();
	private EventBus eventBus;

	public SimpleCommandBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	@Override
	public void register(Class<CreateExamResultCommand> clazz,
			CommandHandler commandHandler) {
		commandHandlers.add(commandHandler);
	}

	@Override
	public void handle(CreateExamResultCommand command) {
		for (CommandHandler commandHandler: commandHandlers) {
			commandHandler.handle(command, eventBus);
		}
	}

}
