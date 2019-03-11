package com.example.hristijan.moviesapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.support.v7.widget.Toolbar;

import com.example.hristijan.moviesapp.adapters.CardViewAdapter;
import com.example.hristijan.moviesapp.clients.OmdbApiClient;
import com.example.hristijan.moviesapp.models.MovieItem;
import com.example.hristijan.moviesapp.models.MovieResponse;
import com.example.hristijan.moviesapp.persistence.repository.MovieItemRepository;
import com.example.hristijan.moviesapp.repository.OMDBApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //private List<MovieItem> data;
    private CardViewAdapter cardViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private MovieItemRepository movieItemRepository;
    private SearchView searchView=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        //data = new ArrayList<MovieItem>();
        movieItemRepository= new MovieItemRepository(MoviesActivity.this);
        initList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                syncData(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }



    public void initList(){
        recyclerView=findViewById(R.id.recyclerView);
        cardViewAdapter=new CardViewAdapter(MoviesActivity.this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardViewAdapter);
        /*LiveData<List<MovieItem>> items = movieItemRepository.listAllMovies();
        items.observe(MoviesActivity.this, new Observer<List<MovieItem>>() {
            @Override
            public void onChanged(@Nullable List<MovieItem> movieItems) {
                if(movieItems == null || movieItems.size()==0)
                    syncData("Avengers");
                else
                    cardViewAdapter.updateData(movieItems);
            }

        });*/
    }

    private void syncData(String searchTitle) {
        OMDBApiInterface service = OmdbApiClient.getRetrofit().create(OMDBApiInterface.class);

        service.getMovie(searchTitle).enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                if (response.isSuccessful()) {
                    //movieItemRepository.deleteAll();

                    movieItemRepository.insertItem(response.body());


                    cardViewAdapter.updateData(response.body());


                }
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {

            }
        });
    }



}
