package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cqrs.CommandBus;
import domain.exam.result.best.BestResultRepository;
import domain.exam.result.new_result.CreateExamResultCommand;
import domain.exam.result.save.ExamResultsRepository;

@Controller
public class ExamResultController {
	@Autowired
	private CommandBus commandBus;
	
	@Autowired
	private ExamResultsRepository examResultsRepository;
	
	@Autowired
	private BestResultRepository bestResultRepository;
	
    @RequestMapping("/add")
    public String addExamResult(
    		@RequestParam(value = "student") String student,
    		@RequestParam(value = "result") Integer result,
    		Model model
    		) {
    	commandBus.handle(new CreateExamResultCommand(student, result));
    	model.addAttribute("result", result);
    	return "added";
    }
    
    @RequestMapping("/best")
    public String bestExamResult(Model model) {
    	model.addAttribute("best", bestResultRepository.getBestResult());
    	return "best";
    }
    
    @RequestMapping("/all")
    public String allExamResults(Model model) {
    	model.addAttribute("examResults", examResultsRepository.find());
    	return "all";
    }
    
}
