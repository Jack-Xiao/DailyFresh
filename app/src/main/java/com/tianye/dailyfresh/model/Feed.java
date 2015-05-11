package com.tianye.dailyfresh.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by lenovo on 2015/5/11.
 */
@Table(name = "feed")
public class Feed extends Model implements Parcelable{
    @Column(name = "title") String title;
    @Column(name = "auth") String auth;
    @Column(name = "img") String img;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.img);
        dest.writeString(this.auth);
    }
}
