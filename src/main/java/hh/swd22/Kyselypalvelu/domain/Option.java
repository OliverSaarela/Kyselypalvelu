package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long optionId;
	private String optionName;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "questionId")
	private Question question;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "option")
	private List<SelectedAnswer> selectedAnswers;

	public Option() {
		super();
	}

	public Option(String optionName, Question question) {
		super();
		this.optionName = optionName;
		this.question = question;
	}

	public Long getOptionId() {
		return optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public Question getQuestion() {
		return question;
	}

	public List<SelectedAnswer> getSelectedAnswers() {
		return selectedAnswers;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setSelectedAnswers(List<SelectedAnswer> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionName=" + optionName + "]";
	}

}
