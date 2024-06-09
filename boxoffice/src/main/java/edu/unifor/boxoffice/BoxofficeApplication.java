package edu.unifor.boxoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.unifor.unicine.core")
public class BoxofficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoxofficeApplication.class, args);
    }

}
