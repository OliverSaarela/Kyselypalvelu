package hh.swd22.Kyselypalvelu.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private SurveyRepository sRepo;

	@Autowired
	private QuestionRepository qRepo;


	// Tekee tyhjän kysymyksen addNewQuestion() "/addquestion"
	@GetMapping("/addquestion")
	public String addNewQuestion(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("surveys", sRepo.findAll());
		return "addquestion";
	}

	// Tallenna kysymys tietokantaan saveQuestion() "/savequestion"
	@PostMapping("/savequestion")
	public String saveQuestion(@ModelAttribute Question question) {
		qRepo.save(question);
		return "redirect:/survey";
	}

	// Poistaa kysymyksen kyselystä
	@RequestMapping(value = "/deletequestion/{id}")
	public String deleteQuestion(@PathVariable("id") Long questionId) {
		qRepo.deleteById(questionId);
		return "redirect:../survey";
	}
	


	@GetMapping("/editquestion/{id}")
	public String editQuestion(@PathVariable("id") Long questionId, Model model) {
		
		model.addAttribute("question", qRepo.findById(questionId));
		model.addAttribute("survey", sRepo.findAll());
		return "editquestion";
	}

}
