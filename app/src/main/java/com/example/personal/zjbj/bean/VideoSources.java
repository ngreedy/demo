package com.example.personal.zjbj.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.personal.zjbj.util.StringUtils;

/**
 * Created by aersas on 2016/10/12.
 */
public class VideoSources implements Parcelable {
    public int type;
    public int id;
    public String provider;
    public String source_url;
    public int size;
    public String name;
    public int duration;
    public String created_at;
    public String updated_at;
    public String quality;
    public String direct_url;
    public String bigPic;
    public String smallPic;
    public String des;
    public int plays_count;


    protected VideoSources(Parcel in) {
        type = in.readInt();
        id = in.readInt();
        provider = in.readString();
        source_url = in.readString();
        size = in.readInt();
        name = in.readString();
        duration = in.readInt();
        created_at = in.readString();
        updated_at = in.readString();
        quality = in.readString();
        direct_url = in.readString();
        bigPic = in.readString();
        smallPic = in.readString();
        des = in.readString();
        plays_count = in.readInt();
    }

    public static final Parcelable.Creator<VideoSources> CREATOR = new Parcelable.Creator<VideoSources>() {
        @Override
        public VideoSources createFromParcel(Parcel in) {
            return new VideoSources(in);
        }

        @Override
        public VideoSources[] newArray(int size) {
            return new VideoSources[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(type);
        parcel.writeInt(id);
        parcel.writeString(provider);
        parcel.writeString(source_url);
        parcel.writeInt(size);
        parcel.writeString(name);
        parcel.writeInt(duration);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
        parcel.writeString(quality);
        parcel.writeString(direct_url);
        parcel.writeString(bigPic);
        parcel.writeString(smallPic);
        parcel.writeString(des);
        parcel.writeInt(plays_count);
    }

    public String getVideoTitle() {
        return name;
    }

    public String getVideoDes() {
        return des;
    }

    public String getVideoDuration() {
        return StringUtils.timeFormatter(duration);
    }

    public String getVideoThumbnail() {
        return bigPic;
    }

    public String getSmallVideoThumbnail() {
        return smallPic;
    }

    public String getVideoId() {
        return String.valueOf(id);
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        return source_url;
    }
}
