package com.developer35.serega.cryptocurrencymonitoring;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer35.serega.cryptocurrencymonitoring.utils.CoinUtil;

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
        String coinName = CoinUtil.getNameWithSymbol(coin);
        String coinPrice = CoinUtil.getPriceInCurrentCurrency(coin, holder.context);

        String changeIn1h = coin.getPercentChange1h() + "% (1h)";
        String changeIn24h = coin.getPercentChange24h() + "% (24h)";
        String changeIn7d = coin.getPercentChange7d() + "% (7d)";

        holder.nameView.setText(coinName);
        holder.priceView.setText(coinPrice);

        holder.changeIn1hView.setText(changeIn1h);

        if (changeIn1h.startsWith("-")) {
            holder.changeIn1hView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_down_red_24dp, 0, 0, 0);
        } else {
            holder.changeIn1hView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_up_green_24dp, 0, 0, 0);
        }

        holder.changeIn24hView.setText(changeIn24h);
        if (changeIn24h.startsWith("-")) {
            holder.changeIn24hView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_down_red_24dp, 0, 0, 0);
        } else {
            holder.changeIn24hView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_up_green_24dp, 0, 0, 0);
        }

        holder.changeIn7dView.setText(changeIn7d);

        if (changeIn7d.startsWith("-")) {
            holder.changeIn7dView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_down_red_24dp, 0, 0, 0);
        } else {
            holder.changeIn7dView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_drop_up_green_24dp, 0, 0, 0);
        }
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;
        private final TextView nameView;
        private final TextView priceView;
        private final TextView changeIn1hView;
        private final TextView changeIn24hView;
        private final TextView changeIn7dView;

        ViewHolder(View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            nameView = itemView.findViewById(R.id.txt_coin_name);
            priceView = itemView.findViewById(R.id.txt_coin_price);
            changeIn1hView = itemView.findViewById(R.id.txt_change_in_1h);
            changeIn24hView = itemView.findViewById(R.id.txt_change_in_24h);
            changeIn7dView = itemView.findViewById(R.id.txt_change_in_7d);
        }
    }
}
