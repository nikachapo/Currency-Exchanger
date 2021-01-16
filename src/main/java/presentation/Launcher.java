package presentation;

import core.data.CurrenciesRepositoryImpl;
import core.domain.RatesResponseDTO;
import core.network.CurrenciesRemoteDataSource;
import core.network.CurrenciesRemoteService;
import core.usecases.GetCurrenciesUseCase;
import core.usecases.UseCase;

public class Launcher {

    public static void main(String[] args) {

        UseCase<RatesResponseDTO> getCurrencies = new GetCurrenciesUseCase(
                new CurrenciesRepositoryImpl(
                        new CurrenciesRemoteDataSource(
                                CurrenciesRemoteService.getService())));

        System.out.println(getCurrencies.invoke().getRates().toString());

    }

}
