package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Form {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long formId;
	private String formName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
	private List<Question> questions;

	public Form() {
		super();
	}

	public Form(String formName, List<Question> questions) {
		super();
		this.formName = formName;
		this.questions = questions;
	}

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Form [formId=" + formId + ", formName=" + formName + "]";
	}
	
	
	
}
