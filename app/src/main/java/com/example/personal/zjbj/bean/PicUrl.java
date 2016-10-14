package com.example.personal.zjbj.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aersas on 2016/10/12.
 */
public class PicUrl implements Parcelable{
    public String url;

    protected PicUrl(Parcel in) {
        url = in.readString();
    }

    public static final Creator<PicUrl> CREATOR = new Creator<PicUrl>() {
        @Override
        public PicUrl createFromParcel(Parcel in) {
            return new PicUrl(in);
        }

        @Override
        public PicUrl[] newArray(int size) {
            return new PicUrl[size];
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
