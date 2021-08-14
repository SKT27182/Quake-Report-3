package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquakes> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquakes> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View earthquakeListView = convertView;

        if (earthquakeListView == null) {
            earthquakeListView = LayoutInflater.from(getContext()).inflate(R.layout.list_quake, parent, false);
        }

        Earthquakes currentPosition = getItem(position);


        TextView magnitudeTextView = (TextView) earthquakeListView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentPosition.getmMagnitude());

        TextView placeTextView = (TextView) earthquakeListView.findViewById(R.id.place);
        placeTextView.setText(currentPosition.getmPlace());

        TextView timeTextView = (TextView) earthquakeListView.findViewById(R.id.time);
        timeTextView.setText(currentPosition.getmTime());


        return earthquakeListView;
    }
}
