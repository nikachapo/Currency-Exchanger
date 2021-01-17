import core.common.RemoteToLocalMapper;
import core.data.CurrenciesDataSource;
import core.data.CurrenciesRepository;
import core.data.CurrenciesRepositoryImpl;
import core.di.DependencyInjector;
import core.domain.CurrencyEntity;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPresenter {

    private final HashMap<String, Double> ratesMap = new HashMap<>();
    private CurrenciesRepository currenciesRepository;
    private final Listeners listeners;
    private final NumberFormat formatter;

    private DependencyInjector dependencyInjector;

    public MainPresenter(Listeners listeners) {
        this.listeners = listeners;
        formatter = new DecimalFormat("#0.00");
        try {
            dependencyInjector = new DependencyInjector();
            initialize();
        } catch (SQLException e) {
            e.printStackTrace();
            listeners.showMessage(e.getMessage());
        }
    }

    private void initialize() {
        currenciesRepository = dependencyInjector.getCurrenciesRepository(fetchCallbacks);
        UseCase<RatesResponseDTO> getCurrencies = new GetCurrenciesUseCase(currenciesRepository);
        getCurrencies.invoke();
    }

    private void handleResponse(RatesResponseDTO obj) {
        List<String> names = new ArrayList<>();
        List<CurrencyEntity> currencies = new RemoteToLocalMapper().mapFrom(obj.getRates());
        currencies.forEach((currencyEntity) -> {
            ratesMap.put(currencyEntity.getName(), currencyEntity.getRate());
            names.add(currencyEntity.getName());
        });
        listeners.onCurrenciesReceived(names);
    }

    public void calculate(String from, String to, String amount) {
        if (from == null || to == null) {
            listeners.showMessage("Choose both currencies");
        } else {
            if (amount.isEmpty()) {
                listeners.showMessage("Enter Amount");
            } else {
                double result = new ExchangeUseCase(ratesMap.get(from), ratesMap.get(to), Double.valueOf(amount))
                        .invokeAndReturn();
                listeners.resultReceived(formatter.format(result));
            }
        }
    }

    private final FetchCallbacks<RatesResponseDTO> fetchCallbacks = new FetchCallbacks<>() {
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

    public interface Listeners {
        void onCurrenciesReceived(List<String> currencyNames);
        void showMessage(String text);
        void resultReceived(String resultToDisplay);
    }
}
