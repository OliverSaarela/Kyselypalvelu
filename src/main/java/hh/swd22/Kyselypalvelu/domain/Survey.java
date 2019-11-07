package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long surveyId;
	private String surveyName;
	private String explanation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	private List<Question> questions;

	public Survey() {
		super();
	}

	public Survey(String surveyName, String explanation) {
		super();
		this.surveyName = surveyName;
		this.explanation = explanation;
	}

	public Survey(String surveyName, String explanation, List<Question> questions) {
		super();
		this.surveyName = surveyName;
		this.explanation = explanation;
		this.questions = questions;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public String getExplanation() {
		return explanation;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questionaire [surveyId=" + surveyId + ", surveyName=" + surveyName
				+ ", explanation=" + explanation + "]";
	}

}
