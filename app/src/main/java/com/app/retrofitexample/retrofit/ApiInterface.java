package com.app.retrofitexample.retrofit;

import com.app.retrofitexample.model.AlbumList;
import com.app.retrofitexample.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nct119 on 24/5/17.
 */

public interface ApiInterface {

/*    @GET("jsonActors")
    Call<Actors> getModel();*/

    @GET("photos")
    Call<List<AlbumList>> getAlbum();

    @GET("jsonparsetutorial.txt")
    Call<Country> getCountry();
}