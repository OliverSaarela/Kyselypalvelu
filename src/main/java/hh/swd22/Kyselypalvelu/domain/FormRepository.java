package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FormRepository extends CrudRepository<Form, Long>{
	
	List<Form> findByFormName(String formName);

}
