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

    @Override
    public void getRatesDTO(FetchCallbacks<RatesResponseDTO> fetchCallbacks) {
        currenciesRemoteService.getCurrencies().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<RatesResponseDTO> call, Response<RatesResponseDTO> response) {
                if (response.isSuccessful()) {
                    fetchCallbacks.onSuccess(response.body());
                } else {
                    fetchCallbacks.onError("Something goes wrong!!!");
                }
            }

            @Override
            public void onFailure(Call<RatesResponseDTO> call, Throwable t) {
                fetchCallbacks.onError(t.getMessage());
            }
        });
    }
}
