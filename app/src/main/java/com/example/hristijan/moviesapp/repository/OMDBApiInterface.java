package com.example.hristijan.moviesapp.repository;

import com.example.hristijan.moviesapp.models.MovieItem;
import com.example.hristijan.moviesapp.models.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OMDBApiInterface {

    @GET("/?apikey=dde96f5d&plot=short&")
    Call<MovieItem> getMovie(@Query ("t") String title);
}
