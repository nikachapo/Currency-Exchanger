package core.domain;

import com.google.gson.annotations.SerializedName;

public class RatesResponseDTO {
    @SerializedName("base")
    private String base;
    @SerializedName("rates")
    private RatesResponse rates;

    public RatesResponse getRates() {
        return rates;
    }

    public String getBase() {
        return base;
    }

    @Override
    public String toString() {
        return "RatesResponseDTO{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
