package presentation;

import core.data.CurrenciesRepositoryImpl;
import core.domain.RatesResponseDTO;
import core.network.CurrenciesRemoteDataSource;
import core.network.CurrenciesRemoteService;
import core.network.NetworkCallbacks;
import core.usecases.ExchangeUseCase;
import core.usecases.GetCurrenciesUseCase;
import core.usecases.UseCase;

import java.util.Scanner;

public class Launcher{

    public static void main(String[] args) {

        CurrenciesRemoteDataSource remoteDataSource = new CurrenciesRemoteDataSource(CurrenciesRemoteService.getService());

        final NetworkCallbacks<RatesResponseDTO> networkCallbacks = new NetworkCallbacks<RatesResponseDTO>() {
            @Override
            public void onSuccess(RatesResponseDTO obj) {
                handleResponse(obj);
            }

            @Override
            public void onError(String msg) {
                System.out.println(msg);
            }
        };

        CurrenciesRepositoryImpl currenciesRepository = new CurrenciesRepositoryImpl(remoteDataSource, networkCallbacks);

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
