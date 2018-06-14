package com.example.android.musical_structure_app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Song represents the details of a song, displayed in the playlist.
 * It contains the song Name, Singer name and icon of the song.
 */
public class Song implements Parcelable {

    /**
     * Name of the song
     */
    private final String mSongName;

    /**
     * Name of the singer for each song
     */
    private final String mSingerName;

    /**
     * Resource Id of the song icon for each song.
     */
    private final int mImageResourceId;

    /**
     * Constructor-creates a new Song object.
     *
     * @param songName        is the song name
     * @param singerName      is the singer name
     * @param imageresourceId is the image resource id.
     */
    public Song(String songName, String singerName, int imageresourceId) {
        mSongName = songName;
        mSingerName = singerName;
        mImageResourceId = imageresourceId;
    }

    /**
     * get the song name
     *
     * @return String type
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * get the singer name.
     *
     * @return String type
     */
    public String getSingerName() {
        return mSingerName;
    }

    /**
     * get the song image resource id.
     *
     * @return int type
     */
    public int getImageResourceID() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //write object values to parcel for storage. In this method we write all teh properties of Song object
    //to parcel in preparation of transfer. write method is used to add each of the properties.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mSingerName);
        dest.writeInt(mImageResourceId);

    }

    //constructor used for parcel. Called in the receiving activity, where we will collect values.
    private Song(Parcel parcel) {
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
