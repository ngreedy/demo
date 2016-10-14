package com.example.personal.zjbj.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aersas on 2016/10/12.
 */
public class Thumbnail implements Parcelable{
    public Thumbnails thumbnail;

    protected Thumbnail(Parcel in) {
    }

    public static final Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {
        @Override
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        @Override
        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
