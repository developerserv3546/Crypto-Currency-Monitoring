package com.developer35.serega.cryptocurrencymonitoring.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.developer35.serega.cryptocurrencymonitoring.R;

public class UserPreferences {

    private static String currency;
    private static final String KEY_CURRENCY = "key currency";
    private static final int POSITION_USD = 0;
    private static final int POSITION_EUR = 1;
    private static final int POSITION_GBP = 2;

    public static void initPreferences(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        currency = preferences.getString(KEY_CURRENCY, context.getString(R.string.usd));
    }

    public static int getCurrencyPositionInSpinner(Context context) {
        if (currency.equals(context.getString(R.string.eur))) {
            return POSITION_EUR;
        } else if (currency.equals(context.getString(R.string.gbp))) {
            return POSITION_GBP;
        } else {
            return POSITION_USD;
        }
    }

    public static void setCurrency(Context context, String currency) {
        UserPreferences.currency = currency;
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(KEY_CURRENCY, currency)
                .apply();
    }

    public static String getCurrency() {
        return currency;
    }
}
