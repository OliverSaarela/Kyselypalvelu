package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long typeId;
	private String typeName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	private List<Question> questions;

	public Type() {
		super();
	}

	public Type(String typeName) {
		super();
		this.typeName = typeName;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Questionaire [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
