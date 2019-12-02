package hh.swd22.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;

@CrossOrigin
@Controller
public class AnswerController {

	@Autowired
	private QuestionRepository qRepo;

	@Autowired
	private AnswerRepository aRepo;

	// TODO Tekee tyhjän vastauksen addNewAnswer()
	@GetMapping("/addanswer")
	public String addNewAnswer(Model model) {
		model.addAttribute("answer", new Answer());
		model.addAttribute("questions", qRepo.findAll());
		return "addanswer";
	}

	// TODO Tallenna vastaus tietokantaan saveAnswer() "/saveanswer"
	@PostMapping("/saveanswer")
	public String saveAnswer(@ModelAttribute Answer txtAnswer) {
		aRepo.save(txtAnswer);
		return "redirect:/survey";
	}

}
