package com.leaderliang.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String userId;

    private String userName;

    private String age;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.userName);
        dest.writeString(this.age);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.userId = in.readString();
        this.userName = in.readString();
        this.age = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
