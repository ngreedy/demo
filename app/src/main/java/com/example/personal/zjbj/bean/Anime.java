package com.example.personal.zjbj.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aersas on 2016/10/12.
 */
public class Anime implements Parcelable{
    public int type = 0;
    public String Id;
    public String Author;
    public String Year;
    public String Duration;
    public String VideoUrl;
    public String VideoSite;
    public String Brief;
    public String HomePic;
    public String DetailPic;
    public String Name;
    public Videosource VideoSource;
    public Anime(){}

    protected Anime(Parcel in) {
        type = in.readInt();
        Id = in.readString();
        Author = in.readString();
        Year = in.readString();
        Duration = in.readString();
        VideoUrl = in.readString();
        VideoSite = in.readString();
        Brief = in.readString();
        HomePic = in.readString();
        DetailPic = in.readString();
        Name = in.readString();
        VideoSource = in.readParcelable(Videosource.class.getClassLoader());
    }

    public static final Parcelable.Creator<Anime> CREATOR = new Parcelable.Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    public String getVideoTitle() {
        return Name;
    }

    public String getVideoDes() {
        return Brief;
    }

    public String getVideoDuration() {
        return Duration;
    }

    public String getVideoThumbnail() {
        return DetailPic;
    }

    public String getSmallVideoThumbnail() {
        return null;
    }

    public String getVideoId() {
        return Id;
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        if (VideoSource != null) {
            return VideoSource.sd;
        }
        return "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(type);
        parcel.writeString(Id);
        parcel.writeString(Author);
        parcel.writeString(Year);
        parcel.writeString(Duration);
        parcel.writeString(VideoUrl);
        parcel.writeString(VideoSite);
        parcel.writeString(Brief);
        parcel.writeString(HomePic);
        parcel.writeString(DetailPic);
        parcel.writeString(Name);
        parcel.writeParcelable(VideoSource, i);
    }
}
