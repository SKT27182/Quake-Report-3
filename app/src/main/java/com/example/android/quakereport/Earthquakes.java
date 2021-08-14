package com.example.android.quakereport;

public class Earthquakes {

    private String mMagnitude;
    private String mPlace;
    private String mTime;

    public Earthquakes(String magnitude, String place, String time) {
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

    public String getmTime() {
        return mTime;
    }
}
