package core.data;

import core.domain.RatesResponseDTO;

public interface CurrenciesRepository {

    RatesResponseDTO getCurrencies();
    void saveCurrencies(RatesResponseDTO ratesResponseDTO);
    RatesResponseDTO getCachedCurrencies();
}
