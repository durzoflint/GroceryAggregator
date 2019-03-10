package com.durzoflint.groceryaggregator.reviews;

public class Review {
    int stars;
    String review, user;

    public Review(int stars, String review, String user) {
        this.stars = stars;
        this.review = review;
        this.user = user;
    }
}