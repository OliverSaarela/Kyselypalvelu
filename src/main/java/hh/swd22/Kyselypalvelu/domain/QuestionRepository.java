package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>{

	List<Question> findByQuestionName(String questionName);
	List<Question> findByForm(Form form);
	
}
