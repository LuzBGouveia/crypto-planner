package br.com.fiap.cryptoplanner;

import br.com.fiap.cryptoplanner.crypto.CryptoCli;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(CryptoCli.class)
public class CryptoPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoPlannerApplication.class, args);
    }

}
