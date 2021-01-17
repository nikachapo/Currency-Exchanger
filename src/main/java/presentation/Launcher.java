package presentation;

import core.data.CurrenciesDataSource;
import core.data.CurrenciesRepositoryImpl;
import core.domain.RatesResponseDTO;
import core.local.CurrenciesDAO;
import core.local.CurrenciesDaoImpl;
import core.local.CurrenciesLocalDataSource;
import core.network.CurrenciesRemoteDataSource;
import core.network.CurrenciesRemoteService;
import core.network.FetchCallbacks;
import core.usecases.ExchangeUseCase;
import core.usecases.GetCurrenciesUseCase;
import core.usecases.UseCase;

import java.sql.SQLException;
import java.util.Scanner;

public class Launcher {

    private static CurrenciesRepositoryImpl currenciesRepository;

    public static void main(String[] args) throws SQLException {

        CurrenciesDataSource remoteDataSource = new CurrenciesRemoteDataSource(CurrenciesRemoteService.getService());

        final FetchCallbacks<RatesResponseDTO> fetchCallbacks = new FetchCallbacks<RatesResponseDTO>() {
            @Override
            public void onSuccess(RatesResponseDTO obj) {
                handleResponse(obj);
            }

            @Override
            public void onError(String msg) {
                currenciesRepository.getCachedCurrencies();
                System.out.println(msg);
            }
        };

        CurrenciesDAO currenciesDAO = new CurrenciesDaoImpl();

        CurrenciesDataSource localDataSource = new CurrenciesLocalDataSource(currenciesDAO);

        currenciesRepository = new CurrenciesRepositoryImpl(remoteDataSource, localDataSource, fetchCallbacks);

        UseCase<RatesResponseDTO> getCurrencies = new GetCurrenciesUseCase(currenciesRepository);

        getCurrencies.invoke();

    }

    private static void handleResponse(RatesResponseDTO obj) {
        System.out.println(obj.toString());

        System.out.println("Enter amount:");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        System.out.println(new ExchangeUseCase(obj.getRates().getUsd(),
                obj.getRates().getGbp(), amount).invokeAndReturn());
    }

}
