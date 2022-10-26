package ma.esi.etudiant;

import ma.esi.etudiant.entites.Etudiant;
import ma.esi.etudiant.entites.Genre;
import ma.esi.etudiant.security.service.ServiceSecurity;
import ma.esi.etudiant.service.ServiceEtudiant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ServiceEtudiant service, ServiceSecurity serviceSeurity){
		return args -> {
			for (int i = 0; i < 20; i++) {
				service.saveEtudiant(new Etudiant(null, "DOUNI", "Hamza", "hamza.douni@gmail.com", new Date(), Genre.MASCULIN, false));
				service.saveEtudiant(new Etudiant(null, "Benzahra", "Amine", "amine.benzahra@gmail.com", new Date(), Genre.MASCULIN, true));
					service.saveEtudiant(new Etudiant(null, "SOURITEBBAL", "Fatima zahra", "fatmazahra.souritebbal@gmail.com", new Date(), Genre.FEMININ, true));
				service.saveEtudiant(new Etudiant(null, "LAKHLANI ", "Doha", "doha.lakhlani@gmail.com", new Date(), Genre.FEMININ, false));
				service.saveEtudiant(new Etudiant(null, "ZBIR ", "Oussama", "oussama.zbir@gmail.com", new Date(), Genre.MASCULIN, true));
			}

			serviceSeurity.saveNewUser("hamza", "123", "123");
			serviceSeurity.saveNewUser("amine", "123", "123");
			serviceSeurity.saveNewUser("fatimazahra", "123", "123");
			serviceSeurity.saveNewUser("doha", "123", "123");
			serviceSeurity.saveNewUser("oussama", "123", "123");


			serviceSeurity.saveNewRole("USER", "");
			serviceSeurity.saveNewRole("ADMIN", "");

			serviceSeurity.addRoleToUser("amine", "USER");
			serviceSeurity.addRoleToUser("hamza", "ADMIN");
			serviceSeurity.addRoleToUser("hamza", "USER");

			serviceSeurity.addRoleToUser("fatimazahra", "ADMIN");
			serviceSeurity.addRoleToUser("oussama", "USER");
			serviceSeurity.addRoleToUser("doha", "USER");
		};
	}

}
