package com.developer35.serega.cryptocurrencymonitoring.utils;


import com.developer35.serega.cryptocurrencymonitoring.CryptoCoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUtil {

    public static void sortByRank(ArrayList<CryptoCoin> coins) {
        Collections.sort(coins, new Comparator<CryptoCoin>() {
            @Override
            public int compare(CryptoCoin coin1, CryptoCoin coin2) {
                return Integer.compare(coin1.getRank(), coin2.getRank());
            }
        });
    }

    public static void sortByName(ArrayList<CryptoCoin> coins) {
        Collections.sort(coins, new Comparator<CryptoCoin>() {
            @Override
            public int compare(CryptoCoin coin1, CryptoCoin coin2) {
                return coin1.getName().compareToIgnoreCase(coin2.getName());
            }
        });
    }

    public static void sortByPrice(ArrayList<CryptoCoin> coins) {
        Collections.sort(coins, new Comparator<CryptoCoin>() {
            @Override
            public int compare(CryptoCoin coin1, CryptoCoin coin2) {
                return Double.compare(coin2.getPriceUsd(), coin1.getPriceUsd());
            }
        });
    }
}
