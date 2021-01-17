package core.local;

import core.common.RemoteToLocalMapper;
import core.data.CurrenciesDataSource;
import core.domain.RatesResponse;
import core.domain.RatesResponseDTO;
import core.network.FetchCallbacks;

import java.sql.SQLException;

public class CurrenciesLocalDataSource implements CurrenciesDataSource {

    private final CurrenciesDAO currenciesDAO;

    private final RemoteToLocalMapper mapper = new RemoteToLocalMapper();

    public CurrenciesLocalDataSource(CurrenciesDAO currenciesDAO) {
        this.currenciesDAO = currenciesDAO;
    }

    @Override
    public void getRatesDTO(FetchCallbacks<RatesResponseDTO> fetchCallbacks) {
        try {
            RatesResponseDTO ratesResponseDTO = new RatesResponseDTO();
            ratesResponseDTO.setRates(mapper.mapTo(currenciesDAO.getCurrencies()));
            ratesResponseDTO.setBase(RatesResponse.EUR);
            fetchCallbacks.onSuccess(ratesResponseDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            fetchCallbacks.onError(throwables.getMessage());
        }
    }

    @Override
    public void saveRates(RatesResponseDTO ratesResponseDTO) {
        try {
            currenciesDAO.insertCurrencies(mapper.mapFrom(ratesResponseDTO.getRates()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
