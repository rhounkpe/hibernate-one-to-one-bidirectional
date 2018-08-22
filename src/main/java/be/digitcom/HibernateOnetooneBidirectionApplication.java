package be.digitcom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.digitcom.model.Phone;
import be.digitcom.model.PhoneDetails;
import be.digitcom.repository.IPhoneDetailsRepository;
import be.digitcom.repository.IPhoneRepository;

@SpringBootApplication
public class HibernateOnetooneBidirectionApplication {
	
	@Autowired
	private IPhoneRepository phoneRepository;
	
	@Autowired
	private IPhoneDetailsRepository detailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateOnetooneBidirectionApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		Phone phone = new Phone( "123-456-7890" );
		PhoneDetails details = new PhoneDetails( "T-Mobile", "GSM" );
		phone.addDetails( details );
		return args -> {
			phoneRepository.save(phone);
			detailsRepository.save(details);
		};
	}
}
