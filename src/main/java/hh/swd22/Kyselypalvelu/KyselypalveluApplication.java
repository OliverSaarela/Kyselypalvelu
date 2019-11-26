package hh.swd22.Kyselypalvelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Option;
import hh.swd22.Kyselypalvelu.domain.OptionRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;
import hh.swd22.Kyselypalvelu.domain.Type;
import hh.swd22.Kyselypalvelu.domain.TypeRepository;

@SpringBootApplication
public class KyselypalveluApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}

	@Bean
	public CommandLineRunner formDemo(QuestionRepository qRepo, SurveyRepository sRepo, AnswerRepository aRepo, OptionRepository oRepo, TypeRepository tRepo) {
		return (args) -> {
			log.info("Testi");

			sRepo.save(new Survey("Testikysely", "Jotain"));
			sRepo.save(new Survey("Testikysely 2", "Jotain muuta"));
			
			tRepo.save(new Type("text"));

			qRepo.save(new Question("Minkä vuoden opiskelija olet?", sRepo.findBySurveyName("Testikysely").get(0), true));
			qRepo.save(new Question("Oletko käyttänyt Haaga-Helian kansainvälisyyspalveluita?",
					sRepo.findBySurveyName("Testikysely").get(0), true));
			qRepo.save(new Question("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita?",
					sRepo.findBySurveyName("Testikysely").get(0), true));
			qRepo.save(new Question("Minkälaista tietoa olet etsinyt MyNetistä kansainvälisyyspalveluiden sivuilta?",
					sRepo.findBySurveyName("Testikysely").get(0), true));
			qRepo.save(new Question("Oletko ollut yhteydessä Haaga-Helian kansainvälisyystoimistoon?",
					sRepo.findBySurveyName("Testikysely").get(0), true));
			
			qRepo.save(new Question("Mitä?", sRepo.findBySurveyName("Testikysely 2").get(0), true));
			
			oRepo.save(new Option("Ensimmäisen", qRepo.findByQuestionName("Minkä vuoden opiskelija olet?").get(0)));
			oRepo.save(new Option("Toisen", qRepo.findByQuestionName("Minkä vuoden opiskelija olet?").get(0)));
			oRepo.save(new Option("Kolmannen", qRepo.findByQuestionName("Minkä vuoden opiskelija olet?").get(0)));

			/*
			 * log.info("Testihaku"); for (Answer answer: aRepo.findAll()) {
			 * log.info(answer);
			 */
			// }
			
			
	
		};
		


	};

}
