package com.durzoflint.groceryaggregator.reviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.durzoflint.groceryaggregator.R;
import com.durzoflint.groceryaggregator.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        setTitle("");

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupRecyclerView(getReviews());
    }

    private List<Review> getReviews() {
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(new Review(1, "Something Good", "Developer"));
        reviewList.add(new Review(2, "Something Better", "Programmer"));
        reviewList.add(new Review(3, "Something Even Better", "Coder"));
        reviewList.add(new Review(4, "Something too Good", "Tester"));
        reviewList.add(new Review(5, "Best thing that there is", "Client"));
        return reviewList;
    }

    private void setupRecyclerView(List<Review> reviewList) {
        RecyclerView reviewRecyclerView = findViewById(R.id.review_recycler_view);
        reviewRecyclerView.setAdapter(new ReviewAdapter(this, reviewList));
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }
}