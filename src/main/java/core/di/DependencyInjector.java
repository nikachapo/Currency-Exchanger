package core.di;

import core.data.CurrenciesDataSource;
import core.data.CurrenciesRepository;
import core.data.CurrenciesRepositoryImpl;
import core.domain.RatesResponseDTO;
import core.local.CurrenciesDAO;
import core.local.CurrenciesDaoImpl;
import core.local.CurrenciesLocalDataSource;
import core.network.CurrenciesRemoteDataSource;
import core.network.CurrenciesRemoteService;
import core.network.FetchCallbacks;

import java.sql.SQLException;

public class DependencyInjector {

    public static CurrenciesDataSource remoteDataSource;

    public static CurrenciesDAO currenciesDAO;
    public static CurrenciesDataSource localDataSource;

    public DependencyInjector() throws SQLException {
        currenciesDAO = new CurrenciesDaoImpl();
        localDataSource = new CurrenciesLocalDataSource(currenciesDAO);
        remoteDataSource = new CurrenciesRemoteDataSource(CurrenciesRemoteService.getService());
    }

    public CurrenciesRepository getCurrenciesRepository(FetchCallbacks<RatesResponseDTO> fetchCallbacks) {
        return new CurrenciesRepositoryImpl(remoteDataSource, localDataSource, fetchCallbacks);
    }

}
