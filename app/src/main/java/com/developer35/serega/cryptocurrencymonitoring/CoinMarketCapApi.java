package com.developer35.serega.cryptocurrencymonitoring;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinMarketCapApi {

    @GET("v1/ticker/?limit=100")
    Call<ArrayList<CryptoCoin>> getCoinList(@Query("convert") String currency);
}
