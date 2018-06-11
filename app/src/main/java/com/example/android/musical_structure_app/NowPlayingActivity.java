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
import android.support.v7.app.AppCompatActivity;
import android.util.Property;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //collect our intent
        Intent intent = getIntent();
        Song song = intent.getParcelableExtra("Mysong");

        TextView mSongName = findViewById(R.id.playing_song_name);
        TextView mSingerName = findViewById(R.id.playing_singer_name);
        ImageView mImageResourceId= findViewById(R.id.playing_song_item_icon);

        //now collect all property values
        mSongName.setText("Song Name " + song.getSongName());
        mSingerName.setText("Singer Name " + song.getSingerName());
        mImageResourceId.setImageResource(song.getImageResourceID());
    }
}