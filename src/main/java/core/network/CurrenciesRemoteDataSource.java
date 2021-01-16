package core.network;

import core.data.CurrenciesDataSource;
import core.domain.RatesResponseDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrenciesRemoteDataSource implements CurrenciesDataSource {

    private final CurrenciesRemoteService currenciesRemoteService;

    public CurrenciesRemoteDataSource(CurrenciesRemoteService currenciesRemoteService) {
        this.currenciesRemoteService = currenciesRemoteService;
    }

    public CurrenciesRemoteService getCurrenciesRemoteService() {
        return currenciesRemoteService;
    }

    @Override
    public void getRatesDTO(NetworkCallbacks<RatesResponseDTO> networkCallbacks) {
        currenciesRemoteService.getCurrencies().enqueue(new Callback<RatesResponseDTO>() {
            @Override
            public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
                if (response.isSuccessful()) {
                    networkCallbacks.onSuccess(response.body());
                } else {
                    networkCallbacks.onError("Something goes wrong!!!");
                }
            }

            @Override
            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
                networkCallbacks.onError(t.getMessage());
            }
        });
    }
}
