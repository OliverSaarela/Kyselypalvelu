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
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private SurveyRepository sRepo;

	@Autowired
	private QuestionRepository qRepo;

	@Autowired
	private AnswerRepository aRepo;

	// Kaikki REST-metodit alkaa
	// Haetaan kaikki kyselyt REST-metodi
	@GetMapping("/restsurveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) sRepo.findAll();
	}

	// Haetaan yhden kyselyn kysymykset REST-metodi
	@GetMapping("/restsurveys/{surveyId}")
	public @ResponseBody Optional<Survey> questionListREest(@PathVariable("surveyId") Long surveyId) {
		return sRepo.findById(surveyId);
	}

	// Haetaan kaikki vastaukset REST-metodi
	@GetMapping("/restanswers")
	public @ResponseBody List<Answer> answersListRest() {
		return (List<Answer>) aRepo.findAll();
	}

	// Kaikki REST-metodit päättyy

	// Hakee surveys tietokannasta getSurveys() "/surveys"
	@GetMapping("/surveys")
	public String getSurveys(Model model) {
		model.addAttribute("surveys", sRepo.findAll());
		return "surveys";
	}

	// Hakee kysymykset tietokannasta getQuestions() "/surveys/{surveyName}"
	@GetMapping("/surveys/{surveyName}")
	public String getQuestions(@PathVariable("surveyName") Survey surveyName, Model model) {
		model.addAttribute("questions", qRepo.findBySurvey(surveyName));
		return "questions";
	}

	// TODO Hakee vastaukset tietokannasta getAnswers()

	// Tekee tyhjän surveyn addNewSurvey() "/addsurvey"
	@GetMapping("/addsurvey")
	public String addNewSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}

	// Tekee tyhjän kysymyksen addNewQuestion() "/addquestion"
	@GetMapping("/addquestion")
	public String addNewQuestion(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("surveys", sRepo.findAll());
		return "addquestion";
	}

	// TODO Tekee tyhjän vastauksen addNewAnswer()

	// Tallena surveyn tietokantaan saveSurvey() "/savesurvey"
	@PostMapping("/savesurvey")
	public String saveSurvey(@ModelAttribute Survey survey) {
		sRepo.save(survey);
		return "redirect:/surveys";
	}

	// Tallenna kysymys tietokantaan saveQuestion() "/savequestion"
	@PostMapping("/savequestion")
	public String saveQuestion(@ModelAttribute Question question) {
		qRepo.save(question);
		return "redirect:/surveys";
	}
	// TODO Tallenna vastaus tietokantaan saveAnswer() "/saveanswer"

}
