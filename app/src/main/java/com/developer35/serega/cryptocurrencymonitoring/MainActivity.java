package com.developer35.serega.cryptocurrencymonitoring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CoinMarketCapApi api;
    private ArrayList<CryptoCoin> coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setToolbar();

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

    private void refreshCoinList(){
        Call<ArrayList<CryptoCoin>> coinListCall = api.getCoinList("USD");
        coinListCall.enqueue(new Callback<ArrayList<CryptoCoin>>() {
            @Override
            public void onResponse(Call<ArrayList<CryptoCoin>> call, Response<ArrayList<CryptoCoin>> response) {
                if (response.isSuccessful()) {
                    ArrayList<CryptoCoin> coins = response.body();
                    if (coins != null) {
                        MainActivity.this.coins = coins;
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
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
