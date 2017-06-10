package com.app.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.retrofitexample.adapter.RecyclerViewAdapter;
import com.app.retrofitexample.model.Country;
import com.app.retrofitexample.model.WorldpopulationItem;
import com.app.retrofitexample.retrofit.ApiClient;
import com.app.retrofitexample.retrofit.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    //private ArrayList<ActorsItem> arrayList = new ArrayList();
    //private ArrayList<AlbumList> arrayList = new ArrayList();
    private ArrayList<WorldpopulationItem> arrayList = new ArrayList();
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        getActorList();
    }

    private void getActorList() {

        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        /*Call<Actors> call = service.getModel();
        call.enqueue(new Callback<Actors>() {
            @Override
            public void onResponse(Call<Actors> call, Response<Actors> response) {
                arrayList.addAll(response.body().getActors());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Actors> call, Throwable t) {
                Log.e("MainActivity", "onFailure: error : " + t);
            }
        });*/

        /*Call<List<AlbumList>> call = service.getAlbum();
        call.enqueue(new Callback<List<AlbumList>>() {
            @Override
            public void onResponse(Call<List<AlbumList>> call, Response<List<AlbumList>> response) {
                arrayList.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AlbumList>> call, Throwable t) {
                Log.e("MainActivity", "onFailure: error: " + t);
            }
        });*/

        Call<Country> call = service.getCountry();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                arrayList.addAll(response.body().getWorldpopulation());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.e("MainActivity", "onFailure: error : " + t);
            }
        });
    }

    private void initViews() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}