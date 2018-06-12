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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //create an arrayList of songs
        ArrayList<Song> songs = new ArrayList<Song>();
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

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        SongAdapter playlistsAdapter = new SongAdapter (this,songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml file.
        final ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of songs.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(playlistsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                Intent intent = new Intent(PlaylistsActivity.this, NowPlayingActivity.class);
                intent.putExtra("Mysong", (Parcelable) listItem);
                intent.putExtra("positon",position);
                startActivity(intent);
            }
        });

    }
}
