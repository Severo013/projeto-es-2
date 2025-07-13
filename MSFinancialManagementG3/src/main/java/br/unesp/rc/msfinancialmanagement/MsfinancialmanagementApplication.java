package br.unesp.rc.msfinancialmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MsfinancialmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsfinancialmanagementApplication.class, args);
	}

}
