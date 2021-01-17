package core.local;

import core.domain.CurrencyEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrenciesDaoImpl implements CurrenciesDAO{

    private final Connection connection;

    public CurrenciesDaoImpl(Connection connection) throws SQLException {
        this.connection = connection;
        Driver driver = new org.h2.Driver();
        DriverManager.registerDriver(driver);
    }

    public CurrenciesDaoImpl() throws SQLException {
        this(DriverManager.getConnection("jdbc:h2:~/test", "sa", ""));
    }

    @Override
    public void insertCurrencies(List<CurrencyEntity> currencies) throws SQLException {
        for (CurrencyEntity currency: currencies) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO currency VALUES (?,?)");
            preparedStatement.setString(1, currency.getName());
            preparedStatement.setDouble(2, currency.getRate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }

    @Override
    public List<CurrencyEntity> getCurrencies() throws SQLException {
        List<CurrencyEntity> currencies = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM currency");
        while (resultSet.next()) {
            String name = resultSet.getString(COLUMN_NAME);
            double rate = resultSet.getDouble(COLUMN_RATE);
            CurrencyEntity currencyEntity = new CurrencyEntity(name, rate);
            currencies.add(currencyEntity);
        }
        return currencies;
    }
}
