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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionName")
	private List<Answer> answers;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "formId")
	private Form form;

	public Question() {
		super();
	}

	public Question(String question, Form form) {
		super();
		this.questionName = question;
		this.form = form;
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

	public Form getForm() {
		return form;
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

	public void setForm(Form form) {
		this.form = form;
	}

	@Override
	public String toString() {
		if (this.form != null) {
			return "Question [questionId=" + questionId + ", questionName=" + questionName + ", form="
					+ this.getForm() + "]";
		} else {
			return "Question [questionId=" + questionId + ", questionName=" + questionName + "]";
		}
	}

}
