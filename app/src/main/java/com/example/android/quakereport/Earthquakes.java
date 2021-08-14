package com.example.android.quakereport;

public class Earthquakes {

    private String mMagnitude;
    private String mPlace;
    private long mTime;

    public Earthquakes(String magnitude, String place, long time) {
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
    }

    public String getmPlace() {
        return mPlace;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public long getmTime() {
        return mTime;
    }
}
