package ru.notasi.imagesgridjson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.notasi.imagesgridjson.utils.ImagesAdapter;
import ru.notasi.imagesgridjson.utils.NetworkUtils;

public class GridActivity extends AppCompatActivity {
    private List<String> mImagesLinks = new ArrayList<>();
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mGridView = findViewById(R.id.grid_view);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(GridActivity.this, ImageActivity.class)
                        .putExtra("Link", mImagesLinks.get(i)));
            }
        });

        SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh_grid);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getImages();
                refreshLayout.setRefreshing(false);
            }
        });

        getImages();
    }

    private void getImages() {
        Call<List<String>> imagesResponse = NetworkUtils.getInterface().loadImages();
        imagesResponse.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    mImagesLinks = response.body();
                    ImagesAdapter imagesAdapter = new ImagesAdapter(GridActivity.this, mImagesLinks);
                    mGridView.setAdapter(imagesAdapter);
                } else {
                    Toast.makeText(GridActivity.this, R.string.error_response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(GridActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}