package core.data;

import com.sun.istack.internal.Nullable;
import core.domain.RatesResponseDTO;

public interface CurrenciesDataSource {

    @Nullable
    RatesResponseDTO getRatesDTO();
}
