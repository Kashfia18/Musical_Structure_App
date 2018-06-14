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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Objects;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_grid);
        //Along with updating the Android Manifest with the parent Activity this line is added in this activity
        //to enable the arrow in the Action bar as the up arrow. IWhen clicked it will navigate to the parent activity
        //which is the Main activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //create an arrayList of albums
        ArrayList<String> albums = new ArrayList<>();
        albums.add("Classical");
        albums.add("Romance");
        albums.add("Comedy");
        albums.add("Rock");
        albums.add("Party");
        albums.add("Pop");
        albums.add("Hip-hop");
        albums.add("Kids");


        // Create an ArrayAdapter of strings, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the grid, using the
        // browse_item.xml layout resource defined in the layout.
        // This grid item layout contains a single TextView, which the adapter will set to
        // display a single album.
        ArrayAdapter<String> albumListAdapter = new ArrayAdapter<>(this, R.layout.browse_item, albums);

        // Find the gridView object in the view hierarchy of the Activity.
        // There should be a gridView with the view ID called grid, which is declared in the
        // browse_grid.xml file.
        GridView gridView = findViewById(R.id.grid);

        // Make the gridView} use the ArrayAdapter we created above, so that the
        // gridView will display list items for each album in the list of albums.
        // Do this by calling the setAdapter method on the gridView object and pass in
        // 1 argument, which is the ArrayAdapter with the variable name albumListAdapter.
        gridView.setAdapter(albumListAdapter);
    }
}
