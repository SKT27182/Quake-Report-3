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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class EarthquakeAdapter extends ArrayAdapter<Earthquakes> {

    private static final String LOCATION_SEPARATOR = " of ";

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


        //Stored the place's value at current Position
        String originalLocation = currentPosition.getmPlace();
        //Created two String Variable
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            //Splited a Place String in the form of two array based on the  {@link LOCATION_SEPARATOR}
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            /**
             * Saved the first part to the locationOffset
             */

            locationOffset = parts[0] + LOCATION_SEPARATOR;
            /**
             * Saved the second part to the {@link primaryLocation}
             */

            primaryLocation = parts[1];
        } else {
            /**
             * Stored the default value
             */
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView = (TextView) earthquakeListView.findViewById(R.id.place1);
        primaryLocationView.setText(locationOffset);

        TextView locationOffsetView = (TextView) earthquakeListView.findViewById(R.id.place2);
        locationOffsetView.setText(primaryLocation);



        // Create a new Date object from the time of the earthquake
        Date dateObject = new Date(currentPosition.getmTime());

        TextView dateView = (TextView) earthquakeListView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) earthquakeListView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);



        return earthquakeListView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
