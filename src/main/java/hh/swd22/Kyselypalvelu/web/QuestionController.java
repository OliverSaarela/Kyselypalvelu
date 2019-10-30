package hh.swd22.Kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Form;
import hh.swd22.Kyselypalvelu.domain.FormRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private FormRepository fRepo;

	@Autowired
	private QuestionRepository qRepo;

	@Autowired
	private AnswerRepository aRepo;

	// Kaikki REST-metodit alkaa
	@GetMapping(value = "/forms") // Haetaan kaikki formit REST-metodi
	public @ResponseBody List<Form> FormlistREST() {
		return (List<Form>) fRepo.findAll();
	}

	@GetMapping(value = "/questions") // Haetaan kaikki kysymykset REST-metodi
	public @ResponseBody List<Question> QuestionlistREST() {
		return (List<Question>) qRepo.findAll();
	}

	@GetMapping(value = "/answers") // Haetaan kaikki vastaukset REST-metodi
	public @ResponseBody List<Answer> AnswerslistREST() {
		return (List<Answer>) aRepo.findAll();
	}
	// Kaikki REST-metodit päättyy

	// TODO Hakee formit tietokannasta getForms() "/form"
	
	// TODO Hakee kysymykset tietokannasta getQuestions() "/question"
	
	// TODO Hakee vastaukset tietokannasta getAnswers()
	
	// TODO Tekee tyhjän formin addNewForm() "/addform"
	
	// TODO Tekee tyhjän kysymyksen addNewQuestion() "/addquestion"
	
	// TODO Tekee tyhjän vastauksen addNewAnswer()
	
	// TODO Tallena formi tietokantaan saveForm() "/saveform"
	
	// TODO Tallenna kysymys tietokantaan saveQuestion() "/savequestion"
	
	// TODO Tallenna vastaus tietokantaan saveAnswer() "/saveanswer"

}
