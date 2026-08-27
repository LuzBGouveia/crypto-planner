package br.com.fiap.cryptoplanner.planner;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

public enum Activity {
    COMPRAR_BITCOIN("Comprar Bitcoin", "bitcoin"),
    VENDER_ETHEREUM("Vender Ethereum", "ethereum"),
    INVESTIR_DOGECOIN("Investir em Dogecoin", "dogecoin");

    private final String label;
    private final String cryptoId;

    Activity(String label, String cryptoId) {
        this.label = label;
        this.cryptoId = cryptoId;
    }

    public String getCryptoId() {
        return cryptoId;
    }

    public static Activity fromLabel(String label) {
        return Arrays.stream(values())
                .filter(a -> a.label.equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Atividade desconhecida: " + label));
    }
}
