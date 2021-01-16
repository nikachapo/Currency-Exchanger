package core.data;

import core.domain.RatesResponseDTO;
import core.network.CurrenciesRemoteDataSource;
import core.network.NetworkCallbacks;

public class CurrenciesRepositoryImpl implements CurrenciesRepository, NetworkCallbacks<RatesResponseDTO> {

    private final CurrenciesRemoteDataSource remoteDataSource;

    private final NetworkCallbacks<RatesResponseDTO> networkCallbacks;

    public CurrenciesRepositoryImpl(CurrenciesRemoteDataSource remoteDataSource,
                                    NetworkCallbacks<RatesResponseDTO> networkCallbacks) {
        this.remoteDataSource = remoteDataSource;
        this.networkCallbacks = networkCallbacks;
    }

    @Override
    public void getCurrencies() {
        remoteDataSource.getRatesDTO(this);
    }

    @Override
    public void saveCurrencies(RatesResponseDTO ratesResponseDTO) {

    }

    @Override
    public RatesResponseDTO getCachedCurrencies() {
        return null;
    }

    @Override
    public void onSuccess(RatesResponseDTO obj) {
        new Thread(() -> saveCurrencies(obj));
        networkCallbacks.onSuccess(obj);
    }

    @Override
    public void onError(String msg) {
        networkCallbacks.onError(msg);
    }
}
