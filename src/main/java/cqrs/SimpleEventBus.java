package cqrs;

import java.util.ArrayList;
import java.util.List;

import domain.exam.result.new_result.ExamResultCreatedEvent;

public class SimpleEventBus implements EventBus {

	private List<EventHandler> eventHandlers = new ArrayList<>();

	@Override
	public void subscribe(Class<ExamResultCreatedEvent> clazz,
			EventHandler eventHandler) {
		eventHandlers.add(eventHandler);
	}

	@Override
	public void announce(ExamResultCreatedEvent event) {
		for (EventHandler eventHandler: eventHandlers) {
			eventHandler.handle(event);
		}
	}

}
