package hh.swd22.Kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String txtAnswer;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "questionId")
	private Question question;

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

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public void setTxtAnswer(String txtAnswer) {
		this.txtAnswer = txtAnswer;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
