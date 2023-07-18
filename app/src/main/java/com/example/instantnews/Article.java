package com.example.instantnews;

import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("urlToImage")
    private String imageUrl;

    // Add other relevant fields as needed

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Add getters for other fields
}

