package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{

	List<Answer> findByTxtAnswer(String txtAnswer);
}
