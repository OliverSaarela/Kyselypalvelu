package hh.swd22.Kyselypalvelu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd22.Kyselypalvelu.domain.AnswerRepository;
import hh.swd22.Kyselypalvelu.domain.Option;
import hh.swd22.Kyselypalvelu.domain.OptionRepository;
import hh.swd22.Kyselypalvelu.domain.Question;
import hh.swd22.Kyselypalvelu.domain.QuestionRepository;
import hh.swd22.Kyselypalvelu.domain.Survey;
import hh.swd22.Kyselypalvelu.domain.SurveyRepository;
import hh.swd22.Kyselypalvelu.domain.Type;
import hh.swd22.Kyselypalvelu.domain.TypeRepository;
import hh.swd22.Kyselypalvelu.domain.User;
import hh.swd22.Kyselypalvelu.domain.UserRepository;

@SpringBootApplication
public class KyselypalveluApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}

	@Bean
	public CommandLineRunner formDemo(QuestionRepository qRepo, SurveyRepository sRepo, AnswerRepository aRepo,
			OptionRepository oRepo, TypeRepository tRepo, UserRepository userrepository) {
		return (args) -> {
			log.info("Testi");

			tRepo.save(new Type("text"));
			tRepo.save(new Type("radio"));
			tRepo.save(new Type("checkbox"));
			tRepo.save(new Type("select"));

			// Ensimmäinen Kysely
			sRepo.save(new Survey("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista",
					"Tämän kyselyn tarkoituksena on kehittää Haaga-Helian kansainvälisyyspalveluita. Kysely on suunnattu Haaga-Helian Suomessa asuville opiskelijoille jotka ovat käyttäneet kansainvälisyyspalveluita."));
			
			// Ensimmäinen Kysymys
			qRepo.save(new Question("Valitse oma koulutusohjelmasi tai kampuksesi:", true,
					sRepo.findBySurveyName("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista").get(0),
					tRepo.findByTypeName("select").get(0)));
			
			// Ensimmäisen kysymyksen vaihtoehdot
			oRepo.save(new Option("Haagan kampuksen koulutusohjelmat", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Porvoon kampuksen koulutusohjelmat", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Vierumäen kampuksen koulutusohjelmat", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Helsingin ylemmän ammattikorkeakoulun ohjelmat (YAMK)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Finanssi- ja talousasiantuntijan koulutusohjelma (FINA)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Liiketalouden koulutusohjelma (Malmi, HELI-M)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Liiketalouden koulutusohjelma (Pasila, HELI-P)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Myyntityön koulutusohjelma (MYYNTI)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("International Business (GLOBBA)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Tietojenkäsittelyn koulutusohjelma (HETI)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Degree Programme in Business Information Technology (BITE)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Johdon assistenttityön ja kielten koulutusohjelma (ASSI)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Journalismin koulutusohjelma (JOURA)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			oRepo.save(new Option("Degree Programme for Multilingual Management Assistants (MUBBA)", qRepo.findByQuestionName("Valitse oma koulutusohjelmasi tai kampuksesi:").get(0)));
			
			// Toinen Kysymys
			qRepo.save(new Question("Monettako vuotta opiskelet Haaga-Heliassa?", false,
					sRepo.findBySurveyName("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista").get(0),
					tRepo.findByTypeName("radio").get(0)));
			
			// Toisen kysymyksen vaihtoehdot
			oRepo.save(new Option("Ensimmäistä", qRepo.findByQuestionName("Monettako vuotta opiskelet Haaga-Heliassa?").get(0)));
			oRepo.save(new Option("Toista", qRepo.findByQuestionName("Monettako vuotta opiskelet Haaga-Heliassa?").get(0)));
			oRepo.save(new Option("Kolmatta", qRepo.findByQuestionName("Monettako vuotta opiskelet Haaga-Heliassa?").get(0)));
			oRepo.save(new Option("Neljättä tai enemmän", qRepo.findByQuestionName("Monettako vuotta opiskelet Haaga-Heliassa?").get(0)));
			
			// Kolmas kysymys
			qRepo.save(new Question("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)", true,
					sRepo.findBySurveyName("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista").get(0),
					tRepo.findByTypeName("checkbox").get(0)));
			
			// Kolmannen kysymyksen vaihtoehdot
			oRepo.save(new Option("Vaihto-opinnot Haaga-Helian yhteistyökoulussa", qRepo.findByQuestionName("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Vaihto-opinnot muussa kuin Haaga-Helian yhteistyökoulussa", qRepo.findByQuestionName("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Kansainväliset kesäkurssit tai muut lyhyet kurssit ulkomailla", qRepo.findByQuestionName("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Erasmus for Young Entrepreneurs", qRepo.findByQuestionName("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Työharjoittelu ulkomailla", qRepo.findByQuestionName("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Double degree programs (kaksoistutkinto yhteistyökoulussa)", qRepo.findByQuestionName("Mihin tarkoitukseen olet käyttänyt kansainvälisyyspalveluita? (Voit valita useampia.)").get(0)));
			
			// Neljäs Kysymys
			qRepo.save(new Question("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)", true,
					sRepo.findBySurveyName("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista").get(0),
					tRepo.findByTypeName("checkbox").get(0)));
			
			// Neljännen kysymyksen vaihtoehdot
			oRepo.save(new Option("Haaga-Helian yhteistyökoulut", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Tuet vaihto-opiskelijoille", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Tuet kesäkursseille tai muille lyhyille kursseille", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Tuet työharjoitteluun ulkomaille", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Esteettömyystuki", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Vakuutukset ulkomailla", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Hakuajat ja tärkeät päivämäärät", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Terveydenhuolto ulkomailla", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Vaihto-oppilaiden tutorointi", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Kansainväliset opiskelijajärjestöt", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Aiempien vaihto-oppilaiden vaihtoraportit", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			oRepo.save(new Option("Vaihtoraporttipohjat", qRepo.findByQuestionName("Mistä aiheista olet etsinyt tietoa MyNetistä kansainvälisyyspalveluiden sivuilta? (Voit valita useampia.)").get(0)));
			
			// Viides Kysymys
			qRepo.save(new Question("Kuinka helposti olet löytänyt etsimääsi tietoa? Valitse sopivin vaihtoehto vastakohtaparien välillä.", false,
					sRepo.findBySurveyName("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista").get(0),
					tRepo.findByTypeName("radio").get(0)));
			
			// Viidennen kysymyksen vaihtoehdot
			oRepo.save(new Option("helppous1", qRepo.findByQuestionName("Kuinka helposti olet löytänyt etsimääsi tietoa? Valitse sopivin vaihtoehto vastakohtaparien välillä.").get(0)));
			oRepo.save(new Option("helppous2", qRepo.findByQuestionName("Kuinka helposti olet löytänyt etsimääsi tietoa? Valitse sopivin vaihtoehto vastakohtaparien välillä.").get(0)));
			oRepo.save(new Option("helppous3", qRepo.findByQuestionName("Kuinka helposti olet löytänyt etsimääsi tietoa? Valitse sopivin vaihtoehto vastakohtaparien välillä.").get(0)));
			oRepo.save(new Option("helppous4", qRepo.findByQuestionName("Kuinka helposti olet löytänyt etsimääsi tietoa? Valitse sopivin vaihtoehto vastakohtaparien välillä.").get(0)));
			oRepo.save(new Option("helppous5", qRepo.findByQuestionName("Kuinka helposti olet löytänyt etsimääsi tietoa? Valitse sopivin vaihtoehto vastakohtaparien välillä.").get(0)));
			
			// Kuudes Kysymys
			qRepo.save(new Question("Avoin palaute kansainvälisyyspalveluista ja tiedon saatavuudesta MyNetissä", false,
					sRepo.findBySurveyName("Käyttäjäkysely Haaga-Helian kansainvälisyyspalveluista").get(0),
					tRepo.findByTypeName("text").get(0)));
			
			
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("aitog", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN");
		userrepository.save(user1);
		userrepository.save(user2);
		};
		
		
		

	};

}
