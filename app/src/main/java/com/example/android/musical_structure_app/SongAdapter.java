package com.example.android.musical_structure_app;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

class SongAdapter extends ArrayAdapter <Song>{

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the Arraylist is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param songs A List of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and two ImageViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID song_item_icon
        ImageView iconImageView = listItemView.findViewById(R.id.song_item_icon);
        // Get the image resource ID from the currentSong object and
        // set the image to iconImageView
        iconImageView.setImageResource(Objects.requireNonNull(currentSong).getImageResourceID());

        // Find the TextView in the list_item.xml layout with the ID song_name
        TextView songNameTextView = listItemView.findViewById(R.id.song_name);
        // Get the song name from the currentSong object and
        // set this text on the songName TextView
        songNameTextView.setText(currentSong.getSongName ());

        // Find the TextView in the list_item.xml layout with the ID singer_name
        TextView SingerNameTextView = listItemView.findViewById(R.id.singer_name);
        // Get the singer name from the currentSong object and
        // set this text on the singerName TextView
        SingerNameTextView.setText(currentSong.getSingerName ());


        // Return the whole list item layout (containing 2 TextViews and 2 ImageViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
