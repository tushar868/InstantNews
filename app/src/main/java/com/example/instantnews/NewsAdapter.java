package com.example.instantnews;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.squareup.picasso.Picasso;


public class NewsAdapter extends BaseAdapter {
    private final Context context;
    private final List<Article> articles;

    public NewsAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int position) {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_article, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.photoImageView = convertView.findViewById(R.id.photoImageView);
            viewHolder.titleTextView = convertView.findViewById(R.id.titleTextView);
            viewHolder.descriptionTextView = convertView.findViewById(R.id.descriptionTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Article article = articles.get(position);
        viewHolder.titleTextView.setText(article.getTitle());
        viewHolder.descriptionTextView.setText(article.getDescription());


        // Load the image into the ImageView using Picasso
        Picasso.get()
                .load(article.getImageUrl())
                .placeholder(R.drawable.placeholder_image) // Optional: Placeholder image while loading
                .error(R.drawable.error_image) // Optional: Error image if unable to load
                .into(viewHolder.photoImageView);

        convertView.setOnClickListener(v -> {
            // Handle the click event, e.g., open the full news details
            // You can implement your logic here, such as starting a new activity
            // or showing a dialog with the full news information
            openNewsDetails(article);
        });

        return convertView;
    }




    private static class ViewHolder {
        ImageView photoImageView;
        TextView titleTextView;
        TextView descriptionTextView;
    }
    private void openNewsDetails(Article article) {
        // Implement your logic here to open the full news details
        // You can start a new activity, pass the article data, and display the full information
    }
}

