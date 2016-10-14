package com.example.personal.zjbj.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aersas on 2016/10/12.
 */
public class Thumbnails implements Parcelable{
    public PicUrl big;
    public PicUrl medium;
    public PicUrl small;
    public PicUrl x;
    public PicUrl y;
    public String url;

    protected Thumbnails(Parcel in) {
        url = in.readString();
    }

    public static final Creator<Thumbnails> CREATOR = new Creator<Thumbnails>() {
        @Override
        public Thumbnails createFromParcel(Parcel in) {
            return new Thumbnails(in);
        }

        @Override
        public Thumbnails[] newArray(int size) {
            return new Thumbnails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
    }
}
