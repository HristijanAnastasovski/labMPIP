package com.example.hristijan.moviesapp.persistence.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.AsyncTaskLoader;



import com.example.hristijan.moviesapp.models.MovieItem;
import com.example.hristijan.moviesapp.persistence.MovieItemDatabase;

import java.util.List;

public class MovieItemRepository {
    private final String DATABASE_NAME="movie_items";
    private MovieItemDatabase movieItemDatabase;

    public MovieItemRepository(Context context)
    {
        movieItemDatabase= Room.databaseBuilder(context,MovieItemDatabase.class,DATABASE_NAME).addMigrations(MIGRATION_2_3).build();
    }

    public LiveData<List<MovieItem>> listAllMovies(){
        return movieItemDatabase.movieDao().getAll();
    }

    public LiveData<List<MovieItem>> listMovieByTitle(String title)
    {
        return movieItemDatabase.movieDao().getMoviesByTitle(title);
    }

    public void insertItem(final MovieItem item)
    {
        new AsyncTask<Void,Void,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                movieItemDatabase.movieDao().insert(item);
                return null;
            }

        }.execute();


    }

    public void deleteAll()
    {
        new AsyncTask<Void,Void,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                movieItemDatabase.movieDao().deleteAll();
                return null;
            }

        }.execute();
    }


    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };





}
