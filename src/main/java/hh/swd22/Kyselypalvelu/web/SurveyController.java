package hh.swd22.Kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
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
	
	@Autowired
	private AnswerRepository aRepo;

	// Kaikki REST-metodit alkaa
	// Haetaan kaikki kyselyt REST-metodi
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) sRepo.findAll();
	}

	// Haetaan yhden kyselyn kysymykset REST-metodi
	@GetMapping("/surveys/{surveyId}")
	public @ResponseBody Optional<Survey> questionListRest(@PathVariable("surveyId") Long surveyId) {
		return sRepo.findById(surveyId);
	}

	// Haetaan kaikki vastaukset REST-metodi
	@GetMapping("/answers")
	public @ResponseBody List<Answer> answersListRest() {
		return (List<Answer>) aRepo.findAll();
	}

	// Tallenna yhden vastauksen
	@PostMapping("/saveanswers")
	public @ResponseBody void saveAnswerRest(@RequestBody List<Answer> answers) {
		Answer answer = null;
		for (int i = 0; i < answers.size(); i++) {
			answer = answers.get(i);
			aRepo.save(answer);
		}

	}

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
	
	@GetMapping("/delete/{id}")
	public String deleteSurvey(@PathVariable("id") Long surveyId) {
		sRepo.deleteById(surveyId);
		return "redirect:../survey";
	}

	@RequestMapping(value = "/editsurvey/{id}")
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
	
		model.addAttribute("survey", sRepo.findById(surveyId));
		sRepo.deleteById(surveyId);
		return "editsurvey";
	}
	
	@RequestMapping(value = "editsurvey/save", method = RequestMethod.POST)
	public String saveEdit(Survey survey){
	    sRepo.save(survey);
	    return "redirect:../survey";
	}   
	
}
	
