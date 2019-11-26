package hh.swd22.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository sRepo;

	@Autowired
	private QuestionRepository qRepo;


	@GetMapping(value = { "/", "/resthome" })
	public String getHome() {
		return "resthome";
	}

	// Hakee surveys tietokannasta getSurveys() "/surveys"
	@GetMapping("/survey")
	public String getSurveys(Model model) {
		model.addAttribute("surveys", sRepo.findAll());
		return "surveys";
	}

	// Hakee kysymykset tietokannasta getQuestions() "/survey/{surveyName}"
	@GetMapping("/survey/{surveyName}")
	public String getQuestions(@PathVariable("surveyName") Survey surveyName, Model model) {
		model.addAttribute("questions", qRepo.findBySurvey(surveyName));
		return "questions";
	}


	// Tekee tyhjän surveyn addNewSurvey() "/addsurvey"
	@GetMapping("/addsurvey")
	public String addNewSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}

	// Tallena surveyn tietokantaan saveSurvey() "/savesurvey"
	@PostMapping("/savesurvey")
	public String saveSurvey(@ModelAttribute Survey survey) {
		sRepo.save(survey);
		return "redirect:/survey";
	}

}
