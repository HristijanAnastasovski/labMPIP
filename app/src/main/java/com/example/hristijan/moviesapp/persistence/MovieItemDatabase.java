package com.example.hristijan.moviesapp.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.hristijan.moviesapp.models.MovieItem;
import com.example.hristijan.moviesapp.persistence.dao.MovieDao;

@Database(entities = {MovieItem.class},version = 3,exportSchema = false)
public abstract class MovieItemDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}
