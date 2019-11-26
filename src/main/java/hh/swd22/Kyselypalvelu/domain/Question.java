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
	private boolean required;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "surveyId")
	private Survey survey;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Option> options;

	public Question() {
		super();
	}

	public Question(String questionName, Survey survey, boolean required) {
		super();
		this.questionName = questionName;
		this.survey = survey;
		this.required = required;
	}
	public Question(String questionName, Survey survey) {
		super();
		this.questionName = questionName;
		this.survey = survey;
		
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
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

	public List<Option> getOptions() {
		return options;
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

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		if (this.survey != null) {
			return "Question [questionId=" + questionId + ", questionName=" + questionName + ", survey="
					+ this.getSurvey() + ", required=" + required + "]";
		} else {
			return "Question [questionId=" + questionId + ", questionName=" + questionName + ", required=" + required + "]";
		}
	}

}
