package ru.notasi.imagesgridjson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh_image);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getImage();
                refreshLayout.setRefreshing(false);
            }
        });

        getImage();
    }

    private void getImage() {
        ImageView imageView = findViewById(R.id.image_full);
        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String link = intent.getStringExtra("Link");
            Glide.with(this).load(link)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(false)
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_image_not_supported_24)
                    .into(imageView);
        }
    }
}