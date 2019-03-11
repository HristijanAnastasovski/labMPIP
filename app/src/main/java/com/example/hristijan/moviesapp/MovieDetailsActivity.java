package com.example.hristijan.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MovieDetailsActivity extends AppCompatActivity {
        TextView titleView;
        TextView genreView;
        TextView yearView;
        TextView ratedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_layout);

        Intent intent = getIntent();
        String title = intent.getStringExtra(getString(R.string.title_details));
        String genre = intent.getStringExtra(getString(R.string.genre_details));
        String year = intent.getStringExtra(getString(R.string.year_details));
        String rated = intent.getStringExtra(getString(R.string.rated_details));

        titleView = findViewById(R.id.titleDetailsInput);
        genreView = findViewById(R.id.genreDetailsInput);
        yearView = findViewById(R.id.yearDetailsInput);
        ratedView = findViewById(R.id.ratedDetailsInput);

        titleView.setText(title);
        genreView.setText(genre);
        yearView.setText(year);
        ratedView.setText(rated);


    }



}
