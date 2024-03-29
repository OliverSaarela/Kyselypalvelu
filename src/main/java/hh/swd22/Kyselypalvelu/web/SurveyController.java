package hh.swd22.Kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.SelectedAnswer;
import hh.swd22.Kyselypalvelu.domain.SelectedAnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepo;

	@Autowired
	private AnswerRepository answerRepo;

	@Autowired
	private SelectedAnswerRepository selectedAnswerRepo;
	
	//Ohjaus login-templateen
	 @GetMapping(value = "/login")
		public String login() {
			return "login";
		}

	// Kaikki REST-metodit alkaa
	// Haetaan kaikki kyselyt REST-metodi
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) surveyRepo.findAll();
	}

	// Haetaan yhden kyselyn kysymykset REST-metodi
	@GetMapping("/surveys/{surveyId}")
	public @ResponseBody Optional<Survey> questionListRest(@PathVariable("surveyId") Long surveyId) {
		return surveyRepo.findById(surveyId);
	}

	// Tallenna yhden vastauksen
	@PostMapping("/saveanswers")
	public @ResponseBody List<Answer> saveAnswerRest(@RequestBody List<Answer> answers) {
		Answer answer = null;
		SelectedAnswer selectedAnswer = null;
		for (int i = 0; i < answers.size(); i++) {
			answer = answers.get(i);

			answerRepo.save(answer);

			for (int j = 0; j < answer.getSelectedAnswers().size(); j++) {
				selectedAnswer = answer.getSelectedAnswers().get(j);
				selectedAnswer.setAnswer(answer);
				selectedAnswerRepo.save(selectedAnswer);
			}

		}
		return answers;

	}
	// Tähän päättyy kaikki rest-metodit
	//
	//
	//
	//
	//
	//

	@GetMapping(value = { "/", "/resthome" })
	public String getHome() {
		return "resthome";
	}

	// Hakee surveys tietokannasta getSurveys() "/surveys"
	@GetMapping("/survey")
	public String getSurveys(Model model) {
		model.addAttribute("surveys", surveyRepo.findAll());
		return "surveys";
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
		surveyRepo.save(survey);
		return "redirect:/survey";
	}

	// Poistaa kyselyn tietokannasta
	@GetMapping("/deletesurvey/{id}")

	public String deleteSurvey(@PathVariable("id") Long surveyId) {
		surveyRepo.deleteById(surveyId);
		return "redirect:../survey";
	}

	// Muokkaa kyselyä
	@GetMapping("/editsurvey/{id}")
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {

		model.addAttribute("survey", surveyRepo.findById(surveyId));
		surveyRepo.deleteById(surveyId);
		return "editsurvey";
	}

}
