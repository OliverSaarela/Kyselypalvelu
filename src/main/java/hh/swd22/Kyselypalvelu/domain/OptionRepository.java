package hh.swd22.Kyselypalvelu.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long>{

	List<Option> findByOptionName(String optionName);
}
