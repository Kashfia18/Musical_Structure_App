package com.example.android.musical_structure_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the playlists category.
        Button playlists = findViewById(R.id.playlists);

        // Set a click listener on that View
        playlists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playlists category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the PlaylistsActivity.
                Intent playlistsIntent = new Intent(MainActivity.this, PlaylistsActivity.class);
                // Start the new activity
                startActivity(playlistsIntent);
            }
        });

        // Find the View that shows the browse category.
        Button browse = findViewById(R.id.browse);

        // Set a click listener on that View
        browse.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the browse category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the BrowseActivity.
                Intent browseIntent = new Intent(MainActivity.this, BrowseActivity.class);
                // Start the new activity
                startActivity(browseIntent);
            }
        });
    }
}
