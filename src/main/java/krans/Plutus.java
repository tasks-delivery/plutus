package fap.logger.fap;

import krans.freebitco.Freebitco;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Plutus {

	public static void main(String[] args) {
        SpringApplication.run(fap.logger.fap.Plutus.class, args);
        Freebitco freebitco = new Freebitco();
        freebitco.runner();
    }

}


