package com.developer35.serega.cryptocurrencymonitoring.utils;


import android.content.Context;

import com.developer35.serega.cryptocurrencymonitoring.CryptoCoin;
import com.developer35.serega.cryptocurrencymonitoring.R;

public class CoinUtil {

    private static final String SPACE = " ";

    public static String getNameWithSymbol(CryptoCoin coin) {
        return coin.getName() + " (" + coin.getSymbol() + ")";
    }

    public static String getPriceInCurrentCurrency(CryptoCoin coin, Context context) {
        String currency = UserPreferences.getCurrency();
        if (currency.equals(context.getString(R.string.eur))) {
            currency = coin.getPriceEur() + SPACE + currency;
        } else if (currency.equals(context.getString(R.string.gbp))) {
            currency = coin.getPriceGbp() + SPACE + currency;
        } else {
            currency = coin.getPriceUsd() + SPACE + currency;
        }
        return currency;
    }
}
