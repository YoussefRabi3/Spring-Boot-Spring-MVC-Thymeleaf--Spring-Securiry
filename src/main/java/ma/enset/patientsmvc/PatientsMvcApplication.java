package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepositories;
import ma.enset.patientsmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepositories patientRepositories){
        return args ->{
          patientRepositories.save(
                  new Patient(null,"youssef",new Date(),false,122));
            patientRepositories.save(
                    new Patient(null,"mohammed",new Date(),true,321));
            patientRepositories.save(
                    new Patient(null,"yassine",new Date(),true,165));
            patientRepositories.save(
                    new Patient(null,"imane",new Date(),false,132));
            patientRepositories.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
   //@Bean
    CommandLineRunner saveUsers(SecurityService securityService)
   {
        return args -> {
            securityService.saveNewUser("Mohammed","1234","1234");
            securityService.saveNewUser("Yassmine","1234","1234");
            securityService.saveNewUser("Hassan","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("Mohammed","USER");
            securityService.addRoleToUser("Mohammed","ADMIN");
            securityService.addRoleToUser("Yassmine","USER");
            securityService.addRoleToUser("Hassan","USER");

        };
   }
}

