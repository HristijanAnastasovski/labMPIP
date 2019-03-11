/*
package com.example.hristijan.moviesapp.services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.Nullable;

import com.example.hristijan.moviesapp.clients.OmdbApiClient;
import com.example.hristijan.moviesapp.models.MovieItem;
import com.example.hristijan.moviesapp.models.MovieResponse;
import com.example.hristijan.moviesapp.persistence.repository.MovieItemRepository;
import com.example.hristijan.moviesapp.repository.OMDBApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DownloadMoviesService extends IntentService {
    public static final String DATABASE_UPDATED="com.example.hristijan.moviesapp.DATABASE_UPDATED";
    private OMDBApiInterface omdbApiInterface;
    private MovieItemRepository movieItemRepository;

    public DownloadMoviesService()
    {
        super("Download and save movies");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Retrofit retrofit = OmdbApiClient.getRetrofit();
        omdbApiInterface=retrofit.create(OMDBApiInterface.class);
        movieItemRepository=new MovieItemRepository(DownloadMoviesService.this);
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        omdbApiInterface.getMovies(intent.getStringExtra("title"))
                .enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if(response.isSuccessful())
                        {
                            saveResultsInDb(response.body().getItems());
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {

                    }
                });


    }

    private void saveResultsInDb(List<MovieItem> items)
    {
        for(MovieItem item: items)
        {
            movieItemRepository.insertItem(item);
        }

    }
}
*/
