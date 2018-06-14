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
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class PlaylistsActivity extends AppCompatActivity {

    //Declare a listView object for list of songs.
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        //Along with updating the Android Manifest with the parent Activity this line is added in this activity
        //to enable the arrow in the Action bar as the up arrow. IWhen clicked it will navigate to the parent activity
        //which is the Main activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //create an arrayList of songs
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("song 1", "singer 1", R.drawable.song_icon));
        songs.add(new Song("song 2", "singer 2", R.drawable.song_icon));
        songs.add(new Song("song 3", "singer 3", R.drawable.song_icon));
        songs.add(new Song("song 4", "singer 4", R.drawable.song_icon));
        songs.add(new Song("song 5", "singer 5", R.drawable.song_icon));
        songs.add(new Song("song 6", "singer 6", R.drawable.song_icon));
        songs.add(new Song("song 7", "singer 7", R.drawable.song_icon));
        songs.add(new Song("song 8", "singer 9", R.drawable.song_icon));
        songs.add(new Song("song 10", "singer 10", R.drawable.song_icon));
        songs.add(new Song("song 11", "singer 11", R.drawable.song_icon));

        // Create a custom ArrayAdapter, SongAdapter, whose data source is an ArrayList of songs. The
        // adapter knows how to create layouts for each item in the list, using the
        // list_item.xml layout resource defined in the layout.
        // This list item layout contains two ImageViews and 2 TextViews, which the adapter will set to
        // display the song icon, play icon and song name, singer name respectively.
        SongAdapter playlistsAdapter = new SongAdapter (this,songs);

        // Find the ListView object in the view hierarchy of the Activity.
        // There should be a ListView with the view ID called list, which is declared in the
        // song_list.xml file.
        listView = findViewById(R.id.list);

        // Make the ListView use the SongAdapter we created above, so that the
        // ListView will display list items for each song in the list of songs.
        // Do this by calling the setAdapter method on the ListView object and pass in
        // 1 argument, which is the SongAdapter with the variable name playlistsAdapter.
        listView.setAdapter(playlistsAdapter);

        //set a click listener on the list items of the AdapterView (listView).
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when the each of list items is clicked on.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                Intent intent = new Intent(PlaylistsActivity.this, NowPlayingActivity.class);
                //Transfer data of the listView from this activity to Now Playing activity,
                //for playing the song that is clicked on
                intent.putExtra("Mysong", (Parcelable) listItem);
                startActivity(intent);
            }
        });

    }
}
