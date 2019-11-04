package hh.swd22.Kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	// Hakee formit tietokannasta getForms() "/forms"
	@GetMapping("/forms")
	public String getForms(Model model) {
		model.addAttribute("forms", fRepo.findAll());
		return "forms";
	}

	// Hakee kysymykset tietokannasta getQuestions() "/forms/{formName}"
	@GetMapping("/forms/{formName}")
	public String getQuestions(@PathVariable("formName") Form formName, Model model) {
		model.addAttribute("questions", qRepo.findByForm(formName));
		return "questions";
	}

	// TODO Hakee vastaukset tietokannasta getAnswers()

	// Tekee tyhjän formin addNewForm() "/addform"
	@GetMapping("/addform")
	public String addNewForm(Model model) {
		model.addAttribute("form", new Form());
		return "addform";
	}

	// Tekee tyhjän kysymyksen addNewQuestion() "/addquestion"
	@GetMapping("/addquestion")
	public String addNewQuestion(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("forms", fRepo.findAll());
		return "addquestion";
	}

	// TODO Tekee tyhjän vastauksen addNewAnswer()

	// Tallena formi tietokantaan saveForm() "/saveform"
	@PostMapping("/saveform")
	public String saveForm(@ModelAttribute Form form) {
		fRepo.save(form);
		return "redirect:/forms";
	}

	// Tallenna kysymys tietokantaan saveQuestion() "/savequestion"
	@PostMapping("/savequestion")
	public String saveQuestion(@ModelAttribute Question question) {
		qRepo.save(question);
		return "redirect:/forms";
	}
	// TODO Tallenna vastaus tietokantaan saveAnswer() "/saveanswer"

}
