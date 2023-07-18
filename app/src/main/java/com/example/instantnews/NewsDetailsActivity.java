package com.example.instantnews;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailsActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        // Retrieve the Article object from the intent
        Intent intent = getIntent();
        if (intent != null) {
            Article article = intent.getParcelableExtra("article");
            if (article != null) {
                // Display the article details
                titleTextView.setText(article.getTitle());
                descriptionTextView.setText(article.getDescription());
            }
        }
    }
}


