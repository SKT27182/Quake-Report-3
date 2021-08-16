package com.example.android.quakereport;

public class Earthquakes {

    private Double mMagnitude;
    private String mPlace;
    private long mTime;

    public Earthquakes(Double magnitude, String place, long time) {
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
    }

    public String getmPlace() {
        return mPlace;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public long getmTime() {
        return mTime;
    }
}
