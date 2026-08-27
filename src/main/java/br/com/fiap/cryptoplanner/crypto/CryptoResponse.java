package br.com.fiap.cryptoplanner.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CryptoResponse(
        String name,
        @JsonProperty("market_data")
        MarketData marketData
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MarketData(
        @JsonProperty("current_price") Double currentPrice,
        @JsonProperty("price_change_percentage_24h") Double changePercentage
    ) {}
}
