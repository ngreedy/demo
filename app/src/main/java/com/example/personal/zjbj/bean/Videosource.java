package com.example.personal.zjbj.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aersas on 2016/10/12.
 */
public class Videosource implements Parcelable{
    public String uhd;
    public String hd;
    public String sd;
    public Videosource(){}
    protected Videosource(Parcel in) {
        uhd = in.readString();
        hd = in.readString();
        sd = in.readString();
    }

    public static final Creator<Videosource> CREATOR = new Creator<Videosource>() {
        @Override
        public Videosource createFromParcel(Parcel in) {
            return new Videosource(in);
        }

        @Override
        public Videosource[] newArray(int size) {
            return new Videosource[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uhd);
        parcel.writeString(hd);
        parcel.writeString(sd);
    }
}
