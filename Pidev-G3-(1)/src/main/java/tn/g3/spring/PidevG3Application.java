package tn.g3.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import tn.g3.spring.PidevG3Application;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		PidevG3Application.class,
        Jsr310JpaConverters.class
})
public class PidevG3Application {

	public static void main(String[] args) {
		SpringApplication.run(PidevG3Application.class, args);
	}

}
