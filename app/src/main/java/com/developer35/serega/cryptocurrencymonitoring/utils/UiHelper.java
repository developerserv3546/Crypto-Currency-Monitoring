package com.developer35.serega.cryptocurrencymonitoring.utils;


import android.content.Context;
import android.widget.TextView;

import com.developer35.serega.cryptocurrencymonitoring.CryptoCoin;
import com.developer35.serega.cryptocurrencymonitoring.R;

public class UiHelper {

    private static final String SPACE = " ";
    private static final String MINUS = "-";
    private static final String PERCENT_1H = "% (1h)";
    private static final String PERCENT_24H = "% (24h)";
    private static final String PERCENT_7D = "% (7d)";

    public static void setNameWithSymbol(CryptoCoin coin, TextView view) {
        String value = coin.getName() + " (" + coin.getSymbol() + ")";
        view.setText(value);
    }

    public static void setPriceInCurrentCurrency(CryptoCoin coin, TextView view) {

        Context context = view.getContext();
        String currency = UserPreferences.getCurrency();

        if (currency.equals(context.getString(R.string.eur))) {
            currency = coin.getPriceEur() + SPACE + currency;
        } else if (currency.equals(context.getString(R.string.gbp))) {
            currency = coin.getPriceGbp() + SPACE + currency;
        } else {
            currency = coin.getPriceUsd() + SPACE + currency;
        }

        view.setText(currency);
    }

    public static void setPercentChangeFor1h(CryptoCoin coin, TextView view) {
        String value = coin.getPercentChange1h() + PERCENT_1H;
        setValuesForPercentChangeView(value, view);
    }

    public static void setPercentChangeFor24h(CryptoCoin coin, TextView view) {
        String value = coin.getPercentChange24h() + PERCENT_24H;
        setValuesForPercentChangeView(value, view);
    }

    public static void setPercentChangeFor7d(CryptoCoin coin, TextView view) {
        String value = coin.getPercentChange7d() + PERCENT_7D;
        setValuesForPercentChangeView(value, view);
    }

    private static void setValuesForPercentChangeView(String value, TextView view) {

        if (value.startsWith(MINUS)) {
            view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_down_red_24dp, 0, 0, 0);
        } else {
            view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_up_green_24dp, 0, 0, 0);
        }

        view.setText(value);
    }
}
