package com.durzoflint.groceryaggregator.reviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.durzoflint.groceryaggregator.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {
    private Context context;
    private List<Review> list;

    ReviewAdapter(Context context, List<Review> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_review,
                viewGroup, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        holder.review.setText(list.get(position).review);
        holder.user.setText("-" + list.get(position).user);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
