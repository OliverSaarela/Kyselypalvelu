package hh.swd22.Kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/restforms") // Haetaan kaikki formit REST-metodi
	public @ResponseBody List<Form> FormlistREST() {
		return (List<Form>) fRepo.findAll();
	}

	@GetMapping("/restquestions") // Haetaan kaikki kysymykset REST-metodi
	public @ResponseBody List<Question> QuestionlistREST() {
		return (List<Question>) qRepo.findAll();
	}

	@GetMapping("/restanswers") // Haetaan kaikki vastaukset REST-metodi
	public @ResponseBody List<Answer> AnswerslistREST() {
		return (List<Answer>) aRepo.findAll();
	}
	
	
	// Kaikki REST-metodit päättyy

	// TODO Hakee formit tietokannasta getForms() "/forms"
	@GetMapping("/forms")
	public String getForms(Model model) {
		List<Form> forms = (List<Form>) fRepo.findAll();
		model.addAttribute("forms", forms);
		return "forms";
	}

	// TODO Hakee kysymykset tietokannasta getQuestions() "/forms/{formId}"

	// TODO Hakee vastaukset tietokannasta getAnswers()

	// TODO Tekee tyhjän formin addNewForm() "/addform"
	
	@GetMapping(value = "/addform")
	public String addNewForm(Model model) {
		model.addAttribute("form", new Form()); 
		return "addform";
	}

	
	
	// TODO Tekee tyhjän kysymyksen addNewQuestion() "/addquestion"

	// TODO Tekee tyhjän vastauksen addNewAnswer()

	// TODO Tallena formi tietokantaan saveForm() "/saveform"
	
	@PostMapping(value = "/addform")
	public String saveForm(@ModelAttribute Form form) {
	
		fRepo.save(form);
		return "redirect:/forms";
	}
	
	// TODO Tallenna kysymys tietokantaan saveQuestion() "/savequestion"

	// TODO Tallenna vastaus tietokantaan saveAnswer() "/saveanswer"

}
