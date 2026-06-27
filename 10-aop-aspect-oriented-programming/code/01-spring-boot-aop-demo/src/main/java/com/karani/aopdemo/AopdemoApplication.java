package com.karani.aopdemo;

import com.karani.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

    @Bean // spring boot will automatically inject the AccountDAO dependency because of the @Bean annotation
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
        return runner -> {
            demoTheBeforeAdvice(theAccountDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
        // call the business method
        theAccountDAO.addAccount();

        // do it again
        System.out.println("\nlet's call it again!\n");
        theAccountDAO.addAccount();
    }

}
