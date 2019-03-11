package com.example.hristijan.moviesapp.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.hristijan.moviesapp.models.MovieItem;

import java.util.List;

@Dao
public interface MovieDao {


    @Query("SELECT * FROM movie_item c ORDER BY c.id")
    LiveData<List<MovieItem>> getAll();

    @Insert
    void insert(MovieItem item);

    @Update
    void update(MovieItem item);

    @Delete
    void delete(MovieItem item);

    @Query("DELETE from movie_item")
    void deleteAll();

    @Query("SELECT * FROM movie_item WHERE title=:title")
    LiveData<List<MovieItem>> getMoviesByTitle(String title);
}
