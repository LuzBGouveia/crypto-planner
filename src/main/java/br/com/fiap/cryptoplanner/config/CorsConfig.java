package br.com.fiap.cryptoplanner.config;

import br.com.fiap.cryptoplanner.crypto.CryptoCli;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class CorsConfig {
    @Bean
    @Primary
    public CryptoCli cryptoClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://api.coingecko.com")
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(CryptoCli.class);
    }
}
