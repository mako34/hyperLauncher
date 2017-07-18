package com.tkt.launcha;

/**
 * Created by n1120697 on 18/7/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tomerrosenfeld.customanalogclockview.CustomAnalogClock;

import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class ClockFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public ClockFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ClockFragment newInstance(int sectionNumber) {
        ClockFragment fragment = new ClockFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView1 = inflater.inflate(R.layout.fragment_main, container, false);

        CustomAnalogClock customAnalogClock = (CustomAnalogClock) rootView1.findViewById(R.id.analog_clock);
        customAnalogClock.setAutoUpdate(true);

        String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        Log.d("mk", "current device date/time :" + mydate);

        return rootView1;

    }
}