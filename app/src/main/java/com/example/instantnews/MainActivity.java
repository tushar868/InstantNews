package com.example.instantnews;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static final String API_KEY = "92908ed3fc944070b78227b300c5eaab";

    private ListView newsListView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsListView = findViewById(R.id.newsListView);

        // Retrofit initialization
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of the NewsAPI interface
        NewsAPI newsAPI = retrofit.create(NewsAPI.class);

        // Make the API call to fetch news articles
        Call<NewsResponse> call = newsAPI.getTopHeadlines("us", API_KEY);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    NewsResponse newsResponse = response.body();
                    List<Article> articles = newsResponse.getArticles();

                    // Set up the adapter and bind it to the ListView
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, articles);
                    newsListView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

