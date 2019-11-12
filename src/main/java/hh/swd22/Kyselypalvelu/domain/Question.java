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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	private String questionName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "surveyId")
	private Survey survey;

	public Question() {
		super();
	}

	public Question(String question, Survey survey) {
		super();
		this.questionName = question;
		this.survey = survey;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setQuestionName(String question) {
		this.questionName = question;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		if (this.survey != null) {
			return "Question [questionId=" + questionId + ", questionName=" + questionName + ", survey="
					+ this.getSurvey() + "]";
		} else {
			return "Question [questionId=" + questionId + ", questionName=" + questionName + "]";
		}
	}

}
