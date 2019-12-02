package hh.swd22.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;
import hh.swd22.Kyselypalvelu.domain.TypeRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private SurveyRepository sRepo;

	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private TypeRepository tRepo;
	
	// Hakee kysymykset tietokannasta getQuestions() "/survey/{surveyId}"
	@GetMapping("/survey/{surveyId}")
	public String getQuestions(@PathVariable("surveyId") Survey surveyId, Model model) {
		model.addAttribute("questions", qRepo.findBySurvey(surveyId));
		return "questions";
	}

	// Tekee tyhjän kysymyksen addNewQuestion() "/addquestion"
	@GetMapping("/addquestion")
	public String addNewQuestion(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("surveys", sRepo.findAll());
		model.addAttribute("types", tRepo.findAll());
		return "addquestion";
	}

	// Tallenna kysymys tietokantaan saveQuestion() "/savequestion"
	@PostMapping("/savequestion")
	public String saveQuestion(@ModelAttribute Question question) {
		qRepo.save(question);
		return "redirect:/survey";
	}

	// Poistaa kysymyksen kyselystä
	@GetMapping("/deletequestion/{questionId}")
	public String deleteQuestion(@PathVariable("questionId") Long questionId) {
		qRepo.deleteById(questionId);
		return "redirect:../survey";
	}

	// Muokkaa kysymystä
	@GetMapping("/editquestion/{questionId}")
	public String editQuestion(@PathVariable("questionId") Long questionId, Model model) {
		Question question = qRepo.findByquestionId(questionId);
		boolean required = question.isRequired();
		
		model.addAttribute("question", qRepo.findById(questionId));
		model.addAttribute("surveys", sRepo.findAll());
		model.addAttribute("types", tRepo.findAll());
		model.addAttribute("required", required);
		return "editquestion";
	}

}
