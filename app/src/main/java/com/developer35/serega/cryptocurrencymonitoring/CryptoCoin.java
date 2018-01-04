package com.developer35.serega.cryptocurrencymonitoring;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoCoin {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("symbol")
    @Expose
    private String symbol;

    @SerializedName("rank")
    @Expose
    private Integer rank;

    @SerializedName("price_usd")
    @Expose
    private Double priceUsd;

    @SerializedName("24h_volume_usd")
    @Expose
    private String volumeUsd24h;

    @SerializedName("price_eur")
    @Expose
    private Double priceEur;

    @SerializedName("24h_volume_eur")
    @Expose
    private String volumeEur24h;

    @SerializedName("price_gbp")
    @Expose
    private Double priceGbp;

    @SerializedName("24h_volume_gbp")
    @Expose
    private String volumeGbp24h;

    @SerializedName("price_btc")
    @Expose
    private String priceBtc;

    @SerializedName("market_cap_usd")
    @Expose
    private String marketCapUsd;

    @SerializedName("available_supply")
    @Expose
    private String availableSupply;

    @SerializedName("total_supply")
    @Expose
    private String totalSupply;

    @SerializedName("max_supply")
    @Expose
    private String maxSupply;

    @SerializedName("percent_change_1h")
    @Expose
    private String percentChange1h;

    @SerializedName("percent_change_24h")
    @Expose
    private String percentChange24h;

    @SerializedName("percent_change_7d")
    @Expose
    private String percentChange7d;

    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public String getVolumeUsd24h() {
        return volumeUsd24h;
    }

    public Double getPriceEur() {
        return priceEur;
    }

    public String getVolumeEur24h() {
        return volumeEur24h;
    }

    public Double getPriceGbp() {
        return priceGbp;
    }

    public String getVolumeGbp24h() {
        return volumeGbp24h;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
