package com.developer35.serega.cryptocurrencymonitoring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.developer35.serega.cryptocurrencymonitoring.utils.SortUtil;
import com.developer35.serega.cryptocurrencymonitoring.utils.UserPreferences;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CoinMarketCapApi api;
    private ArrayList<CryptoCoin> coins;

    private enum SortType {
        RANK, NAME, PRICE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserPreferences.initPreferences(this);
        setContentView(R.layout.activity_main);
        setToolbar();

        Spinner currencySpinner = findViewById(R.id.spinner_currency);
        int position = UserPreferences.getCurrencyPositionInSpinner(this);
        currencySpinner.setSelection(position);
        currencySpinner.setOnItemSelectedListener(itemSelectedListener);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        api = Fabric.getApi();
        refreshCoinList();

    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private final AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String currency = (String) adapterView.getItemAtPosition(i);
            UserPreferences.setCurrency(MainActivity.this, currency);
            if (recyclerView.getAdapter() != null) {
                refreshCoinList();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private void refreshCoinList() {
        Call<ArrayList<CryptoCoin>> coinListCall = api.getCoinList(UserPreferences.getCurrency());
        coinListCall.enqueue(new Callback<ArrayList<CryptoCoin>>() {
            @Override
            public void onResponse(Call<ArrayList<CryptoCoin>> call, Response<ArrayList<CryptoCoin>> response) {
                if (response.isSuccessful()) {
                    ArrayList<CryptoCoin> coins = response.body();
                    if (coins != null) {
                        MainActivity.this.coins = coins;
                        recyclerView.setAdapter(new MyAdapter(coins));
                    } else {
                        showErrorMessage();
                    }
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CryptoCoin>> call, Throwable t) {
                showErrorMessage();
                t.printStackTrace();
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(this, getString(R.string.error_message),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_refresh:
                refreshCoinList();
                return true;
            case R.id.action_sort_by_rank:
                sortCoinList(SortType.RANK);
                return true;
            case R.id.action_sort_by_name:
                sortCoinList(SortType.NAME);
                return true;
            case R.id.action_sort_by_price:
                sortCoinList(SortType.PRICE);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sortCoinList(SortType type) {
        if (recyclerView.getAdapter() != null) {
            switch (type) {
                case RANK:
                    SortUtil.sortByRank(coins);
                    break;
                case NAME:
                    SortUtil.sortByName(coins);
                    break;
                case PRICE:
                    SortUtil.sortByPrice(coins);
                    break;
            }
            recyclerView.swapAdapter(new MyAdapter(coins), true);
        }
    }
}
