package com.lsy.androidutils;

import android.os.Parcel;
import android.os.Parcelable;

public class Test implements Parcelable {
    private String people1;
    private String people2;

    public Test(String jack, String rose) {
        people1 = jack;
        people2 = rose;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.people1);
        dest.writeString(this.people2);
    }

    protected Test(Parcel in) {
        this.people1 = in.readString();
        this.people2 = in.readString();
    }

    public static final Parcelable.Creator<Test> CREATOR = new Parcelable.Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel source) {
            return new Test(source);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };
}
