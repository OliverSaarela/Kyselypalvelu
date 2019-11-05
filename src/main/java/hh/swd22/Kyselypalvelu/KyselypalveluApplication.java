package hh.swd22.Kyselypalvelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd22.Kyselypalvelu.domain.Answer;
import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Form;
import hh.swd22.Kyselypalvelu.domain.FormRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;

@SpringBootApplication
public class KyselypalveluApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}

	@Bean
	public CommandLineRunner formDemo(QuestionRepository qRepo, FormRepository fRepo, AnswerRepository aRepo) {
		return (args) -> {
			log.info("Testi");

			fRepo.save(new Form("Testikysely"));
			fRepo.save(new Form("Testikysely 2"));

			qRepo.save(new Question("Minkä vuoden opiskelija olet?", fRepo.findByFormName("Testikysely").get(0)));
			qRepo.save(new Question("Oletko käyttänyt Haaga-Helian kansainvälisyyspalveluita?",
					fRepo.findByFormName("Testikysely").get(0)));
			qRepo.save(new Question("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita?",
					fRepo.findByFormName("Testikysely").get(0)));
			qRepo.save(new Question("Minkälaista tietoa olet etsinyt MyNetistä kansainvälisyyspalveluiden sivuilta?",
					fRepo.findByFormName("Testikysely").get(0)));
			qRepo.save(new Question("Oletko ollut yhteydessä Haaga-Helian kansainvälisyystoimistoon?",
					fRepo.findByFormName("Testikysely").get(0)));
			
			qRepo.save(new Question("Mitä?", fRepo.findByFormName("Testikysely 2").get(0)));

			aRepo.save(new Answer("2019", qRepo.findByQuestionName("Minkä vuoden opiskelija olet?").get(0)));

			/*
			 * log.info("Testihaku"); for (Answer answer: aRepo.findAll()) {
			 * log.info(answer);
			 */
			// }
			
			
	
		};
		


	};

}
