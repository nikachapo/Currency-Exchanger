package core.network;

import core.domain.RatesResponseDTO;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface CurrenciesRemoteService {

    @GET(EndPoints.LATEST)
    Call<RatesResponseDTO> getCurrencies();

    static CurrenciesRemoteService getService() {
        if (EndPoints.INSTANCE != null) return EndPoints.INSTANCE;
        else synchronized (CurrenciesRemoteService.class) {
            EndPoints.INSTANCE = new Retrofit.Builder()
                    .baseUrl(EndPoints.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CurrenciesRemoteService.class);
        }
        return EndPoints.INSTANCE;
    }

    class EndPoints {
        public static CurrenciesRemoteService INSTANCE = null;
        public static final String BASE_URL = "https://api.exchangeratesapi.io/";
        public static final String LATEST = "latest";
    }
}
