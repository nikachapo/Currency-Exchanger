package core.data;

import core.domain.RatesResponseDTO;
import core.network.NetworkCallbacks;

public interface CurrenciesDataSource {

    void getRatesDTO(NetworkCallbacks<RatesResponseDTO> networkCallbacks);
}
