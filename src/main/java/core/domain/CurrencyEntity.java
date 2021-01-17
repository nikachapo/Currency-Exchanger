package core.domain;

public class CurrencyEntity {

    private final String name;
    private final double rate;

    public CurrencyEntity(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
