package core.data;

import core.domain.RatesResponseDTO;

public interface CurrenciesRepository {

    void getCurrencies();
    void saveCurrencies(RatesResponseDTO ratesResponseDTO);
    RatesResponseDTO getCachedCurrencies();
}
