package com.salton123.livevideo;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by salton on 2018/1/1.
 */

public class LiveBroadcastSource implements Parcelable {
    public String title;
    public String url ;


    public LiveBroadcastSource(String title, String url) {
        this.title = title;
        this.url = url;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.url);
    }

    protected LiveBroadcastSource(Parcel in) {
        this.title = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<LiveBroadcastSource> CREATOR = new Parcelable.Creator<LiveBroadcastSource>() {
        @Override
        public LiveBroadcastSource createFromParcel(Parcel source) {
            return new LiveBroadcastSource(source);
        }

        @Override
        public LiveBroadcastSource[] newArray(int size) {
            return new LiveBroadcastSource[size];
        }
    };
}
