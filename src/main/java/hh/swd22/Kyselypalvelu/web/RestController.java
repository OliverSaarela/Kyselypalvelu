package hh.swd22.Kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;

public class RestController {

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
	public @ResponseBody void saveAnswerRest(@RequestBody List<Answer> answers, Answer answer) {

		for (int i = 0; i < answers.size(); i++) {
			answer = answers.get(i);
			aRepo.save(answer);
		}

	}
	// REST-metodit päättyy
}
