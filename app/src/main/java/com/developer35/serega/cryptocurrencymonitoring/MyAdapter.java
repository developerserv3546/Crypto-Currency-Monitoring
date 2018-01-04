package com.developer35.serega.cryptocurrencymonitoring;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer35.serega.cryptocurrencymonitoring.utils.UiHelper;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final ArrayList<CryptoCoin> coins;

    public MyAdapter(ArrayList<CryptoCoin> coins) {
        this.coins = coins;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        final CryptoCoin coin = coins.get(position);
        UiHelper.setNameWithSymbol(coin, holder.nameView);
        UiHelper.setPriceInCurrentCurrency(coin, holder.priceView);
        UiHelper.setPercentChangeFor1h(coin, holder.changeIn1hView);
        UiHelper.setPercentChangeFor24h(coin, holder.changeIn24hView);
        UiHelper.setPercentChangeFor7d(coin, holder.changeIn7dView);
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameView;
        private final TextView priceView;
        private final TextView changeIn1hView;
        private final TextView changeIn24hView;
        private final TextView changeIn7dView;

        ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.txt_coin_name);
            priceView = itemView.findViewById(R.id.txt_coin_price);
            changeIn1hView = itemView.findViewById(R.id.txt_change_in_1h);
            changeIn24hView = itemView.findViewById(R.id.txt_change_in_24h);
            changeIn7dView = itemView.findViewById(R.id.txt_change_in_7d);
        }
    }
}
