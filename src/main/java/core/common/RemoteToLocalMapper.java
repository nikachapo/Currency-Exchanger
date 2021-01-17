package core.common;

import core.domain.CurrencyEntity;
import core.domain.RatesResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocalMapper implements Mapper<RatesResponse, List<CurrencyEntity>> {

    @Override
    public List<CurrencyEntity> mapFrom(RatesResponse obj) {
        List<CurrencyEntity> currencyEntities = new ArrayList<>();
        currencyEntities.add(new CurrencyEntity(RatesResponse.CAD, obj.getCad()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.HKD, obj.getHkd()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.ISK, obj.getIsk()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.PHP, obj.getPhp()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.DKK, obj.getDkk()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.HUF, obj.getHuf()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.CZK, obj.getCzk()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.AUD, obj.getAud()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.INR, obj.getInr()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.RUB, obj.getRub()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.JPY, obj.getJpy()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.CNY, obj.getCny()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.USD, obj.getUsd()));
        currencyEntities.add(new CurrencyEntity(RatesResponse.GBP, obj.getGbp()));
        return currencyEntities;
    }

    @Override
    public RatesResponse mapTo(List<CurrencyEntity> obj) {
        RatesResponse ratesResponse = new RatesResponse();
        for (CurrencyEntity currency: obj) {
            switch (currency.getName()) {
                case RatesResponse.CAD:
                    ratesResponse.setCad(currency.getRate());
                    break;
                case RatesResponse.HKD:
                    ratesResponse.setHkd(currency.getRate());
                    break;
                case RatesResponse.ISK:
                    ratesResponse.setIsk(currency.getRate());
                    break;
                case RatesResponse.PHP:
                    ratesResponse.setPhp(currency.getRate());
                    break;
                case RatesResponse.DKK:
                    ratesResponse.setDkk(currency.getRate());
                    break;
                case RatesResponse.HUF:
                    ratesResponse.setHuf(currency.getRate());
                    break;
                case RatesResponse.CZK:
                    ratesResponse.setCzk(currency.getRate());
                    break;
                case RatesResponse.AUD:
                    ratesResponse.setAud(currency.getRate());
                    break;
                case RatesResponse.INR:
                    ratesResponse.setInr(currency.getRate());
                    break;
                case RatesResponse.RUB:
                    ratesResponse.setRub(currency.getRate());
                    break;
                case RatesResponse.JPY:
                    ratesResponse.setJpy(currency.getRate());
                    break;
                case RatesResponse.CNY:
                    ratesResponse.setCny(currency.getRate());
                    break;
                case RatesResponse.USD:
                    ratesResponse.setUsd(currency.getRate());
                    break;
                case RatesResponse.GBP:
                    ratesResponse.setGbp(currency.getRate());
                    break;
            }
        }
        return ratesResponse;
    }
}
