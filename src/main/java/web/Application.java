package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import cqrs.CommandBus;
import cqrs.EventBus;
import cqrs.SimpleEventBus;
import exam.BestResultCalculator;
import exam.CreateExamResultCommand;
import exam.ExamResultCreatedEvent;

@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Bean CommandBus commandGateway() {
		final EventBus eventBus = new SimpleEventBus();
        eventBus.subscribe(ExamResultCreatedEvent.class, new BestResultCalculator());
   
        return new CommandBus() {
			
			@Override
			public void handle(CreateExamResultCommand command) {
				eventBus.announce(new ExamResultCreatedEvent(command.getStudent(), command.getPoints()));
			}
		};
	}

}
