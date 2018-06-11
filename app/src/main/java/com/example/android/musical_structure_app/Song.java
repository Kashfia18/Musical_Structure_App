package com.example.android.musical_structure_app;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

/**
 * {@link Song} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Song implements Parcelable {

    /**
     * Default translation of the word.
     */
    private String mSongName;

    /**
     * Miwok translation of the word
     */
    private String mSingerName;

    private int mImageResourceId;

    /**
     * Constructor-creates a new word object.
     *
     * @param songName        is the word in Miwok Language
     * @param singerName      is the word in a language the user is already familiar with.
     * @param imageresourceId is the word in a language the user is already familiar with.
     */

    public Song(String songName, String singerName, int imageresourceId) {
        mSongName = songName;
        mSingerName = singerName;
        mImageResourceId = imageresourceId;
    }

    /**
     * get the default translation of the word.
     *
     * @return String type
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * get the Miwok translation of the word
     *
     * @return String type
     */
    public String getSingerName() {
        return mSingerName;
    }

    public int getImageResourceID() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //write object values to parcel for storage
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mSingerName);
        dest.writeInt(mImageResourceId);

    }

    //constructor used for parcel
    public Song(Parcel parcel) {
        mSongName = parcel.readString();
        mSingerName = parcel.readString();
        mImageResourceId = parcel.readInt();
    }

    //used when un-parceling our parcel (creating the object)
    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {

        @Override
        public Song createFromParcel(Parcel parcel) {
            return new Song(parcel);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[0];
        }
    };
}
