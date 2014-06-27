package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import cqrs.CommandBus;
import cqrs.EventBus;
import cqrs.SimpleCommandBus;
import cqrs.SimpleEventBus;
import domain.exam.result.best.BestResultCalculator;
import domain.exam.result.best.BestResultRepository;
import domain.exam.result.new_result.CreateExamResultCommand;
import domain.exam.result.new_result.CreateExamResultCommandHandler;
import domain.exam.result.new_result.ExamResultCreatedEvent;

@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean BestResultRepository bestResultRepository() {
    	return new BestResultRepository();
    }

	@Bean CommandBus commandBus(BestResultRepository bestResultRepository) {
		final EventBus eventBus = new SimpleEventBus();
        eventBus.subscribe(ExamResultCreatedEvent.class, new BestResultCalculator(bestResultRepository));
        
        CommandBus commandBus = new SimpleCommandBus(eventBus);
        commandBus.register(CreateExamResultCommand.class, new CreateExamResultCommandHandler());
        
        return commandBus;
	}

}
