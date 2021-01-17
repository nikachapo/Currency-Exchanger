package core.local;

import core.domain.CurrencyEntity;

import java.sql.SQLException;
import java.util.List;

public interface CurrenciesDAO {

    String COLUMN_NAME = "name";
    String COLUMN_RATE = "rate";

    void insertCurrencies(List<CurrencyEntity> currencies) throws SQLException;
    List<CurrencyEntity> getCurrencies() throws SQLException;

}
