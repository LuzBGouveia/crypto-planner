package br.com.fiap.cryptoplanner.planner;

import br.com.fiap.cryptoplanner.crypto.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannerService {
    private final CryptoService cryptoService;

    public String getPlannerFromActivity(String activityLabel){
        Activity activity = Activity.fromLabel(activityLabel);

        var crypto = cryptoService.getCrypto(activity.getCryptoId());
        double variation = crypto.marketData().changePercentage();

        return switch (activity){
            case COMPRAR_BITCOIN -> shouldBitcoin(variation);
            case VENDER_ETHEREUM -> shouldEthereum(variation);
            case INVESTIR_DOGECOIN -> shouldDogecoin(variation);
            default -> "Atividade não reconhecida";
        };
    }

    private String shouldBitcoin(Double variation) {
        if(variation > 5){
            return "Não recomendo comprar";
        }
        if(variation < 5){
            return "Recomendo comprar";
        }
        return "Preço estável";
    }

    private String shouldEthereum(Double variation) {
        if (variation > 5){
            return "Recomendo vender.";
        }
        if(variation < 5){
            return "Não recomendo vender.";
        }
        return "Preço estável.";
    }

    private String shouldDogecoin(Double variation) {
        if (variation > 10) {
            return "Cuidado! Alta volatilidade.";
        } else {
            return "Volatilidade normal, mas risco alto.";
        }
    }
}
