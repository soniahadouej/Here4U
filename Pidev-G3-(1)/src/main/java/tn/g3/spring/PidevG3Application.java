package tn.g3.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan("tn.g3.spring.service.IContractService")
public class PidevG3Application {

	public static void main(String[] args) {
		SpringApplication.run(PidevG3Application.class, args);
	}

}
