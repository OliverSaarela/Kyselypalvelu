package hh.swd22.Kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Form;
import hh.swd22.Kyselypalvelu.domain.FormRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;

public class QuestionController {

	@Autowired 
	private FormRepository fRepo;
	
	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private AnswerRepository aRepo;
	
	
	
	@RequestMapping (value="/forms", method =RequestMethod.GET) // Haetaan kaikki listat
	public @ResponseBody List <Form> FormlistREST(){
		return (List <Form>) fRepo.findAll();
	}
	
	@RequestMapping(value = "/saveform", method = RequestMethod.POST) // Tallennetaan formi
	public @ResponseBody Form SaveFormREST(@RequestBody Form form) {
	
		 return fRepo.save(form);
		
	}
	
	
	
	
	
	@RequestMapping (value="/questions", method =RequestMethod.GET) // Haetaan kaikki kys
	public @ResponseBody List <Question> QuestionlistREST(){
		return (List <Question>) qRepo.findAll();
	}
	
	@RequestMapping(value = "/savequestion", method = RequestMethod.POST) // Tallennetaan kys
	public @ResponseBody Question SaveQuestinREST(@RequestBody Question question) {
	
		 return qRepo.save(question);
		
	}
	
	
	
	
	
	@RequestMapping (value="/answers", method =RequestMethod.GET) // Haetaan kaikki vastaukset
	public @ResponseBody List <Answer> AnswerslistREST(){
		return (List <Answer>) aRepo.findAll();
	}
	
	@RequestMapping(value = "/saveanswer", method = RequestMethod.POST) // Tallennetaan vastaus
	public @ResponseBody Answer SaveQuestinREST(@RequestBody Answer answer) {
	
		 return aRepo.save(answer);
		
	}
	
	
	
}
