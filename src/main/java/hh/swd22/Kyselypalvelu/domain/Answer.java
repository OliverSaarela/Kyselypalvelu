package hh.swd22.Kyselypalvelu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerId;
	private String txtAnswer;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "questionId")
	private Question question;
	
	@Column
	@ElementCollection(targetClass=Option.class)
	private List<Option> pickedOptions = new ArrayList<Option>();

	public Answer() {
		super();
	}

	public Answer(String txtAnswer, Question question) {
		super();
		this.txtAnswer = txtAnswer;
		this.question = question;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public String getTxtAnswer() {
		return txtAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public List<Option> getOptions() {
		return pickedOptions;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public void setTxtAnswer(String txtAnswer) {
		this.txtAnswer = txtAnswer;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setOptions(List<Option> options) {
		this.pickedOptions = options;
	}

	@Override
	public String toString() {
		if (this.question != null) {
			return "Answer [answerId=" + answerId + ", txtAnswer=" + txtAnswer + ", question=" + this.getQuestion() + "]";
		}
		else {
			return "Answer [answerId=" + answerId + ", txtAnswer=" + txtAnswer + "]";
		}
	}
	
	
}
