package core.usecases;

import core.data.CurrenciesRepository;
import core.domain.RatesResponseDTO;

public class GetCurrenciesUseCase implements UseCase<RatesResponseDTO> {

    private final CurrenciesRepository currenciesRepository;

    public GetCurrenciesUseCase(CurrenciesRepository currenciesRepository) {
        this.currenciesRepository = currenciesRepository;
    }

    @Override
    public void invoke() {
        currenciesRepository.getCurrencies();
    }
}
