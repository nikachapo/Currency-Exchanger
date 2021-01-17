package core.usecases;

public class ExchangeUseCase implements UseCase<Double> {

    private final Double exchangeFromRate;
    private final Double exchangeToRate;
    private final Double amount;

    public ExchangeUseCase(Double exchangeFromRate, Double exchangeToRate, Double amount) {
        this.exchangeFromRate = exchangeFromRate;
        this.exchangeToRate = exchangeToRate;
        this.amount = amount;
    }

    @Override
    public Double invokeAndReturn() {
        double toBase;
        if (exchangeFromRate < 1) {
            toBase = amount / exchangeFromRate;
        } else {
            toBase = amount * exchangeFromRate;
        }

        double result;
        if (exchangeToRate < 1) {
            result = toBase * exchangeToRate;
        } else {
            result = toBase / exchangeToRate;
        }
        return result;
    }
}
