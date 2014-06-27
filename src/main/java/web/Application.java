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
import domain.exam.result.save.ExamResultPersister;
import domain.exam.result.save.ExamResultsRepository;

@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean BestResultRepository bestResultRepository() {
    	return new BestResultRepository();
    }

    @Bean ExamResultsRepository examResultsRepository() {
    	return new ExamResultsRepository();
    }
    
	@Bean CommandBus commandBus(BestResultRepository bestResultRepository, ExamResultsRepository examResultsRepository) {
		EventBus eventBus = new SimpleEventBus();
        eventBus.subscribe(ExamResultCreatedEvent.class, 
        		new BestResultCalculator(bestResultRepository));
        eventBus.subscribe(ExamResultCreatedEvent.class, 
        		new ExamResultPersister(examResultsRepository));
        
        CommandBus commandBus = new SimpleCommandBus(eventBus);
        commandBus.register(CreateExamResultCommand.class, new CreateExamResultCommandHandler());
        
        return commandBus;
	}

}
