package core.network;

import core.data.CurrenciesDataSource;
import core.domain.RatesResponseDTO;

public class CurrenciesRemoteDataSource implements CurrenciesDataSource {

    private final CurrenciesRemoteService currenciesRemoteService;

    public CurrenciesRemoteDataSource(CurrenciesRemoteService currenciesRemoteService) {
        this.currenciesRemoteService = currenciesRemoteService;
    }

    public CurrenciesRemoteService getCurrenciesRemoteService() {
        return currenciesRemoteService;
    }

    @Override
    public RatesResponseDTO getRatesDTO() {
        return currenciesRemoteService.getCurrencies();
    }
}
