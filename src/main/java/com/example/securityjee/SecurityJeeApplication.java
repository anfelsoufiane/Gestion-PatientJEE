package com.example.securityjee;

import com.example.securityjee.entities.Patient;
import com.example.securityjee.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SecurityJeeApplication {

  public static void main(String[] args) {
        SpringApplication.run(SecurityJeeApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Soufiane", new Date(), false, 112));
            patientRepository.save(new Patient(null, "Hatim", new Date(), true, 120));
            patientRepository.save(new Patient(null, "Haitem", new Date(), false, 510));
            patientRepository.save(new Patient(null, "ikram", new Date(), false, 190));
            patientRepository.findAll().forEach(
                    p -> {
                        System.out.println(p.getNom());
                    }
            );

        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
