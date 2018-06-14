/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.musical_structure_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Property;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        //Along with updating the Android Manifest with the parent Activity this line is added in this activity
        //to enable the arrow in the Action bar as the up arrow. IWhen clicked it will navigate to the parent activity
        //which is the playlists activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find the TextViews and ImageView objects in the view hierarchy of the Activity.
        // These views are declared in the activity_play.xml file.
        TextView mSongName = findViewById(R.id.playing_song_name);
        TextView mSingerName = findViewById(R.id.playing_singer_name);
        ImageView mImageResourceId = findViewById(R.id.playing_song_item_icon);

        //collect the intent object
        Intent intent = getIntent();
        // the constructor is called and a Song instance is created
        Song song = intent.getParcelableExtra("Mysong");

        //now collect all values of song class that was converted to a parcel.
        // Also the values are set to the respective views.
        mSongName.setText("Song Name: " + song.getSongName());
        mSingerName.setText("Singer Name: " + song.getSingerName());
        mImageResourceId.setImageResource(song.getImageResourceID());
    }
    //This method is called when the back button is clicked.
    // This way it is guarantee that the back button will act the same way as the Up Button.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}