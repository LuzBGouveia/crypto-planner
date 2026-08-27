package br.com.fiap.cryptoplanner.crypto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
        url = "/api/v3/coins/{id}",
        accept = "application/json"
)
public interface CryptoService {

    @GetExchange
    public CryptoResponse getCrypto(@PathVariable String id);
}
