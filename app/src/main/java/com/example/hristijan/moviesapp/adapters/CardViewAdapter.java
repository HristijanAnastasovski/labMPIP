package com.example.hristijan.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristijan.moviesapp.MovieDetailsActivity;
import com.example.hristijan.moviesapp.R;
import com.example.hristijan.moviesapp.adapters.viewholder.CardItemViewHolder;
import com.example.hristijan.moviesapp.models.MovieItem;
import com.example.hristijan.moviesapp.models.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardItemViewHolder> {
    private List<MovieItem> data;
    private Context context;

    public CardViewAdapter( Context context) {
        this.data = new ArrayList<>();
        this.context = context;
    }



    @NonNull
    @Override
    public CardItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.card_view_item,viewGroup,false);
        CardItemViewHolder holder = new CardItemViewHolder(view);
        holder.setParent(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull CardItemViewHolder cardItemViewHolder, int i) {

        MovieItem entity = data.get(i);
        cardItemViewHolder.bind(entity);
        cardItemViewHolder.getParent().setOnClickListener(v-> {
            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra(context.getString(R.string.title_details), entity.getTitle());
            intent.putExtra(context.getString(R.string.genre_details), entity.getGenre());
            intent.putExtra(context.getString(R.string.year_details),entity.getYear());
            intent.putExtra(context.getString(R.string.rated_details),entity.getRated());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if(data!=null)
            return data.size();
        return 0;
    }

    public void updateData(MovieItem data) {
        this.data.add(data);
        notifyDataSetChanged();

    }

    public void getDetails(View view)
    {

    }

}
