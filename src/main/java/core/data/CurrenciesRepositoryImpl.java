package core.data;

import core.domain.RatesResponseDTO;
import core.network.FetchCallbacks;

public class CurrenciesRepositoryImpl implements CurrenciesRepository, FetchCallbacks<RatesResponseDTO> {

    private final CurrenciesDataSource remoteDataSource;

    private final CurrenciesDataSource localDataSource;

    private final FetchCallbacks<RatesResponseDTO> fetchCallbacks;

    public CurrenciesRepositoryImpl(CurrenciesDataSource remoteDataSource,
                                    CurrenciesDataSource localDataSource,
                                    FetchCallbacks<RatesResponseDTO> fetchCallbacks) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.fetchCallbacks = fetchCallbacks;
    }

    @Override
    public void getCurrencies() {
        remoteDataSource.getRatesDTO(this);
    }

    @Override
    public void saveCurrencies(RatesResponseDTO ratesResponseDTO) {
        localDataSource.saveRates(ratesResponseDTO);
    }

    @Override
    public void getCachedCurrencies() {
        localDataSource.getRatesDTO(fetchCallbacks);
    }

    @Override
    public void onSuccess(RatesResponseDTO obj) {
        new Thread(() -> saveCurrencies(obj));
        fetchCallbacks.onSuccess(obj);
    }

    @Override
    public void onError(String msg) {
        fetchCallbacks.onError(msg);
    }
}
