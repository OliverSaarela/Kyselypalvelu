package hh.swd22.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SelectedAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long selectedAnswerId;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "answerId")
	private Answer answer;

	@ManyToOne
	//@JsonBackReference
	@JsonIgnoreProperties(value = {"selectedAnswers"}, allowSetters = true)
	@JoinColumn(name = "optionId")
	private Option option;

	public SelectedAnswer() {
		super();
	}

	public SelectedAnswer(Answer answer, Option option) {
		super();
		this.answer = answer;
		this.option = option;
	}

	public Long getSelectedAnswerId() {
		return selectedAnswerId;
	}

	public Answer getAnswer() {
		return answer;
	}

	public Option getOption() {
		return option;
	}

	public void setSelectedAnswerId(Long selectedAnswerId) {
		this.selectedAnswerId = selectedAnswerId;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}
