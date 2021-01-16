package core.data;

import core.domain.RatesResponse;
import core.domain.RatesResponseDTO;
import core.network.CurrenciesRemoteDataSource;

public class CurrenciesRepositoryImpl implements CurrenciesRepository {

    private final CurrenciesRemoteDataSource remoteDataSource;

    public CurrenciesRepositoryImpl(CurrenciesRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public RatesResponseDTO getCurrencies() {
        RatesResponseDTO ratesDTO = remoteDataSource.getRatesDTO();
        new Thread(() -> {
            saveCurrencies(ratesDTO);
        });
        return ratesDTO;
    }

    @Override
    public void saveCurrencies(RatesResponseDTO ratesResponseDTO) {

    }

    @Override
    public RatesResponseDTO getCachedCurrencies() {
        return null;
    }
}
