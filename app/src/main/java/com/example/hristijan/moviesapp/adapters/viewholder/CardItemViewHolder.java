package com.example.hristijan.moviesapp.adapters.viewholder;

import com.bumptech.glide.Glide;
import com.example.hristijan.moviesapp.R;
import com.example.hristijan.moviesapp.models.MovieItem;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleTextView;
    private TextView releaseDateView;
    private View parent;

    public CardItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView=itemView.findViewById(R.id.image );
        this.titleTextView=itemView.findViewById(R.id.title);
        this.releaseDateView=itemView.findViewById(R.id.releaseDate);

    }
    public void bind(final MovieItem entity)
    {
        Glide.with(itemView.getContext())
                .load(entity.getPoster())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .crossFade()
                .into(getImageView());

        getTitleTextView().setText(entity.getTitle());
        getReleaseDateView().setText(entity.getReleased());

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public void setTitleTextView(TextView titleTextView) {
        this.titleTextView = titleTextView;
    }

    public TextView getReleaseDateView() {
        return releaseDateView;
    }

    public View getParent() {
        return parent;
    }

    public void setParent(View parent) {
        this.parent = parent;
    }

    public void setReleaseDateView(TextView releaseDateView) {
        this.releaseDateView = releaseDateView;

    }
}
