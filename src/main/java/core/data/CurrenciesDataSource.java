package core.data;

import core.domain.RatesResponseDTO;
import core.network.FetchCallbacks;

public interface CurrenciesDataSource {

    void getRatesDTO(FetchCallbacks<RatesResponseDTO> fetchCallbacks);

    default void saveRates(RatesResponseDTO ratesResponseDTO) {}
}
