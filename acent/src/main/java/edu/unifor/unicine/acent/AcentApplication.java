package edu.unifor.unicine.acent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.unifor.unicine.core")
public class AcentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcentApplication.class, args);
	}

}
