package hh.swd22.Kyselypalvelu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd22.Kyselypalvelu.domain.Option;
import hh.swd22.Kyselypalvelu.domain.OptionRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;

@CrossOrigin
@Controller
public class OptionController {
	
	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private OptionRepository oRepo;
	
	// Listaa kysymyksen vaihtoehdot
	@GetMapping("/survey/{surveyId}/{questionId}")
	public String getQuestions(@PathVariable("questionId") Question questionId, Model model) {
		model.addAttribute("options", oRepo.findByQuestion(questionId));
		return "options";
	}

	// Lisää uuden vaihtoehdon
	@GetMapping("/addoption")
	public String addNewOption(Model model) {
		model.addAttribute("option", new Option());
		model.addAttribute("questions", qRepo.findAll());
		return "addoption";
	}
	
	// Tallentaa vaihtoehdon
	@PostMapping("/saveoption")
	public String saveOption(@ModelAttribute Option option) {
		oRepo.save(option);
		return "redirect:/survey";
	}
	
	// Poistaa vaihtoehdon
	@GetMapping("/deleteoption/{optionId}")
	public String deleteOption(@PathVariable("optionId") Long optionId) {
		oRepo.deleteById(optionId);
		return "redirect:../survey";
	}
	
	// Muokkaa vaihtoehtoa
	@GetMapping("/editoption/{optionId}")
	public String editOption(@PathVariable("optionId") Long optionId, Model model) {
		model.addAttribute("option", oRepo.findById(optionId));
		model.addAttribute("questions", qRepo.findAll());
		return "editoption";
	}
}
