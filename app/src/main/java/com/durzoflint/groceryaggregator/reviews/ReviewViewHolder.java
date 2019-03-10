package com.durzoflint.groceryaggregator.reviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.durzoflint.groceryaggregator.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    TextView review, user;
    ImageView star1, star2, star3, star4, star5;

    public ReviewViewHolder(@NonNull View itemView) {
        super(itemView);

        review = itemView.findViewById(R.id.review);
        user = itemView.findViewById(R.id.user);
        star1 = itemView.findViewById(R.id.star1);
        star2 = itemView.findViewById(R.id.star2);
        star3 = itemView.findViewById(R.id.star3);
        star4 = itemView.findViewById(R.id.star4);
        star5 = itemView.findViewById(R.id.star5);
    }
}