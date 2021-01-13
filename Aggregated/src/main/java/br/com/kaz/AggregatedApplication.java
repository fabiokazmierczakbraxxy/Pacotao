package br.com.kaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AggregatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatedApplication.class, args);
		System.out.println("Entrou.......");
	}

}
