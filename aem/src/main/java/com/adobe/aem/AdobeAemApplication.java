package com.adobe.aem;

import com.adobe.aem.utilities.IRules;
import com.adobe.aem.utilities.Rules;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdobeAemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdobeAemApplication.class, args);
	}

	@Bean
	public Rules getRules(){return new IRules();}

}
